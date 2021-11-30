package com.ott.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.user.vo.UserVO;

@Component
public class LoginDAO {

	@Autowired
	private SqlSessionTemplate ss;

	public int naver_user(UserVO uvo) {

		return ss.insert("user_service.naver_login", uvo);
	}

	public UserVO user_info(String id) {

		return ss.selectOne("user_service.user_info", id);
	}
	
	public UserVO email_info(String email) {
		
		return ss.selectOne("user_service.email_info", email);
	}

	// �씪諛� �쉶�썝媛��엯
	public int user_join(UserVO uvo) {

		return ss.insert("user_service.user_join", uvo);
	}

	// login
	public UserVO login(String u_id, String fat) {

		Map<String, String> map = new HashMap<String, String>();

		map.put("u_id", u_id);
		map.put("u_pwd1", fat);

		UserVO vo = ss.selectOne("user_service.login", map);

		return vo;

	}

}
