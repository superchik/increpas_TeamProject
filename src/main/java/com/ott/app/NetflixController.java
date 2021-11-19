package com.ott.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.Paging;
import com.ott.dao.NetflixDAO;
import com.ott.netflix.vo.NetflixVO;

@Controller
public class NetflixController {
	
	@Autowired
	private NetflixDAO n_dao;
	
	int nowPage;
	int rowTotal;
	
	public final int BLOCK_LIST = 5;
	public final int BLOCK_PAGE = 5;
	
	String pageCode;
	
	@RequestMapping("/bbs")
	public ModelAndView netflixList(String cPage) {
		ModelAndView mv = new ModelAndView();
		
		if(cPage == null) {
			nowPage = 1;
		}else {
			nowPage = Integer.parseInt(cPage);
		}
		
		rowTotal = n_dao.getTotalCount();
		
		Paging page = new Paging(nowPage, rowTotal, BLOCK_LIST, BLOCK_PAGE);
		
		pageCode = page.getSb().toString();
		
		int begin = page.getBegin();
		int end = page.getEnd();
		System.out.println(end);
		
		NetflixVO[] ar = n_dao.net_All(begin, end);
		mv.addObject("ar",ar);
		
		mv.addObject("nowPage", nowPage);
		mv.addObject("rowTotal", rowTotal);
		mv.addObject("blockList", BLOCK_LIST);
		mv.addObject("pageCode", pageCode);
		mv.setViewName("/bbs/bbs_all");
				
		return mv;
	}
	
}
