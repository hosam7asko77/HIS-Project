package com.usa.his.gov.service.impl;



import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.usa.his.gov.appregister.entity.HisAppRegisterEntity;
import com.usa.his.gov.appregister.repository.HisAppRegisterReepository;
import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.dc.entity.HisCasePlanEntity;
import com.usa.his.gov.dc.repository.HisCaseDtlsRepository;
import com.usa.his.gov.dc.repository.HisCasePlanRepoistory;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.IndvInfo;
import com.usa.his.gov.model.PlanInfo;
import com.usa.his.gov.plan.entity.HisPlanEntity;
import com.usa.his.gov.plan.repository.HisPlanRepository;
import com.usa.his.gov.service.EDRuleRestClientService;
@Service
public class EDRuleClientServiceImpl implements EDRuleRestClientService{
	Logger log=LoggerFactory.getLogger(EDRuleClientServiceImpl.class);
	@Autowired
	HisCasePlanRepoistory casePlanRepo;
	@Autowired 
	HisAppRegisterReepository appRegisterRepo;
	@Autowired 
	HisPlanRepository planRepo;
	@Autowired
	HisCaseDtlsRepository caseRepo;
	@Autowired
	RestTemplate restTemplate;
	private static final String ED_REST_API_POST_URL = "http://localhost:2020/determindElig";
	@Override
	public IndvInfo collectInfo(Integer caseNumber) throws HisException{
		IndvInfo indvInfo = new IndvInfo();
		log.info("EDRuleClientServiceImpl start collectInfo()");
		HisCaseDtlsEntity hisCaseDtlsEntity = caseRepo.findById(caseNumber).get();
		HisAppRegisterEntity registerEntity = hisCaseDtlsEntity.getAppRegister();
		HisCasePlanEntity casePlanEntity = casePlanRepo.findByCaseDtlsEntity(hisCaseDtlsEntity);
		HisPlanEntity hisPlanEntity = planRepo.findById(casePlanEntity.getPlanEntity().getPlanId()).get();
		indvInfo.setIndvDob(registerEntity.getDob().toString());
		indvInfo.setIndvFirstName(registerEntity.getFirstName());
		indvInfo.setIndvLastName(registerEntity.getLastName());
		indvInfo.setIsEmployed("Y");
		indvInfo.setPlanName(hisPlanEntity.getPlanName());
		log.info("EDRuleClientServiceImpl collectInfo() end");
		return indvInfo;
		
	}
	@Override
	public PlanInfo sendEDRequest(Integer caseNumber) throws HisException {
		IndvInfo info = this.collectInfo(caseNumber);
		PlanInfo planInfo= new PlanInfo();
		planInfo.setPlanName(info.getPlanName());
		info.setPlanInfo(planInfo);
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<IndvInfo> request=new HttpEntity<>(info, headers);
		ResponseEntity<PlanInfo> response=restTemplate.postForEntity(ED_REST_API_POST_URL, request, PlanInfo.class);
		if (response.getStatusCodeValue()== 200) {
			System.out.println("Post Created");
			System.out.println(response.getBody());
			return response.getBody();
		}else {
			System.out.println("Post Error");
			System.out.println(response.getStatusCode());
			return null;
		}
		
	}

}
