package com.usa.his.gov.exception.restapi;

/**
 * this class using for handling the exception that may occur in the HisUserDtlsService class
 * @author hosam7asko
 *
 */

public class HisExceptionRest extends Exception {

	private static final long serialVersionUID = 1L;
	

	public HisExceptionRest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public HisExceptionRest(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}


	public HisExceptionRest(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


	public HisExceptionRest(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}


	public HisExceptionRest(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
	
	

}
