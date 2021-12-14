package com.ott.app;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.Paging_Review;
import com.ott.platform.vo.PlatFormVO;
import com.ott.review.dao.ReviewDAO;
import com.ott.review.vo.ReviewVO;
import com.ott.user.vo.UserVO;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDAO r_dao;
	
	public final int block_list = 10;
	public final int block_page = 5;
	int nowPage;
	
	@RequestMapping("/showReview")
	public ModelAndView review(@RequestParam(value="ott_idx")String ott_idx, String cPage) {
		System.out.println(">>>>reviewList.do&"+ott_idx);
		
		ModelAndView mv = new ModelAndView();
		
		PlatFormVO vo = r_dao.viewContent(ott_idx);
		int cnt = r_dao.review_count(ott_idx);
		
		//페이징
				if(cPage == null)
					nowPage = 1;
				else
					nowPage = Integer.parseInt(cPage);
				
				
				Paging_Review page = new Paging_Review(nowPage, cnt, block_list, block_page, ott_idx);
				
				int begin = page.getBegin();
				int end = page.getEnd();
				
				ReviewVO[] rvo = r_dao.getReview(begin, end, ott_idx);
				
				
				if(cnt != 0){
					double rating = r_dao.rating(ott_idx);
					mv.addObject("rating",rating);
				}
				
				mv.addObject("vo", vo);
				mv.addObject("rvo",rvo);
				mv.addObject("r_cnt",cnt);
				mv.addObject("nowPage",nowPage);
				mv.addObject("blockList",block_list);
				mv.addObject("pageCode",page.getSb().toString());
				
				
				mv.setViewName("review");
				
				return mv;
			}
		
	
	@RequestMapping(value="/review_add", method=RequestMethod.POST)
	public ModelAndView review_add(UserVO uvo, ReviewVO rvo, String now_page) {
		System.out.println(">>>>reviewInsert.do"+"/"+uvo.getU_id()+"/ <---- U_ID");
		ModelAndView mv = new ModelAndView();
		
		UserVO uvo2 = r_dao.get_u_idx(uvo);
		
		System.out.println("u_idx: "+uvo2.getU_idx());
		
		rvo.setU_idx(uvo2.getU_idx());
		
		r_dao.add_review(rvo);
		
		
		mv.setViewName("redirect:/showReview?ott_idx="+now_page);
		return mv;
	}
	

	
	@RequestMapping("/review_del")
	@ResponseBody
	public String review_del(ReviewVO rvo) {
		System.out.println("rv_idx = "+rvo.getRv_idx());
		System.out.println("ott_idx = "+rvo.getOtt_idx());
		System.out.println("delReview Controller 실행중");
		int cnt = r_dao.delReview(rvo);
		if(cnt != 0)
			System.out.println("삭제 성공");
		else
			System.out.println("삭제 실패");
		return "redirect:/review?ott_idx="+rvo.getOtt_idx();
	}
	
	@RequestMapping("/review_edit")
	@ResponseBody
	public Map<String, Integer> review_edit(ReviewVO rvo) {
		System.out.println("rv_idx = "+rvo.getRv_idx());
		
		ReviewVO vo = r_dao.selectReview(rvo.getRv_idx());
		
		int idx = vo.getRv_idx();
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("idx", idx);
		
		return map;
	}

	@RequestMapping("/edit_review")
	public ModelAndView goEditreview(int rv_idx) {
		ModelAndView mv =  new ModelAndView();
		ReviewVO vo = r_dao.selectReview(rv_idx);
		
		mv.addObject("rvo", vo);
		mv.setViewName("/edit_review");
		return mv;
	}
	
	@RequestMapping("/review_edit_submit")
	public String review_edit_submit(ReviewVO rvo) {
		System.out.println("rv_idx = "+rvo.getRv_idx()+" // content = "+rvo.getContent());
		r_dao.editReview(rvo);
		System.out.println("edit다 하고 컨트롤러로 돌아옴");
		return "redirect:/edit_review";
	}
	
	@RequestMapping(value="/thumup", method=RequestMethod.POST)
	@ResponseBody
	public int thumUp(int idx, int ott_idx) {
		Map<String, Integer> s_map = new HashMap<String, Integer>();
		s_map.put("u_idx", idx);
		s_map.put("ott_idx", ott_idx);
		int good = r_dao.isGood(s_map);
		int goodup = good+1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("is_good", goodup);
		map.put("u_idx", idx);
		map.put("ott_idx", ott_idx);
		
		int res = r_dao.thumpUp(map);
		int up = 0;
		if(res != 0) {
			int cnt = r_dao.isGood(s_map);
			up = cnt;
		}
		return up;
	}
	
	@RequestMapping(value="/thumdown", method=RequestMethod.POST)
	@ResponseBody
	public int thumDown(int idx, int ott_idx) {
		Map<String, Integer> s_map = new HashMap<String, Integer>();
		s_map.put("u_idx", idx);
		s_map.put("ott_idx", ott_idx);
		int not = r_dao.isNot(s_map);
		int notup = not+1;
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("is_not", notup);
		map.put("u_idx", idx);
		map.put("ott_idx", ott_idx);
		int res = r_dao.thumpDown(map);
		int down = 0;
		if(res != 0) {
			int cnt = r_dao.isNot(s_map);
			down = cnt;
		}
		return down;
	}
	
	
}
