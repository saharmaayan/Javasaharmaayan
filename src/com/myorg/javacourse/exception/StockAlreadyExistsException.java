package com.myorg.javacourse.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class StockAlreadyExistsException extends PortfolioException{

	public StockAlreadyExistsException() {
		super();
		
	}

	public StockAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public StockAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public StockAlreadyExistsException(String message) {
		super(message);
		
	}

	public StockAlreadyExistsException(Throwable cause) {
		super(cause);
		
	}
	
}
