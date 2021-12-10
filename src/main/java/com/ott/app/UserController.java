package com.ott.app;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ott.dao.UserDAO;
import com.ott.user.vo.UserVO;
@Controller
public class UserController {
	
	
	@Autowired
	private UserDAO u_dao;
	
	//비동기 유저 프로필 이미지
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, String> saveImg(UserVO vo){
		return u_dao.saveImg(vo);
	}
	
	//유저 정보
	@RequestMapping(value =  "/user_info", method = RequestMethod.POST)
	public ModelAndView userInfo(UserVO vo) {
		return u_dao.userInfo(vo);
	}
}

