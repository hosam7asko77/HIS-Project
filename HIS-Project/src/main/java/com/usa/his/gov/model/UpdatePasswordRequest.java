package com.usa.his.gov.model;

import lombok.Data;

@Data
public class UpdatePasswordRequest {

	private String password;
	private String oldPassword;
	private String email;
}
