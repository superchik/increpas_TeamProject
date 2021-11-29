package com.ott.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KakaoLoginController {
	
	@RequestMapping("kakao_login")
	public ModelAndView Kakao_login(String code) {
		System.out.println("»Æ¿Œ" + code);
		return null;
	}
}
