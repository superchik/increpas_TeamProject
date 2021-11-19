package com.ott.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.netflix.vo.NetflixVO;

@Component
public class NetflixDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public NetflixVO[] net_All(int begin, int end) {
		NetflixVO[] ar = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		
		List<NetflixVO> nvo = ss.selectList("sample.netflix", map);
		
		if(nvo != null && nvo.size() > 0) {
			ar = new NetflixVO[nvo.size()];
			
			nvo.toArray(ar);
		}
		return ar;
	}
	
	public int getTotalCount() {
		int cnt = ss.selectOne("sample.netflixTotal");
		
		return cnt;
	}
}
