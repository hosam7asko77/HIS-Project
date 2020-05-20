package com.usa.his.gov.model;

import java.util.Date;

import lombok.Data;

@Data
public class ElgDetails {
	private Integer edTraceId;
	private Integer benefitAmt;
	private Integer caseNumber;
	private String denialReason;
	private Date planEndDate;
	private String plandName;
	private Date planStartDate;
	private String plandStatus;

}
