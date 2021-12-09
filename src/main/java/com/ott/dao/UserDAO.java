package com.ott.dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.FileRenameUtil;
import com.ott.user.vo.UserVO;
@Component
public class UserDAO {
	
	private String img_path = "/resources/user_img/";
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public UserVO[] getList(int begin, int end ){
		UserVO[] ar = null;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		
		List<UserVO> list = ss.selectList("user.user_list", map);
		if(list != null && list.size() > 0) {
			ar = new UserVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}
	
	public int getTotalCount() {
		return ss.selectOne("user.totalCount");
	}
	
	// ======== 회원 정지상태 수정 ========
	public String updateUser_stop(Map<String, String> map) {
		String result = "FAIL";
		try {
			ss.update("user.user_editStop", map);
			result = "SUCC";
		} catch (Exception e) {
			result = "FAIL :: DB오류 ";
			// TODO: handle exception
		}
		return result;
	}

	//이미지 파일 원본이름 사본이름 저장 DB저장
	public int editImg(UserVO vo) {
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("오라클 보내는 파일 경로=======>"+vo.getFname());
		System.out.println(vo.getU_idx());

		map.put("u_idx", vo.getU_idx());
		
		if(vo.getFname() != null || vo.getOname() != null) {
			map.put("fname", vo.getFname());
			map.put("oname", vo.getOname());
		}
		return ss.update("user_service.user_img", map);
	}
		

	//유저 종합 정보
	public ModelAndView userInfo(UserVO vo) {
		ModelAndView mv = new ModelAndView();
		System.out.println("u_idx = "+vo.getU_idx());
		
		UserVO u_idDex = ss.selectOne("user_service.user_info1",vo.getU_idx());
		System.out.println(u_idDex.getFname()); 
		mv.addObject("vo", u_idDex);
		mv.setViewName("/user/user_info");
		return mv;
	}

	//비동기 통신 유저 프로필 이미지 업로드
	public Map<String, String> saveImg(UserVO vo) {
		Map<String, String> map = new HashMap<String, String>();
		String u_idx= vo.getU_idx();
		MultipartFile f = vo.getS_file();
		
		System.out.println("u_idx====> "+u_idx);
		System.out.println("MultiFile ===-=> "+f);

		String realPath = null;
		
		StringBuffer sb = new StringBuffer();
		
		
		
		if (f.getSize() > 0) {
			realPath = application.getRealPath(img_path);
			System.out.println("실재 파일 저장 = "+ realPath);
			//oname = f.getOriginalFilename();
			vo.setOname(f.getOriginalFilename());
			
			//fname = FileRenameUtil.checkSameFileName(oname, realPath);
			vo.setFname(FileRenameUtil.checkSameFileName(vo.getOname(), realPath));
			try {
				f.transferTo(new File(realPath, vo.getFname()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		sb.append(img_path);
		
		sb.append(vo.getFname());
		
		vo.setFname(sb.toString());
		
		System.out.println("에이젝스 저장= "+ vo.getFname());

		// xml : user_img
		int status = editImg(vo);
		
		System.out.println(status);
		
		map.put("path", vo.getFname());
		
		return map;
		
	}

	
}
