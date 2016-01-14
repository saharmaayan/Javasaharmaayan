package com.myorg.javacourse.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class StockNotExistException extends PortfolioException{

	public StockNotExistException() {
		super();
	}
	public StockNotExistException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public StockNotExistException(String message, Throwable cause) {
		super(message, cause);
	}
	public StockNotExistException(String message) {
		super(message);
	}
	public StockNotExistException(Throwable cause) {
		super(cause);
	}
}