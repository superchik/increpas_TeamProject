package com.ott.review.vo;

import java.util.List;

public class ReviewVO {
	
	private String OTT_IDX;
	private String TITLE;
	private String POSTER;
	private String RANK;
	private String PLATFORM;
	private String SUMMARY;
	private String ROTTEN_TOMATO;
	private String DIRECTOR;
	private String CAST;
	
	private List<CommVO> c_list;
	
	
	
	public List<CommVO> getC_list() {
		return c_list;
	}
	public void setC_list(List<CommVO> c_list) {
		this.c_list = c_list;
	}
	
	
	
	public String getROTTEN_TOMATO() {
		return ROTTEN_TOMATO;
	}
	public void setROTTEN_TOMATO(String rOTTEN_TOMATO) {
		ROTTEN_TOMATO = rOTTEN_TOMATO;
	}
	public String getDIRECTOR() {
		return DIRECTOR;
	}
	public void setDIRECTOR(String dIRECTOR) {
		DIRECTOR = dIRECTOR;
	}
	public String getCAST() {
		return CAST;
	}
	public void setCAST(String cAST) {
		CAST = cAST;
	}
	public String getOTT_IDX() {
		return OTT_IDX;
	}
	public void setOTT_IDX(String oTT_IDX) {
		OTT_IDX = oTT_IDX;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getPOSTER() {
		return POSTER;
	}
	public void setPOSTER(String pOSTER) {
		POSTER = pOSTER;
	}
	public String getRANK() {
		return RANK;
	}
	public void setRANK(String rANK) {
		RANK = rANK;
	}
	public String getPLATFORM() {
		return PLATFORM;
	}
	public void setPLATFORM(String pLATFORM) {
		PLATFORM = pLATFORM;
	}
	public String getSUMMARY() {
		return SUMMARY;
	}
	public void setSUMMARY(String sUMMARY) {
		SUMMARY = sUMMARY;
	}
	
	
	
}