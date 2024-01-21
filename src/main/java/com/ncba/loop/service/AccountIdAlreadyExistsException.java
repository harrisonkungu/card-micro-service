package com.ncba.loop.service;

public class AccountIdAlreadyExistsException extends RuntimeException {
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountIdAlreadyExistsException(String message){
	        super(message);
	    }
}
