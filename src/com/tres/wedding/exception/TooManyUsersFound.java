package com.tres.wedding.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="User Not Found")
public class TooManyUsersFound extends Exception {

	private static final long serialVersionUID = 344932436629155072L;

	public TooManyUsersFound(int i) {
		super("User not found " + i);
	}

	public TooManyUsersFound() {
		super();
	}
}
