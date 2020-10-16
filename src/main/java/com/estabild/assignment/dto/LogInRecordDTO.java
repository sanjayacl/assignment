package com.estabild.assignment.dto;

import java.util.Date;

/**
 * @author sanjaya
 * DTO for the LogInRecord entity
 */
public class LogInRecordDTO {

	private UserDTO user;
	private Date logInTime;
	private boolean success;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Date getLogInTime() {
		return logInTime;
	}

	public void setLogInTime(Date logInTime) {
		this.logInTime = logInTime;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
