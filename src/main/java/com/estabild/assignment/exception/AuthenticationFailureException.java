package com.estabild.assignment.exception;

public class AuthenticationFailureException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    public static String errorMessage = "Authentication failure.Please use correct username and password";
}
