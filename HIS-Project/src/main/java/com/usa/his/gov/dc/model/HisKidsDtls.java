package com.usa.his.gov.dc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class HisKidsDtls {

	private Integer childId;
	private String childName;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String ssn;
	private Integer caseNumber;
}
