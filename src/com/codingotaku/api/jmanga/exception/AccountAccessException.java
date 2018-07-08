package com.codingotaku.api.jmanga.exception;

public class AccountAccessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountAccessException() {
		super("You are not logged in");
	}
}
