package com.ott.app;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ott.dao.UserDAO;
import com.ott.user.vo.UserVO;
@Controller
public class UserController {
	
//	@Autowired
//	private HttpSession session;
	
	@Autowired
	private UserDAO u_dao;
	
	//비동기 유저 프로필 이미지
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	@ResponseBody
	private Map<String, String> saveImg(UserVO vo){
//		UserVO vo = (UserVO)session.getAttribute("uvo");
//		vo = svo;
//		System.out.println("유저 별명========================>>"+vo.getU_name());
//		System.out.println("설명글===============>"+vo.getAbout_me());
		return u_dao.saveImg(vo);
	}
	
	//유저 정보
	@RequestMapping(value =  "/user_info", method = RequestMethod.POST)
	public ModelAndView userInfo(UserVO vo) {
//		UserVO vo = (UserVO)session.getAttribute("uvo");
//		vo = svo;
		return u_dao.userInfo(vo);
	}
}

