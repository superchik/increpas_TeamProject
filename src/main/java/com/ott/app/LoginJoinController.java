package com.ott.app;

import javax.servlet.http.HttpSession;

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
	
	@Autowired
	private LoginDAO Ldao;
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/login")
	public String login_detail_view() {	
		return "user/user_login";
	}
	
	@RequestMapping("/join")
	public String join_detail_view() {	
		return "user/user_join";
	}
	
	@RequestMapping("/idfind")
	public String id_find() {	
		return "user/user_id_find";
	}
	
	@RequestMapping("/pwreissue")
	public String pwreissue() {	
		return "user/user_pw_reissue";
	}
	
	@RequestMapping(value = "login_join", method = RequestMethod.POST)
	public ModelAndView join(UserVO uvo) {
		ModelAndView mv = new ModelAndView();
		
		UserVO vo = Ldao.user_info(uvo.getU_id());
		if(vo != null) {
			mv.addObject("msg", "이미 가입된 아이디 입니다.");
			mv.setViewName("user/user_join");
		}else {
			String pwd1 = uvo.getU_pwd1();
			String big = Security.generateSalt();
			String fat = Security.getbig(pwd1, big);
			
			uvo.setBig_fat(big);
			uvo.setU_pwd1(fat);
			
			Ldao.user_join(uvo);
			
			mv.setViewName("redirect:/");
		}
				
		return mv;
	}
	
	@RequestMapping( value =  "/login", method = RequestMethod.POST)
	public ModelAndView login(String u_id , String u_pwd1) {
		
		ModelAndView mv = new ModelAndView();
		
		String big = Security.generateSalt();
		String fat = Security.getbig(u_pwd1, big);

		UserVO vo = Ldao.login(u_id, fat);
		
		if(vo != null) {
			session.setAttribute("uvo", vo);
			mv.addObject("user",vo);
		}
		mv.setViewName("redirect:/");
		return mv;
	}
}
