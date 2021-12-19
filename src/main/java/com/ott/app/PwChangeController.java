package com.ott.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ott.dao.UserDAO;

@Controller
public class PwChangeController {
	@Autowired
	private UserDAO u_dao;
	
	@RequestMapping("/pwChange")
	public String pw_change() {	
		return "user/user_pw_change";
	}
}
