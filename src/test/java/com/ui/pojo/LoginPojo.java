package com.ui.pojo;

public class LoginPojo {
	
	private String userName;
	private String emailId ;
	private String password ;
	
	public LoginPojo(String userName,String emailId, String password) {
		super();
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "LoginPojo [userName=" + userName + ", emailId=" + emailId + ", password=" + password + "]";
	}


	
	

}
