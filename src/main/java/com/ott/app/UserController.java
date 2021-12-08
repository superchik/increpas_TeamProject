package com.ott.app;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.FileRenameUtil;
import com.ott.dao.UserDAO;
import com.ott.user.vo.ImgVO;
import com.ott.user.vo.UserVO;
@Controller
public class UserController {
	
	
	@Autowired
	private HttpSession session;

	
	private String img_path = "/resources/user_img/";
	


	@Autowired
	private ServletContext application;

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserDAO u_dao;
	
	@RequestMapping(value = "/saveImage", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveImg(ImgVO vo) {
		Map<String, String> map = new HashMap<String, String>();
		String u_idx= vo.getU_idx();
		MultipartFile f = vo.getS_file();
		
		System.out.println("MultiFile ===-=> "+f);
		
		String oname = null;
		String o_name = null;
		String fname = null;
		String realPath = null;
		
		StringBuffer sb = new StringBuffer();
		
		
		
		if (f.getSize() > 0) {
			realPath = application.getRealPath(img_path);
			
			oname = f.getOriginalFilename();

			fname = FileRenameUtil.checkSameFileName(oname, realPath);

			try {
				f.transferTo(new File(realPath, fname));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		sb.append(img_path);
		
		sb.append(fname);
		
		fname = sb.toString();
		
		System.out.println("에이젝스 저장= "+fname);

		// xml : user_img
		int status = u_dao.editBbs(u_idx, fname, oname);
		
		System.out.println(status);
		
		map.put("path", fname);
		
		return map;
	}
	
	@RequestMapping(value =  "/user_info", method = RequestMethod.GET)
	public ModelAndView userInfo(String u_idx) {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("u_idx = "+ u_idx);
		String realPath = application.getRealPath(img_path);
		System.out.println("Real =======================>>> "+realPath);
		System.out.println("img 저장 위치 = "+realPath);

		UserVO vo = u_dao.getUserDex(u_idx);
		String u_id = vo.getU_id();
		String u_id1= u_id.substring(0,1);
		
		System.out.println("ID 첫 문자==>"+u_id1);
		System.out.println("이미지 불러오기= "+vo.getFname());
		
		
		session.setAttribute("uvo", vo);
		
		int listIdx = u_dao.getList("u_idx"+u_idx);
		mv.addObject("id", u_id1);	
		mv.addObject("vo", vo);
		mv.addObject("voList", listIdx);

		
		
		 
		mv.setViewName("/user/user_info");
		
		return mv;
	}
}

