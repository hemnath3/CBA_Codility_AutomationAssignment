package com.selenium.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationException extends FrameworkException {

	public BrowserInvocationException(String message) {

		super(message);
	}

	public BrowserInvocationException(String message, Throwable cause) {

		super(message, cause);
	}

}
