package com.ott.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginIDFindController {
	
	@RequestMapping("/idfind")
	public String index() {	
		return "login/LoginIDFind";
	}
}
