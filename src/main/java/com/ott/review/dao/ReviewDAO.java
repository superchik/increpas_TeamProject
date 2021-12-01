package com.ott.review.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.review.vo.CommVO;
import com.ott.review.vo.ReviewVO;
import com.ott.user.vo.UserVO;

@Component
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate ss;

	public ReviewVO viewContent(String i_ott_idx) {
		int ott_idx = Integer.valueOf(i_ott_idx);
		ReviewVO vo = ss.selectOne("review.viewContent", ott_idx);

		return vo;
	}

	

	public int add_review(CommVO cvo) {
		
		int cnt = ss.insert("review.add_review", cvo);
		
		return cnt;
		 
	}
	
	public UserVO get_u_idx(UserVO uvo) {
		
		UserVO uvo2 = ss.selectOne("review.get_u_idx", uvo);
		
		return uvo2;
		
	}
}
