package com.indus.training.persist.exception;

public class EmployeeDAOException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5722382033383099728L;

	public EmployeeDAOException() {
		super();
	}

	public EmployeeDAOException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EmployeeDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmployeeDAOException(String message) {
		super(message);
	}

	public EmployeeDAOException(Throwable cause) {
		super(cause);
	}
	

}
