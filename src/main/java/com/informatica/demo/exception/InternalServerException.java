package com.informatica.demo.exception;

public class InternalServerException extends RuntimeException {
	private static final long serialVersionUID = 1L;
    private final String userMessage;


	public InternalServerException(String userMessage, Exception exception) {
        super(exception);
        this.userMessage = userMessage;
	}

    public String getUserMessage() {
        return userMessage;
    }
}
