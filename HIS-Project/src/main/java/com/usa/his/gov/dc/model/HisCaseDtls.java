package com.usa.his.gov.dc.model;


import lombok.Data;

@Data
public class HisCaseDtls {

	private Integer caseNumber;
	private String userId;
	private String appRegister;
	private HisCasePlan casePlan;
	private HisFamilyDtls familyDtls;
	private HisKidsDtls kidsDtls;
	private HisJobDtls jobDtls;
	private HisCrimeDtls crimeDtls;
}
