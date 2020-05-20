package com.usa.his.gov.dc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class HisJobDtls {

	private Integer jobId;
	private String occupation;
	private String orgName;
	private String jobType;
	private String jobPosition;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date startJob;
	private Double income;
	// TFS stand for Tax For Salary
	private Double incomeTFS;
	private String incomeType;
	// FOR stand for from other resource
	private Double incomeFOR;
	private String incomeFORType;
	// FOR stand for Tax from other resource
	private Double incomeTFOR;
	private Integer caseNumber;
}
