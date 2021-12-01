package com.ott.app;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.Security;
import com.ott.dao.LoginDAO;
import com.ott.dao.UserDAO;
import com.ott.service.MailSendService;
import com.ott.user.vo.UserVO;

@Controller
public class LoginJoinController {
	
	@Autowired
	private LoginDAO Ldao;
	@Autowired
	private HttpSession session;
	
	@Autowired
	private MailSendService mss;
	
	
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
	public ModelAndView join(UserVO uvo) throws Exception {
		ModelAndView mv = new ModelAndView();

		String auth_key = mss.sendAuthMail(uvo.getU_name(),uvo.getU_email());
		String pwd1 = uvo.getU_pwd1();
		String big = Security.generateSalt();
		String fat = Security.getbig(pwd1, big);
		
		uvo.setBig_fat(big);
		uvo.setU_pwd1(fat);
		uvo.setAuth_key(auth_key);
		
		Ldao.user_join(uvo);
		
		Map<String, String> map = new HashMap<String, String>();

		map.put("u_id", uvo.getU_id());
		map.put("auth_key", uvo.getAuth_key());
		
		Ldao.auth_Key(map);
		
		mv.setViewName("redirect:/");

				
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
	
	@RequestMapping("/idCheck")
	@ResponseBody
	public int idCheck(String id) {
		int cnt = 0;
		UserVO uvo = Ldao.user_info(id);
		if(uvo != null) {
			cnt = 1;
		}
		
		return cnt;
	}
	
	
	@RequestMapping("/emailCheck")
	@ResponseBody
	public int emailCheck(String email) {
		int cnt = 0;
		UserVO uvo = Ldao.email_info(email);
		if(uvo != null) {
			cnt = 1;
		}
		
		return cnt;
	}
	
	
	
	@RequestMapping("/mail_confirm")
	public String mail_confirm(String email, String auth_key) {
		
		System.out.println(email);
		System.out.println(auth_key);
		
		if(email != null && auth_key != null) {
			
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("u_email", email);
			map.put("auth_key", auth_key);
			Ldao.mail_confirm(map);
		}else {
			return "index";
		}
		
		return "redirect:/login";
	}
}
