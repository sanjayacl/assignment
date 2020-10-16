package com.estabild.assignment.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.estabild.assignment.model.LogInRecord;

@Repository
public interface ILogInRecordRepository extends CrudRepository<LogInRecord, Long> {

	public List<LogInRecord> findTop5ByUserUsernameOrderByLogInTimeDesc(String username);
	public List<LogInRecord> findTop5ByUserUsernameAndSuccessOrderByLogInTimeDesc(String username, boolean success);
}
