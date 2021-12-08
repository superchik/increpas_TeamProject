package com.ott.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ott.dao.FindDAO;
import com.ott.user.vo.UserVO;


@Controller
public class FindController {
	
	@Autowired
	private FindDAO fdao;
	
	@RequestMapping("/idfind")
	public String id_find() {	
		return "user/user_id_find";
	}
	
	// id 찾기 끝
	@RequestMapping(value="/findAction", method=RequestMethod.POST)
	public ModelAndView findAction(String u_email) {
		UserVO vo = fdao.id_find(u_email);
		String id = vo.getU_id();
		ModelAndView mv =  new ModelAndView();
		mv.addObject("id", id);
		mv.setViewName("/user/user_id_find_result");
		
		return mv;
	}
	
	
	// 비밀번호 찾기

	@RequestMapping("/pwreissue")
	public String pwreissue() {	
		return "user/user_pw_reissue";
	}
	
}
