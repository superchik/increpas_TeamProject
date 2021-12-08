package com.ott.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.user.vo.UserVO;

@Component
public class FindDAO {
	@Autowired
	private SqlSessionTemplate ss;
	
	public UserVO id_find(String email) {
		return ss.selectOne("user_service.id_find", email);
	}
}
