package com.ott.netflix.vo;

public class NetflixVO {
	private String NF_IDX, NF_TITLE, NF_POSTER, NF_RANK;

	public NetflixVO(String nF_IDX, String nF_TITLE, String nF_POSTER, String nF_RANK) {
		super();
		NF_IDX = nF_IDX;
		NF_TITLE = nF_TITLE;
		NF_POSTER = nF_POSTER;
		NF_RANK = nF_RANK;
	}

	public String getNF_IDX() {
		return NF_IDX;
	}

	public void setNF_IDX(String nF_IDX) {
		NF_IDX = nF_IDX;
	}

	public String getNF_TITLE() {
		return NF_TITLE;
	}

	public void setNF_TITLE(String nF_TITLE) {
		NF_TITLE = nF_TITLE;
	}

	public String getNF_POSTER() {
		return NF_POSTER;
	}

	public void setNF_POSTER(String nF_POSTER) {
		NF_POSTER = nF_POSTER;
	}

	public String getNF_RANK() {
		return NF_RANK;
	}

	public void setNF_RANK(String nF_RANK) {
		NF_RANK = nF_RANK;
	}
}
