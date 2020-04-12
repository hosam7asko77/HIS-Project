package com.usa.his.gov.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
/*
 * this class is used to model class for application register
 * and use for binding with form or behave as ModelAttriburte
 * 
 * @author HosamEldin
 */

@Data
public class HisUserDtls {

	private Integer userId;
	private String publicId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private Date dob;
	private String gender;
	private String ssn;
	private Long phoneNumber;
	private String roleType;
	private Boolean status;
	private String activeSwitch;
	
}
