package com.usa.his.gov.service;

import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.IndvInfo;
import com.usa.his.gov.model.PlanInfo;

public interface EDRuleRestClientService {

	public IndvInfo collectInfo(Integer caseNumber) throws HisException;
	public PlanInfo sendEDRequest(Integer caseNumber) throws HisException;
}
