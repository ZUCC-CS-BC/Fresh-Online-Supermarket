package cn.edu.zucc.freshos.model;

import java.sql.Date;

import cn.edu.zucc.freshos.model.UserInformation;

public class UserInformation {
	public static UserInformation currentLoginUser=null;
	private String user_id;
	private String user_name;
	private String user_gender;
	private String user_pwd;
	private String user_telphone;
	private String user_webmail;
	private String user_city;
	private Date user_registration_time; //注册时间
	private boolean vip;
	private Date vip_end; //VIP到期时间

	public String getUserId() {
		return user_id;
	}
	public void setUserId(String user_id) {
		this.user_id = user_id;
	}
	public String getUserName() {
		return user_name;
	}
	public void setUserName(String user_name) {
		this.user_name = user_name;
	}
	public String getUserGender() {
		return user_gender;
	}
	public void setUserGender(String user_gender) {
		this.user_gender = user_gender;
	}
	public String getUserPwd() {
		return user_pwd;
	}
	public void setUserPwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUserTelphone() {
		return user_telphone;
	}
	public void setUserTelphone(String user_telphone) {
		this.user_telphone = user_telphone;
	}
	public String getUserWebmail() {
		return user_webmail;
	}
	public void setUserWebmail(String user_webmail) {
		this.user_webmail = user_webmail;
	}
	public String getUserCity() {
		return user_city;
	}
	public void setUserCity(String user_city) {
		this.user_city = user_city;
	}
	public Date getCreateDate() {
		return user_registration_time;
	}
	public void setCreateDate(Date user_registration_time) {
		this.user_registration_time =user_registration_time;
	}
	public boolean getVip() {
		return vip;
	}
	public void setVip(boolean vip) {
		this.vip =vip;
	}
	public Date getVipEndDate() {
		return vip_end;
	}
	public void setVipEndDate(Date vip_end) {
		this.vip_end =vip_end;
	}
}
