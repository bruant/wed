package com.tres.wedding.web.model;

import java.io.Serializable;

public class UserModel extends Model implements Serializable {

	private static final long serialVersionUID = 8795205159924950128L;

	private String name;

	private String email;

	private String password;

	private String passwordToConfirm;

	private String guestCode = "";

	public UserModel() {
	}

	public String getGuestCode() {
		return guestCode;
	}

	public void setGuestCode(String guestCode) {
		this.guestCode = guestCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPasswordToConfirm() {
		return passwordToConfirm;
	}

	public void setPasswordToConfirm(String passwordToConfirm) {
		this.passwordToConfirm = passwordToConfirm;
	}
}
