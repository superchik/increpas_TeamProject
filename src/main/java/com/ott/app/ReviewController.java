package com.ott.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ott.review.dao.ReviewDAO;
import com.ott.review.vo.ReviewVO;

@Controller
public class ReviewController {

	@Autowired
	private ReviewDAO r_dao;
	
	@RequestMapping("/review")
	public ModelAndView review() {
		ModelAndView mv = new ModelAndView();
		
		ReviewVO[] vo =  r_dao.getBbs();
		mv.addObject("vo", vo);
		mv.setViewName("review");
		
		return mv;
	}
	
	@RequestMapping(value="/review", method=RequestMethod.POST)
	public ModelAndView review2(ReviewVO vo) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println(vo.getC_idx());
		System.out.println(vo.getContext());
		System.out.println(vo.getStatus());
		
		mv.addObject("vo", vo);
		
		r_dao.addAns(vo);
		mv.setViewName("review");
		return mv;
	}
	
	
}
