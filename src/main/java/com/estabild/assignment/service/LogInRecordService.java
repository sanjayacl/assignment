package com.estabild.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estabild.assignment.exception.UsernameNotFoundException;
import com.estabild.assignment.model.LogInRecord;
import com.estabild.assignment.model.User;
import com.estabild.assignment.repository.ILogInRecordRepository;
import com.estabild.assignment.repository.IUserRepository;

@Service
public class LogInRecordService implements ILogInRecordService {

	@Autowired
	ILogInRecordRepository logInRecordRepository;

	@Autowired
	IUserRepository userRepository;

	@Override
	@Transactional
	public void addLogInRecord(LogInRecord logInRecord) {
		logInRecordRepository.save(logInRecord);

	}

	@Override
	@Transactional(readOnly = true)
	public List<LogInRecord> getLoginRecords(String username, Boolean success) throws UsernameNotFoundException {

		List<User> usersList = userRepository.findByUsername(username);

		if (usersList == null || usersList.isEmpty()) {
			throw new UsernameNotFoundException();
		}

		if (success != null) {
			return logInRecordRepository.findTop5ByUserUsernameAndSuccessOrderByLogInTimeDesc(username, success);
		} else {
			return logInRecordRepository.findTop5ByUserUsernameOrderByLogInTimeDesc(username);
		}
	}

}
