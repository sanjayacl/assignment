package com.estabild.assignment.utils;

import com.estabild.assignment.dto.LogInRecordDTO;
import com.estabild.assignment.dto.UserDTO;
import com.estabild.assignment.model.LogInRecord;
import com.estabild.assignment.model.User;

/**
 * @author sanjaya
 * Utility class for converting DTO to model and wise versa
 */
public class ConvertionUtils {

	public static UserDTO convertToDTO(User user) {
		UserDTO userDto = new UserDTO();
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setUsername(user.getUsername());
		userDto.setPassword("xxxxxx");
		return userDto;
	}

	public static User convertToModel(UserDTO userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		return user;
	}

	public static LogInRecordDTO convertToDTO(LogInRecord logInRecord) {
		LogInRecordDTO logInRecordDto = new LogInRecordDTO();
		logInRecordDto.setLogInTime(logInRecord.getLogInTime());
		logInRecordDto.setUser(convertToDTO(logInRecord.getUser()));
		logInRecordDto.setSuccess(logInRecord.isSuccess());
		return logInRecordDto;
	}
}
