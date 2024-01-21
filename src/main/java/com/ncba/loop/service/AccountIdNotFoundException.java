package com.ncba.loop.service;

public class AccountIdNotFoundException extends RuntimeException{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountIdNotFoundException(String message){
        super(message);
    }
}