package com.ott.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.Security;
import com.ott.dao.LoginDAO;
import com.ott.dao.UserDAO;
import com.ott.user.vo.UserVO;

@Controller
public class LoginJoinController {
	
	@RequestMapping("/join")
	public String index() {	
		return "user/user_join";
	}
	
	@Autowired
	private LoginDAO Ldao;
	
	
	@RequestMapping(value = "login_join", method = RequestMethod.POST)
	public ModelAndView join(UserVO uvo) {
		ModelAndView mv = new ModelAndView();
		
		// String id = uvo.getU_id();
		// String name = uvo.getU_name();
		// String email = uvo.getU_email();
		
		
		String pwd1 = uvo.getU_pwd1();
		String big_fat = Security.generateSalt();
		big_fat = Security.getbig(pwd1, big_fat);
		
		// System.out.println(big_fat);
		// System.out.println("/"+id+"/"+name+"/"+email);
		
		uvo.setBig_fat(big_fat);
		
		Ldao.user_join(uvo);
		
		mv.setViewName("redirect:/");
		return mv;
	}
}
