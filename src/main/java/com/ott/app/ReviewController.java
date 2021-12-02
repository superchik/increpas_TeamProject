package com.ott.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ott.review.dao.ReviewDAO;
import com.ott.review.vo.CommVO;
import com.ott.review.vo.ReviewVO;
import com.ott.user.vo.UserVO;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDAO r_dao;
	
	@RequestMapping("/review")
	public ModelAndView review(
			@RequestParam(value="ott_idx")String ott_idx
			) {
		System.out.println(">>>>reviewList.do&"+ott_idx);
		ModelAndView mv = new ModelAndView();
		
		ReviewVO vo = r_dao.viewContent(ott_idx);
		
		mv.addObject("vo", vo);
		mv.setViewName("review");
		
		return mv;
	}
	
	@RequestMapping(value="/review", method=RequestMethod.POST)
	public ModelAndView review_add(UserVO uvo, CommVO cvo, String now_page) {
		System.out.println(">>>>reviewInsert.do"+"/"+uvo.getU_id()+"/U_ID�븞�뱾�뼱�삤�깘");
		ModelAndView mv = new ModelAndView();
		
		UserVO uvo2 = r_dao.get_u_idx(uvo);
		
		System.out.println("u_idx: "+uvo2.getU_idx());
		
		cvo.setU_IDX(uvo2.getU_idx());
		
		r_dao.add_review(cvo);
		
		
		mv.setViewName("redirect:/review?ott_idx="+now_page);
		return mv;
	}
	
	
}
