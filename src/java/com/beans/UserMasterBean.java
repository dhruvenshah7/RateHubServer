package com.beans;

public class UserMasterBean {

	private int uId;
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String conPassword;

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConPassword() {
		return conPassword;
	}

	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
	}

}
