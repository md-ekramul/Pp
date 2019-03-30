package com.cg.exception;

public class AccountException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String message;
	
	public AccountException(String message)
	{
		this.message = message;
	}

}
