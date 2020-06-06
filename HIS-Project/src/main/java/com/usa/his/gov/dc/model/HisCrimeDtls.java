package com.usa.his.gov.dc.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class HisCrimeDtls {
	private Integer crimeId;
	private String[] incidentType;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date incidentDate;
	private String incidentStreet;
	private String incidentCity;
	private String incidentState;
	private String incidentDescribe;
	private Integer peopelInvolved;
	private MultipartFile crimeReport;
	private Integer caseNumber;
	private String reportImage;
	
	

}
