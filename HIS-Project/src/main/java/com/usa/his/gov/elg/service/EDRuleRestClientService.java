package com.usa.his.gov.elg.service;

import java.text.ParseException;

import com.usa.his.gov.elg.model.ElgDetails;
import com.usa.his.gov.exception.HisException;

public interface EDRuleRestClientService {

	public ElgDetails saveEDInfo(Integer caseNumber) throws HisException, ParseException;
	public boolean infoExist(Integer caseNumber)throws HisException; 
}
