package com.ott.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ott.bbs.vo.QnaVO;
import com.ott.user.vo.UserVO;



@Component
public class QnaDAO {

	@Autowired
	private SqlSessionTemplate ss;
	
	//원하는 페이지의 게시물목록 기능
	public QnaVO[] getList(int begin, int end, String bname) {
		QnaVO[] ar = null;
		
		//맵퍼(bbs.list)를 호출하기 위해 Map구조 생성!
		Map<String, String> map = new HashMap<String, String>();
		map.put("begin", String.valueOf(begin));
		map.put("end", String.valueOf(end));
		map.put("bname", bname);
	
		
		List<QnaVO> list = ss.selectList("bbs.list", map);
		if(list != null && list.size() > 0) {
			ar = new QnaVO[list.size()];
			list.toArray(ar);
		}
		
		return ar;
	}
	
	public int getTotalCount(String bname) {
		return ss.selectOne("bbs.totalCount", bname);
	}
	
	//기본키를 인자로 하여 원글 검색
	public QnaVO getBbs(String rb_idx) {
		return ss.selectOne("bbs.getBbs", rb_idx);
	}
	
	public int add(QnaVO q_vo) {
		return ss.insert("bbs.add", q_vo);
	}
	
	public int edit(QnaVO q_vo) {
		return ss.update("bbs.edit", q_vo);
	}
	
	public int delBbs(String rb_idx) {
		return ss.update("bbs.del", rb_idx);
	}
	
	public UserVO getUvo(String u_idx) {	//	u_idx로 해당 회원 정보 불러오기
		return ss.selectOne("bbs.getUvo", u_idx);
	}
	
	  public UserVO getUvo2(String u_id) {  //  u_id로 해당 회원 정보 불러오기
	  return ss.selectOne("bbs.getUvo2",u_id); 
	  }
	 
}












