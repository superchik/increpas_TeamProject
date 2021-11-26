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
	
	public UserVO user_info(String id) {
		
		return ss.selectOne("user_service.user_info",id);
	}
	
	//	일반 회원가입
	public int user_join(UserVO uvo) {
		
		return ss.insert("user_service.user_join", uvo);
	}
}
