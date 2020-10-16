package com.estabild.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estabild.assignment.dto.UserDTO;
import com.estabild.assignment.exception.AuthenticationFailureException;
import com.estabild.assignment.exception.UsernameAlreadyExistsException;
import com.estabild.assignment.model.User;
import com.estabild.assignment.service.IUserService;
import com.estabild.assignment.utils.ConvertionUtils;

@RestController
@RequestMapping("estabild/user")
public class UserController {

	@Autowired
	IUserService userService;

	@PostMapping("/register")
	public void addUser(@RequestBody UserDTO userDto) {
		User user = ConvertionUtils.convertToModel(userDto);
		try {
			userService.registerUser(user);
		} catch (UsernameAlreadyExistsException usernameAlreadyExistsException) {
			throw usernameAlreadyExistsException;
		}
	}

	@PostMapping("/login")
	public void logInUser(@RequestBody UserDTO userDto) {
		User user = ConvertionUtils.convertToModel(userDto);
		try {
			userService.logInUser(user);
		} catch (AuthenticationFailureException authenticationFailureException) {
			throw authenticationFailureException;
		}
	}

}
