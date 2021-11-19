package com.ott.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.netflix.vo.NetflixVO;

@Component
public class NetflixDAO {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public NetflixVO[] net_All() {
		NetflixVO[] ar = null;
		
		List<NetflixVO> nvo = ss.selectList("sample.netflix");
		
		if(nvo != null && nvo.size() > 0) {
			ar = new NetflixVO[nvo.size()];
			
			nvo.toArray(ar);
		}
		return ar;
	}
}
