package com.estabild.assignment.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estabild.assignment.dto.LogInRecordDTO;
import com.estabild.assignment.exception.UsernameNotFoundException;
import com.estabild.assignment.model.LogInRecord;
import com.estabild.assignment.service.ILogInRecordService;
import com.estabild.assignment.utils.ConvertionUtils;

@RestController
@RequestMapping("estabild/stats")
public class LogInRecordController {

	@Autowired
	ILogInRecordService logInRecordService;

	// request parameter success is set as optional so that log records can be requested by passing username only
	@GetMapping("/login_records")
	public List<LogInRecordDTO> getLogInRecords(@RequestParam String username,
			                                    @RequestParam(required = false) Boolean success) 
	{

		try {
			List<LogInRecord> logInRecords = logInRecordService.getLoginRecords(username, success);
			
			return logInRecords.stream()
					           .map(ConvertionUtils::convertToDTO)
					           .collect(Collectors.toList());
		} catch (UsernameNotFoundException usernameNotFoundException) {
			throw usernameNotFoundException;
		}

	}

}
