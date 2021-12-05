package com.ott.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.user.vo.UserVO;
@Component
public class UserDAO {
	
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


	public int editBbs(String u_idx,String fname, String oname) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("u_idx", u_idx);
		
		
		if(fname != null) {
			map.put("fname", fname);
			map.put("oname", oname);
		}
		int cnt = ss.update("user_service.user_img", map);
		return cnt;
	}
	
	public int getList(String u_idx) {
		return ss.selectOne("user_service.user_text",u_idx);
	}
	
	public UserVO getUserDex(String u_idx){

		UserVO vo = ss.selectOne("user_service.user_info",u_idx);
		
		return vo;
	}
	
	public String imgpath(String u_idx) {
		UserVO vo = ss.selectOne("user_service.user_info",u_idx);
		return vo.getFname();
	}
	
}
