package com.ott.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestUserInfoController {
	
	@RequestMapping("/user_info")
	public String showInfo() {
		return "user/user_info";
	}
}
