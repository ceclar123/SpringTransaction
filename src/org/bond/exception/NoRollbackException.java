package org.bond.exception;

public class NoRollbackException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8086175222072461209L;
	private String message;

	public NoRollbackException(String message) {
		super(message);
		this.message = message;
	}

	public NoRollbackException(String message, Exception e) {
		super(message, e);
		this.message = message;

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
