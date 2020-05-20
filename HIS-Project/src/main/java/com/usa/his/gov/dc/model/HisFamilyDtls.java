package com.usa.his.gov.dc.model;

import lombok.Data;

@Data
public class HisFamilyDtls {

	private Integer caseFamilyId;
	private Integer caseNumber;
	private String fatherName;
	private String matherName;
	private Integer numberBrather;
	private Integer numberSester;
	private String relationship;
	private String wifeName;
	private Integer wifeAge;
	private Boolean haveChild;
}
