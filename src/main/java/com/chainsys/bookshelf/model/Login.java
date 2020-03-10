package com.chainsys.bookshelf.model;

public class Login {

	private int loginNo;
	private String userName;
	private String eMail;
	private Long phoneNo;
	private String preferenceType;
	private String password;

	public int getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(int loginNo) {
		this.loginNo = loginNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public Long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPreferenceType() {
		return preferenceType;
	}

	public void setPreferenceType(String preferenceType) {
		this.preferenceType = preferenceType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [loginNo=" + loginNo + ", userName=" + userName + ", eMail=" + eMail + ", phoneNo=" + phoneNo
				+ ", preferenceType=" + preferenceType + ", password=" + password + "]";
	}

}
