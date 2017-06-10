package com.rains.api.bean;

public class Emp {
	private int u_id;
	private String u_password;
	private String u_name;
	private String u_sex;
	
	public Emp(String u_password, String u_name, String u_sex) {
		super();
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_sex = u_sex;
	}


	public Emp(int u_id, String u_password, String u_name, String u_sex) {
		super();
		this.u_id = u_id;
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_sex = u_sex;
	}


	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	
	

}
