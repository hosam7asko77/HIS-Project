package com.usa.his.gov.elg.service.impl;


import java.text.ParseException;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.usa.his.gov.config.EDRuleClient;
import com.usa.his.gov.elg.entity.CdTriggersEntity;
import com.usa.his.gov.elg.entity.ElgDetailsEntity;
import com.usa.his.gov.elg.model.CdTriggersModel;
import com.usa.his.gov.elg.model.ElgDetails;
import com.usa.his.gov.elg.repository.CdTriggersRepository;
import com.usa.his.gov.elg.repository.ElgDetailsRepository;
import com.usa.his.gov.elg.service.EDRuleRestClientService;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.share.HisConverter;
@Service
public class EDRuleServiceImpl implements EDRuleRestClientService {

	@Autowired
	EDRuleClient ruleClient;
	@Autowired
	ElgDetailsRepository elgRepo;
	@Autowired
	CdTriggersRepository cdRepo;
	@Autowired 
	HisConverter convert;
	
	@Override
	public ElgDetails saveEDInfo(Integer caseNumber) throws HisException, ParseException {
		ElgDetailsEntity elgDetailsEntity = new ElgDetailsEntity();
		ElgDetails sendEDRequest = ruleClient.sendEDRequest(caseNumber);
		BeanUtils.copyProperties(sendEDRequest, elgDetailsEntity);
		ElgDetailsEntity returnValue = elgRepo.save(elgDetailsEntity);
		System.out.println(returnValue);
		
		if (returnValue != null && saveCdTrigger(caseNumber)) {
			BeanUtils.copyProperties(returnValue, sendEDRequest);
			return sendEDRequest;			
		}else {

			throw new HisException();
		}
		
	}

	@Override
	public boolean infoExist(Integer caseNumber) throws HisException {
		List<ElgDetailsEntity> isExist = elgRepo.findByCaseNumber(caseNumber);
		if (isExist.size()>0) {
			return true;
		}
		return false;
	}
	private boolean saveCdTrigger(Integer caseNumber) {
		CdTriggersModel triggersModel = new CdTriggersModel();
		triggersModel.setCaseNum(caseNumber);
		triggersModel.setTrgStatus("P");
		triggersModel.setNotice("No notiece");
		CdTriggersEntity triggersEntity = new CdTriggersEntity();
		BeanUtils.copyProperties(triggersModel, triggersEntity);
		return cdRepo.save(triggersEntity)!=null;
		
	}

	@Override
	public List<ElgDetails> getAllElg() throws HisException {
		List<ElgDetailsEntity> all = elgRepo.findAll();
		List<ElgDetails> elgDetails = convert.convertElgDtlsEntityToElgDetails(all);
		return elgDetails;
	}

	@Override
	public Long getCountStatus(String status) {
		long returnValue = elgRepo.countByPlanStatus(status);
		return returnValue;
	}

	@Override
	public boolean deleteElg(Integer edTraceId) {
		elgRepo.deleteById(edTraceId);
		ElgDetailsEntity detailsEntity = elgRepo.findById(edTraceId).get();
		if (detailsEntity==null) {
			return true;
		}
		return false;
	}



}
