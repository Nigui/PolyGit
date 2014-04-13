package com.example.polyjoule.Exceptions;

public class LoadingErrorException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public LoadingErrorException() {
		super();
	}

	public LoadingErrorException(String detailMessage) {
		super(detailMessage);
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	
}
