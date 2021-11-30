package com.ott.review.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.review.vo.ReviewVO;

@Component
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate ss;

	public ReviewVO viewContent(String i_ott_idx) {
		int ott_idx = Integer.valueOf(i_ott_idx);
		ReviewVO vo = ss.selectOne("review.viewContent", ott_idx);

		return vo;
	}

	

	/*public List<ReviewVO> getBbs() {
		
		
		List<ReviewVO> list = ss.selectList("review.get");
		
		
		
		return list;
		 
	}*/
}
