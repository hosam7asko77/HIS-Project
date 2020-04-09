package com.usa.his.gov.model;

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
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM")
	private Data Dob;
	private String gender;
	private String ssn;
	private Long phoneNumber;
	private String roleType;
	private String status;
	private Character activeSwitch;
}
