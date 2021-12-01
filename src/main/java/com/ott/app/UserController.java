package com.ott.app;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.FileRenameUtil;
import com.ott.dao.UserDAO;
import com.ott.user.vo.ImgVO;
import com.ott.user.vo.UserVO;

public class UserController {
	
	private String img_path = "/img";
	
	@Autowired
	private SqlSessionTemplate ss;

	@Autowired
	private ServletContext application;

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserDAO u_dao;
	
	@RequestMapping(value = "/saveImage.inc", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveImg(ImgVO vo) {
		Map<String, String> map = new HashMap<String, String>();
		String u_idx= vo.getU_idx();
		MultipartFile f = vo.getS_file();
		String oname = null;
		String fname = null;

		if (f.getSize() > 0) {
			String realPath = application.getRealPath(img_path);

			oname = f.getOriginalFilename();

			fname = FileRenameUtil.checkSameFileName(oname, realPath);

			try {
				f.transferTo(new File(realPath, fname));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		String path = request.getContextPath();
		
		u_dao.editBbs(u_idx, fname, oname);

		map.put("path", path + img_path);
		//map.put("fname", fname);
		return map;
	}
	
	@RequestMapping("user_info")
	public ModelAndView userInfo(String u_idx) {
		ModelAndView mv = new ModelAndView();
		
		int listIdx = u_dao.getList(u_idx);
		
		UserVO vo = u_dao.getUserDex(u_idx);
		
		String imgpath = application.getRealPath(img_path)+u_dao.imgpath(u_idx);
		
		mv.addObject("vo", vo);
		mv.addObject("voList", listIdx);
		mv.addObject("voimg", imgpath);
		
		mv.setViewName("/user/user_info");
		
		return mv;
	}
}

