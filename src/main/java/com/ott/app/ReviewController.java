package com.ott.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ott.review.dao.ReviewDAO;
import com.ott.review.vo.ReviewVO;

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
	
	/*@RequestMapping(value="/review", method=RequestMethod.POST)
	public ModelAndView review2(ReviewVO vo) {
		System.out.println(">>>>reviewInsert.do");
		ModelAndView mv = new ModelAndView();
		
		
		mv.addObject("vo", vo);
		
		//r_dao.addAns(vo);
		mv.setViewName("review");
		return mv;
	}*/
	
	
}
