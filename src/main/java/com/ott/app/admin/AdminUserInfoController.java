package com.ott.app.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.Paging;
import com.ott.Util.Paging_admin;
import com.ott.dao.UserDAO;
import com.ott.user.vo.UserVO;


@Controller
public class AdminUserInfoController {
	
	@Autowired
	private UserDAO u_dao;
	
	int nowPage;
	int rowTotal;
	int blockList = 10; //한 페이지당 표현될 게시물 수
	int blockPage = 5;//한 블럭당 표현될 페이지 수
	
	String pageName = "/admin_userinfo";
	@RequestMapping("/admin_userinfo")
	public ModelAndView userinfo(String cPage) {	
		ModelAndView mv = new ModelAndView();
		
		if(cPage == null)
			nowPage = 1;
		else
			nowPage = Integer.parseInt(cPage);
		
		rowTotal =u_dao.getTotalCount();//전체 유저수
		
		//페이징 처리를 위한 객체 생성
		Paging_admin page = new Paging_admin(nowPage, rowTotal, blockList, blockPage, pageName);
		
		int begin = page.getBegin();
		int end = page.getEnd();
		
		UserVO[] ar = u_dao.getList(begin, end);
		
		//JSP에서 표현해야 하므로 ar을 mv에 저장한다.
		mv.addObject("ar", ar);
		mv.addObject("nowPage", nowPage);
		mv.addObject("blockList", blockList);
		mv.addObject("rowTotal", rowTotal);
		mv.addObject("pageCode", page.getSb().toString());
		
		mv.setViewName("admin/admin_userinfo");
		
		return mv;
		
	}
}
