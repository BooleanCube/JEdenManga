package com.codingotaku.api.jmanga.exception;

import com.codingotaku.api.jmanga.manga.MyManga;

/** Thrown when trying to access {@link MyManga} when user is not logged in */
public class AccountAccessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountAccessException() {
		super("You are not logged in");
	}
}
