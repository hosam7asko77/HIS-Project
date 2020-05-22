package com.usa.his.gov.elg.service.impl;


import java.text.ParseException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.his.gov.config.EDRuleClient;
import com.usa.his.gov.elg.entity.ElgDetailsEntity;
import com.usa.his.gov.elg.model.ElgDetails;
import com.usa.his.gov.elg.repository.ElgDetailsRepository;
import com.usa.his.gov.elg.service.EDRuleRestClientService;
import com.usa.his.gov.exception.HisException;
@Service
public class EDRuleServiceImpl implements EDRuleRestClientService {

	@Autowired
	EDRuleClient ruleClient;
	@Autowired
	ElgDetailsRepository elgRepo;
	
	@Override
	public ElgDetails saveEDInfo(Integer caseNumber) throws HisException, ParseException {
		ElgDetailsEntity elgDetailsEntity = new ElgDetailsEntity();
		ElgDetails sendEDRequest = ruleClient.sendEDRequest(caseNumber);
		BeanUtils.copyProperties(sendEDRequest, elgDetailsEntity);
		ElgDetailsEntity returnValue = elgRepo.save(elgDetailsEntity);
		if (returnValue == null) {
			throw new HisException();
		}else {
			BeanUtils.copyProperties(returnValue, sendEDRequest);
			return sendEDRequest;
		}
		
	}



}
