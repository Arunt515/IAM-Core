package fr.epita.iam.datamodel;

import java.util.Map;

public class Login {
	private String userName;
	private String password;


	/**
	 * @param displayName
	 * @param uid
	 * @param email
	 */
	public Login(String userName, String password) {
		this.userName = userName;
		this.password = password;
		
	}
	public Login()
	{
		
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
}
