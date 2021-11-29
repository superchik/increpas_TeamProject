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
				
		String pwd1 = uvo.getU_pwd1();
		String big = Security.generateSalt();
		String fat = Security.getbig(pwd1, big);
		
		uvo.setBig_fat(big);
		uvo.setU_pwd1(fat);

		Ldao.user_join(uvo);
		
		mv.setViewName("redirect:/");
		return mv;
	}
}
