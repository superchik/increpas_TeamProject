package com.ott.review.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.platform.vo.PlatFormVO;
import com.ott.review.vo.ReviewVO;
import com.ott.user.vo.UserVO;

@Component
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate ss;

	public PlatFormVO viewContent(String i_ott_idx) {
		int ott_idx = Integer.valueOf(i_ott_idx);
		PlatFormVO vo = ss.selectOne("review.viewContent", ott_idx);
		
		

		return vo;
	}

	

	public int add_review(ReviewVO rvo) {
		
		int cnt = ss.insert("review.add_review", rvo);
		
		return cnt;
		 
	}
	
	public int review_count(String i_ott_idx) {
		
		int ott_idx = Integer.valueOf(i_ott_idx);
		int cnt = ss.selectOne("review.review_count", ott_idx);
		
		return cnt;
		
	}
	
	public UserVO get_u_idx(UserVO uvo) {
		
		UserVO uvo2 = ss.selectOne("review.get_u_idx", uvo);
		
		return uvo2;
		
	}
	
	public double rating(String i_ott_idx) {
		int ott_idx = Integer.valueOf(i_ott_idx);
		double cnt = ss.selectOne("review.rating", ott_idx);
		
		return cnt;
	}
	
	
	
	public ReviewVO[] getReview(int begin, int end, String ott_idx) {
		ReviewVO[] ar = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		map.put("ott_idx", ott_idx);
		
		List<ReviewVO> list = ss.selectList("review.getReview", map);
		if(list != null && list.size() > 0 && !list.isEmpty()) {
			ar = new ReviewVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	public int delReview(ReviewVO rvo) {
		int cnt = ss.update("review.delReview",rvo);
		return cnt;
	}
	
	public int thumpUp(Map<String, Integer> map) {
		int cnt = ss.update("review.thumpUp", map);
		return cnt;
	}
	
	public int thumpDown(Map<String, Integer> map) {
		int cnt = ss.update("review.thumpDown", map);
		return cnt;
	}
	
	public int isGood(Map<String, Integer> map) {
		int cnt = ss.selectOne("review.getGood", map);
		
		return cnt;
	}
	
	public int isNot(Map<String, Integer> map) {
		int cnt = ss.selectOne("review.getNot", map);
		
		return cnt;
	}
}
