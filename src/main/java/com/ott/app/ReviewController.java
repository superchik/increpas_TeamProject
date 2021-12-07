package com.ott.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/review")
	public ModelAndView review(@RequestParam(value="ott_idx")String ott_idx, String cPage) {
		System.out.println(">>>>reviewList.do&"+ott_idx);
		
		ModelAndView mv = new ModelAndView();
		
		PlatFormVO vo = r_dao.viewContent(ott_idx);
		int cnt = r_dao.review_count(ott_idx);	//해당 게시물의 총 리뷰 수!!!(=rowTotal)
		
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
