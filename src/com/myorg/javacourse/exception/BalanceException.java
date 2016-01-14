package com.myorg.javacourse.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class BalanceException extends PortfolioException{

	public BalanceException() {
		super();
		
	}

	public BalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public BalanceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public BalanceException(String message) {
		super(message);
		
	}

	public BalanceException(Throwable cause) {
		super(cause);
		
	}
	
}
