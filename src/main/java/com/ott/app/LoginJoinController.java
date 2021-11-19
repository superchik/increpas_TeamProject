package com.ott.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginJoinController {
	
	@RequestMapping("/join")
	public String index() {	
		return "login/LoginJoin";
	}
}
