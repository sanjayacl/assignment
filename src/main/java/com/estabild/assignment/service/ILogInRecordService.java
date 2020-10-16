package com.estabild.assignment.service;

import java.util.List;

import com.estabild.assignment.exception.UsernameNotFoundException;
import com.estabild.assignment.model.LogInRecord;

public interface ILogInRecordService {

	public void addLogInRecord(LogInRecord logInRecord);
	public List<LogInRecord> getLoginRecords(String username, Boolean success) throws UsernameNotFoundException;
}
