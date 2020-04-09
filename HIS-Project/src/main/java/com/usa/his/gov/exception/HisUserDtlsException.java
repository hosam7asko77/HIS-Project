package com.usa.his.gov.exception;

/**
 * this class using for handling the exception that may occur in the HisUserDtlsService class
 * @author hosam7asko
 *
 */

public class HisUserDtlsException extends Exception {

	private static final long serialVersionUID = 1L;
	

	public HisUserDtlsException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HisUserDtlsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}


	public HisUserDtlsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


	public HisUserDtlsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	public HisUserDtlsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	

}
