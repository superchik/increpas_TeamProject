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
	

}
