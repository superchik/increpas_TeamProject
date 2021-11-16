package com.ott.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {	
		return "index"; 
	}
	
	@RequestMapping("/bbs")
	public String bbs() {
		return "/bbs/bbs_all";
	}
}
