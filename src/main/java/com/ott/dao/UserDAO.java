package com.ott.dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.ott.Util.FileRenameUtil;
import com.ott.Util.Security;
import com.ott.user.vo.UserVO;
@Component
public class UserDAO {
	
	private String img_path = "/resources/user_img/";
	
	@Autowired
	private ServletContext application;
	
	@Autowired
	private SqlSessionTemplate ss;
	
	// ======== 회원관리 게시판 ========
	public UserVO[] getList(int begin, int end) {
		UserVO[] ar = null;

		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));

		List<UserVO> list = ss.selectList("user.user_list", map);
		if (list != null && list.size() > 0) {
			ar = new UserVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}

	// ======== 페이징을 위한 전체 회원수 ========
	public int getTotalCount() {
		return ss.selectOne("user.totalCount");
	}

	// ======== 회원 검색 기능 ===========
	public UserVO[] searchUser(int begin, int end, String searchType, String searchValue) {
		UserVO[] ar = null;

		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		map.put("searchType"  , searchType);
		map.put("searchValue" , searchValue);

		List<UserVO> list = ss.selectList("user.user_search", map);
		if (list != null && list.size() > 0) {
			ar = new UserVO[list.size()];
			list.toArray(ar);
		}
		return ar;
	}

	// ======== 페이징을 위한 검색된 회원수==========
	public int getSearchCount(String searchType, String searchValue) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("searchType", searchType);
		map.put("searchValue", searchValue);
		int test =0;
		try {
			test = ss.selectOne("user.search_total", map);	
		} catch (Exception e) {
			test = 0;
		}
		
		return test;
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
		
		if(vo.getU_name().trim().length() > 0)
			map.put("u_name", vo.getU_name());
		
		if(vo.getFname().trim().length() > 0) {
			map.put("fname", vo.getFname());
			map.put("oname", vo.getOname());
		}
		return ss.update("user_service.user_img", map);
	}
		

	//유저 종합 정보
	public ModelAndView userInfo(UserVO vo) {
		ModelAndView mv = new ModelAndView();
		UserVO u_idDex = ss.selectOne("user_service.user_info1",vo.getU_idx());
		System.out.println("u_idx = "+vo.getU_idx());
		if(u_idDex.getFname().trim().length() < 0) {
			u_idDex.setIdImg(u_idDex.getU_id().substring(0,1));
		}
		System.out.println("오라클 파일 저장 경로"+u_idDex.getFname());
		System.out.println("파일이 없을시 표현할 글"+u_idDex.getIdImg());
		mv.addObject("vo", u_idDex);
		mv.setViewName("/user/user_info");
		
		return mv;
	}

	//비동기 통신 유저 프로필 이미지 업로드
	public Map<String, String> saveImg(UserVO vo) {
		Map<String, String> map = new HashMap<String, String>();
		
		System.out.println("u_idx====> "+vo.getU_idx());
		System.out.println("MultiFile =====> "+vo.getS_file().getClass().getName());

		StringBuffer sb = new StringBuffer();
		
		if (vo.getS_file().getSize() > 0) {
			System.out.println("실재 파일 저장 = "+ application.getRealPath(img_path));
			//oname = f.getOriginalFilename();
			vo.setOname(vo.getS_file().getOriginalFilename());
			
			//fname = FileRenameUtil.checkSameFileName(oname, realPath);
			vo.setFname(FileRenameUtil.checkSameFileName(vo.getOname(), application.getRealPath(img_path)));
			try {
				vo.getS_file().transferTo(new File(application.getRealPath(img_path), vo.getFname()));
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
		
		System.out.println("이미지 저장 성공=1 실패=0 : "+status);
		
		map.put("path", vo.getFname());
		
		return map;
		
	}

	
}
