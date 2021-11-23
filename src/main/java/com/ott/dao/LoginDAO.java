package com.ott.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.user.vo.UserVO;

@Component
public class LoginDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public int naver_user(UserVO uvo) {
		
		return ss.insert("user_service.naver_login",uvo);
	}
}
