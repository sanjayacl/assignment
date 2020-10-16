package com.estabild.assignment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estabild.assignment.exception.AuthenticationFailureException;
import com.estabild.assignment.exception.UsernameAlreadyExistsException;
import com.estabild.assignment.model.LogInRecord;
import com.estabild.assignment.model.User;
import com.estabild.assignment.repository.ILogInRecordRepository;
import com.estabild.assignment.repository.IUserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userRepository;

	@Autowired
	ILogInRecordRepository logInRecordRepository;

	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	@Transactional
	public void registerUser(User user) throws UsernameAlreadyExistsException {

		List<User> usersWithSameUsername = userRepository.findByUsername(user.getUsername());

		if (usersWithSameUsername != null && !usersWithSameUsername.isEmpty()) {
			throw new UsernameAlreadyExistsException();
		}
		String encodedPwd = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPwd);
		userRepository.save(user);

	}

	@Override
	@Transactional(noRollbackFor = { AuthenticationFailureException.class }) // we should not roll back when throwing this exception
	public void logInUser(User user) throws AuthenticationFailureException {
		List<User> users = userRepository.findByUsername(user.getUsername());
		LogInRecord logInRecord = new LogInRecord();
		logInRecord.setLogInTime(new Date());
		logInRecord.setSuccess(false);

		if (users == null || users.isEmpty()) {
			throw new AuthenticationFailureException();
		} else {
			User userRecord = users.get(0);
			logInRecord.setUser(userRecord);

			if (!passwordEncoder.matches(user.getPassword(), userRecord.getPassword())) {
				logInRecordRepository.save(logInRecord);
				throw new AuthenticationFailureException();
			}

			logInRecord.setSuccess(true);
			logInRecordRepository.save(logInRecord);
		}

	}

}
