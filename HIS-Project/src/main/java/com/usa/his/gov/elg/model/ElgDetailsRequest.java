 package com.usa.his.gov.elg.model;

import java.util.Date;

import lombok.Data;

@Data
public class ElgDetailsRequest {
	private String planName;
	private String planStatus;
	private String planStartDate;
	private String planEndDate;
	private String benefitAmount;
	private String denialReson;

}
