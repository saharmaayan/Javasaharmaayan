package com.myorg.javacourse.exception;

import org.algo.exception.PortfolioException;

@SuppressWarnings("serial")
public class PortfolioFullException extends PortfolioException{

	public PortfolioFullException() {
		super();
	}
	public PortfolioFullException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	public PortfolioFullException(String message, Throwable cause) {
		super(message, cause);
	}
	public PortfolioFullException(String message) {
		super(message);
	}
	public PortfolioFullException(Throwable cause) {
		super(cause);
	}
}