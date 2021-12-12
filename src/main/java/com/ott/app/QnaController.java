package com.ott.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.ott.Util.Paging_admin;
import com.ott.bbs.vo.QnaVO;
import com.ott.dao.QnaDAO;
import com.ott.user.vo.UserVO;



@Controller
public class QnaController {

	@Autowired
	private QnaDAO q_dao;
	@Autowired
	HttpServletRequest request;

	int nowPage;
	int rowTotal;
	int blockList = 7; // 한 페이지당 표현될 게시물 수
	int blockPage = 3;// 한 블럭당 표현될 페이지 수

	// =========== QNA 게시판 LIST ===========
	@RequestMapping("/QNA.list")
	public ModelAndView list(String cPage, String bname) {
		ModelAndView mv = new ModelAndView();
		String pageName = "QNA.list?";
		
		
		if (cPage == null)
			nowPage = 1;
		else
			nowPage = Integer.parseInt(cPage);

		if (bname == null)
			bname = "QNA";

		rowTotal = q_dao.getTotalCount(bname);// 전체 게시물 수
		
		// 페이징 처리를 위한 객체 생성
		Paging_admin page = new Paging_admin(nowPage, rowTotal, blockList, blockPage, pageName);
		
		int begin = page.getBegin();
		int end = page.getEnd();
		
		QnaVO[] ar = q_dao.getList(begin, end, bname);
		
		/*
	    UserVO[] uar = null; List<UserVO> list = new ArrayList<UserVO>();
		 */
		
		for(int i=0; i<ar.length; i++) {
			String idx = ar[i].getU_idx(); 		//	게시판 테이블에서 u_idx값을 가져온다.
			UserVO u_vo = q_dao.getUvo(idx);	//	회원 테이블에서 FK인 u_idx의 값이 
												//	게시판 테이블의 u_idx 값이 같은 vo를 가져온다
			String name = u_vo.getU_name();		
			ar[i].setU_name(name);

		}
		
		
		//=========== JSP에서 표현해야 하므로 ar을 mv에 저장한다. ===========
		mv.addObject("ar", ar);
		mv.addObject("nowPage", nowPage);
		mv.addObject("blockList", blockList);
		mv.addObject("rowTotal", rowTotal);
		mv.addObject("pageCode", page.getSb().toString());
		mv.setViewName("bbs/bbs_qna_list");// views/list.jsp

		return mv;
	}

	// =========== QNA 게시물 확인 =========== 
	@RequestMapping("/QNA.view")
	public ModelAndView view(String rb_idx, String cPage) {
		ModelAndView mv = new ModelAndView();

		QnaVO q_vo = q_dao.getBbs(rb_idx);
		UserVO u_vo = q_dao.getUvo(q_vo.getU_idx());
		
		mv.addObject("q_vo", q_vo);
		mv.addObject("u_vo", u_vo);
		
		mv.setViewName("bbs/bbs_qna_view");

		return mv;
	}

	//=========== 글 쓰기 ===========
	
	/*
	  @RequestMapping("/QNA.write") 
	  public String write() {
	  
	  return "bbs/bbs_qna_write"; }
	 */
	@RequestMapping("/QNA.write")
	public ModelAndView writeView() {
		ModelAndView mv = new ModelAndView();
		
		HttpSession session = request.getSession();
		UserVO uvo =  (UserVO)session.getAttribute("uvo");
		String u_id = uvo.getU_id();
		//System.out.println("u_id:"+u_id);
		UserVO u_vo2 = q_dao.getUvo2(u_id);
		String u_idx = u_vo2.getU_idx();
		UserVO u_vo1 = q_dao.getUvo(u_idx);
		
		String name = u_vo1.getU_name();
		//String u_name = u_vo2.getU_name();
		// System.out.println("u_idx:"+u_idx);
		// System.out.println("u_name:"+u_name);
		mv.addObject("u_name",name);
		mv.setViewName("bbs/bbs_qna_write");
		return mv;
	}
	
	@RequestMapping(value = "/QNA.write", method = RequestMethod.POST)
	public ModelAndView write(QnaVO q_vo, HttpServletRequest request) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		
		String u_id = request.getParameter("u_id");	//	session에 저장된 u_id
		String content = request.getParameter("content");
		String subject = request.getParameter("subject");
		String secret = request.getParameter("secret");

		
//		System.out.println("u_id  : "+u_id);
//		System.out.println("content  : "+content);
		
		q_vo.setBname("QNA");
		q_vo.setU_id(u_id);
		q_vo.setContent(content);
		q_vo.setSecret(secret);
		q_vo.setSubject(subject);
		
		q_dao.add(q_vo); // DB에 저장!!!!!!!!!!!
		
		

		
		
	
		mv.setViewName("redirect:/QNA.list");
		

		return mv;
	}
	
	
	//=========== 게시글 삭제 ===========
	@RequestMapping("/QNA.delete")
	public String del(String rb_idx, String cPage) {
		
		q_dao.delBbs(rb_idx);
		
		return "redirect:/QNA.list?cPage="+cPage;
	}
	
	//============ 게시글 수정하기 =============
	
	@RequestMapping("/QNA.edit")
	public ModelAndView edit(String rb_idx) {
	//public String edit(String rb_idx, Model m) {
		
		ModelAndView mv = new ModelAndView();
		
		QnaVO q_vo = q_dao.getBbs(rb_idx);
		UserVO u_vo = q_dao.getUvo(q_vo.getU_idx());
		mv.addObject("q_vo", q_vo);
		mv.addObject("u_vo", u_vo);// VIEW의 수정화면에서 표현해야 하므로 여기서 저장함!
		mv.setViewName("/bbs/bbs_qna_edit");
		return mv;
		
	
		
//		QnaVO q_vo = q_dao.getBbs(rb_idx);
//		
//		m.addAttribute("q_vo", q_vo); // Model은 request에 저장됨!
//									//forward시 사용가능함!		
//		return "bbs/bbs_qna_edit";
		
	}
	
	@RequestMapping(value="/QNA.edit1", method=RequestMethod.POST)
	public ModelAndView edit(QnaVO q_vo, String cPage, HttpServletRequest request)throws Exception{
		ModelAndView mv = new ModelAndView();
		
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String rb_idx = q_vo.getRb_idx();
			
			

			q_vo.setSubject(subject);
			q_vo.setContent(content);
			
			
			q_dao.edit(q_vo); // DB에 저장!!!!!!!!!!!

			q_vo = q_dao.getBbs(q_vo.getRb_idx());
			//System.out.println(q_vo);
			mv.addObject("q_vo", q_vo);
			//mv.setViewName("redirect:/QNA.list");
			//mv.setViewName("redirect:/QNA.view");
			mv.setViewName("redirect:/QNA.view?rb_idx="+q_vo.getRb_idx()+"&cPage="+cPage);
			
			//mv.setViewName("/QNA.view");
		
		return mv;
	}
	
}
