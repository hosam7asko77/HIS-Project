package com.usa.his.gov.appregister.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class HisAppRegister {

	private String appId;
	private String firstName;
	private String lastName;
	private String email;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String ssn;
	private Long phoneNumber;
	private Boolean deleteStatus;
	private String publicUserId;
}
