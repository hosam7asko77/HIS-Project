package com.usa.his.gov.user.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class HisPlan {

	private String planId;
	private String planName;
	private String discript;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date endDate;
	private String publicId;

}
