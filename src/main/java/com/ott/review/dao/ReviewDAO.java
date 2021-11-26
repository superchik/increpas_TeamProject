package com.ott.review.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.review.vo.ReviewVO;

@Component
public class ReviewDAO {

	@Autowired
	private SqlSessionTemplate ss;

	public int addAns(ReviewVO vo) {

		int cnt = ss.insert("review.add", vo);

		return cnt;
	}

	public ReviewVO[] getBbs() {
		
		
		ReviewVO[] ar = null;
		
		List<ReviewVO> list = ss.selectList("review.get");
		if(list != null && list.size() > 0 && !list.isEmpty()) {
			ar = new ReviewVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
		 
	}
}
