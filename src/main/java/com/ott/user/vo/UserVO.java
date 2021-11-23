package com.ott.user.vo;

public class UserVO {
	
	private String u_idx;
	private String u_name;
	private String u_email;
	private String u_id;
	private String u_pwd1;
	private String u_level;
	private String is_admin;
	private String is_stop;
	private String is_warning;
	private String exp;
	private String auth_key;
	private String auth_status;
	private String mail_check;
	private String big_fat; // 암호화 salt 값 저장 컬럼
	
	
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String getAuth_key() {
		return auth_key;
	}
	public void setAuth_key(String auth_key) {
		this.auth_key = auth_key;
	}
	public String getAuth_status() {
		return auth_status;
	}
	public void setAuth_status(String auth_status) {
		this.auth_status = auth_status;
	}
	public String getMail_check() {
		return mail_check;
	}
	public void setMail_check(String mail_check) {
		this.mail_check = mail_check;
	}
	public String getBig_fat() {
		return big_fat;
	}
	public void setBig_fat(String big_fat) {
		this.big_fat = big_fat;
	}
	public String getU_idx() {
		return u_idx;
	}
	public void setU_idx(String u_idx) {
		this.u_idx = u_idx;
	}
	public String getU_email() {
		return u_email;
	}
	public void setU_email(String u_email) {
		this.u_email = u_email;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pwd1() {
		return u_pwd1;
	}
	public void setU_pwd1(String u_pwd1) {
		this.u_pwd1 = u_pwd1;
	}
	public String getU_level() {
		return u_level;
	}
	public void setU_level(String u_level) {
		this.u_level = u_level;
	}
	public String getIs_admin() {
		return is_admin;
	}
	public void setIs_admin(String is_admin) {
		this.is_admin = is_admin;
	}
	public String getIs_stop() {
		return is_stop;
	}
	public void setIs_stop(String is_stop) {
		this.is_stop = is_stop;
	}
	public String getIs_warning() {
		return is_warning;
	}
	public void setIs_warning(String is_warning) {
		this.is_warning = is_warning;
	}
	

}
