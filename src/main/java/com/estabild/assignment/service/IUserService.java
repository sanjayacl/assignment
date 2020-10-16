package com.estabild.assignment.service;

import com.estabild.assignment.exception.AuthenticationFailureException;
import com.estabild.assignment.exception.UsernameAlreadyExistsException;
import com.estabild.assignment.model.User;

public interface IUserService {
	public void registerUser(User user) throws UsernameAlreadyExistsException;
	public void logInUser(User user) throws AuthenticationFailureException;
}
