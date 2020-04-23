package com.usa.his.gov.exception.restapi;

import java.util.Date;

import lombok.Data;
@Data
public class ResponseExceptionModel {
	private Date timeStam;
	private String message;
	private String details;
	public ResponseExceptionModel(Date timeStam, String message, String details) {
		super();
		this.timeStam = timeStam;
		this.message = message;
		this.details = details;
	}
	
	
	
}
