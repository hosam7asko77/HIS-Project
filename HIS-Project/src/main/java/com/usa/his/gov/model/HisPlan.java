package com.usa.his.gov.model;

import java.util.Date;

import lombok.Data;

@Data
public class HisPlan {

	private String planId;
	private String planName;
	private String discript;
	private Date startDate;
	private Date endDate;
	private String userId;

}
