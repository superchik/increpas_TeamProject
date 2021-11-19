package com.ott.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ott.dao.NetflixDAO;
import com.ott.netflix.vo.NetflixVO;

@Controller
public class NetflixController {
	
	@Autowired
	private NetflixDAO n_dao;
	
	@RequestMapping("/bbs")
	public ModelAndView netflixList() {
		ModelAndView mv = new ModelAndView();
		
		NetflixVO[] ar = n_dao.net_All();
		mv.addObject("ar",ar);
		mv.setViewName("/bbs/bbs_all");
				
		return mv;
	}
	
}
