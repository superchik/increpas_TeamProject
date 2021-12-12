package com.ott.bbs.vo;

//	QNA 게시판 댓글 VO
public class QnaCommVO {
	
	private String c_idx; 		// 	게시판 idx
	private String c_content; 	// 	글 내용
	private String write_date; 	// 	글 쓴 날짜
	private String rb_idx;		//	원글의 idx
	
	//=============================================================
	
	private String om_idx;		//	관리자 idx(FK)
	private String manager_id;	//	관리자 아이디
	
	
	
	
	public String getOm_idx() {
		return om_idx;
	}
	public void setOm_idx(String om_idx) {
		this.om_idx = om_idx;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getC_idx() {
		return c_idx;
	}
	public void setC_idx(String c_idx) {
		this.c_idx = c_idx;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getRb_idx() {
		return rb_idx;
	}
	public void setRb_idx(String rb_idx) {
		this.rb_idx = rb_idx;
	}
	
	
	
	

	
}

