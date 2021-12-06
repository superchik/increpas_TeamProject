package com.ott.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ott.platform.vo.PlatFormVO;
import com.ott.review.dao.ReviewDAO;
import com.ott.review.vo.ReviewVO;
import com.ott.user.vo.UserVO;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDAO r_dao;
	
	@RequestMapping("/review")
	public ModelAndView review(@RequestParam(value="ott_idx")String ott_idx) {
		System.out.println(">>>>reviewList.do&"+ott_idx);
		
		ModelAndView mv = new ModelAndView();
		
		PlatFormVO vo = r_dao.viewContent(ott_idx);
		ReviewVO[] rvo = r_dao.getReview(ott_idx);
		
		if(rvo != null){
			double rating = r_dao.rating(ott_idx);
			mv.addObject("rating",rating);
		}
		
		int cnt = r_dao.review_count(ott_idx);
		
		
		mv.addObject("vo", vo);
		mv.addObject("rvo",rvo);
		mv.addObject("r_cnt",cnt);
		
		
		mv.setViewName("review");
		
		return mv;
	}
	
	@RequestMapping(value="/review", method=RequestMethod.POST)
	public ModelAndView review_add(UserVO uvo, ReviewVO rvo, String now_page) {
		System.out.println(">>>>reviewInsert.do"+"/"+uvo.getU_id()+"/ <---- U_ID");
		ModelAndView mv = new ModelAndView();
		
		UserVO uvo2 = r_dao.get_u_idx(uvo);
		
		System.out.println("u_idx: "+uvo2.getU_idx());
		
		rvo.setU_idx(uvo2.getU_idx());
		
		r_dao.add_review(rvo);
		
		
		mv.setViewName("redirect:/review?ott_idx="+now_page);
		return mv;
	}
	
	
}
