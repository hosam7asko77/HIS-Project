package com.usa.his.gov.config;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.usa.his.gov.appregister.entity.HisAppRegisterEntity;
import com.usa.his.gov.appregister.repository.HisAppRegisterReepository;
import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.dc.entity.HisCasePlanEntity;
import com.usa.his.gov.dc.entity.HisJobDtlsEntity;
import com.usa.his.gov.dc.repository.HisCaseDtlsRepository;
import com.usa.his.gov.dc.repository.HisCasePlanRepoistory;
import com.usa.his.gov.dc.repository.HisJobDtlRepository;
import com.usa.his.gov.elg.model.ElgDetails;
import com.usa.his.gov.elg.model.ElgDetailsRequest;
import com.usa.his.gov.elg.model.IndvInfo;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.plan.entity.HisPlanEntity;
import com.usa.his.gov.plan.repository.HisPlanRepository;
@Component
public class EDRuleClient {
	Logger log=LoggerFactory.getLogger(EDRuleClient.class);
	@Autowired
	HisCasePlanRepoistory casePlanRepo;
	@Autowired 
	HisAppRegisterReepository appRegisterRepo;
	@Autowired 
	HisPlanRepository planRepo;
	@Autowired
	HisJobDtlRepository jobRepo;
	@Autowired
	HisCaseDtlsRepository caseRepo;
	@Autowired
	RestTemplate restTemplate;
	private static final String ED_REST_API_POST_URL = "http://localhost:2020/determindElig";
	

	public ElgDetails sendEDRequest(Integer caseNumber) throws HisException, ParseException {
		IndvInfo info = this.collectInfo(caseNumber);
		ElgDetailsRequest detailsRequest= new ElgDetailsRequest();
		detailsRequest.setPlanName(info.getPlanName());
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		HttpEntity<IndvInfo> request=new HttpEntity<>(info, headers);
		ResponseEntity<ElgDetailsRequest> response=restTemplate.postForEntity(ED_REST_API_POST_URL, request, ElgDetailsRequest.class);
		if (response.getStatusCodeValue()== 200) {
			System.out.println(response.getBody());
			ElgDetails elgDetails = new ElgDetails();
			BeanUtils.copyProperties(response.getBody(), elgDetails);
			if (elgDetails.getPlanEndDate()!=null) {
				SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/yyyy");
				elgDetails.setPlanEndDate(dateFormat.parse(response.getBody().getPlanEndDate()));
				elgDetails.setPlanStartDate(dateFormat.parse(response.getBody().getPlanStartDate()));
			}

			elgDetails.setCaseNumber(caseNumber);
			return elgDetails;
			
		}else {
			return null;
		}
		
	}
	private IndvInfo collectInfo(Integer caseNumber) throws HisException{
		IndvInfo indvInfo = new IndvInfo();
		log.info("EDRuleClientServiceImpl start collectInfo()");
		HisCaseDtlsEntity hisCaseDtlsEntity = caseRepo.findById(caseNumber).get();
		HisAppRegisterEntity registerEntity = hisCaseDtlsEntity.getAppRegister();
		HisCasePlanEntity casePlanEntity = casePlanRepo.findByCaseDtlsEntity(hisCaseDtlsEntity);
		HisPlanEntity hisPlanEntity = planRepo.findById(casePlanEntity.getPlanEntity().getPlanId()).get();
		indvInfo.setIndvDob(registerEntity.getDob().toString());
		indvInfo.setIndvFirstName(registerEntity.getFirstName());
		indvInfo.setIndvLastName(registerEntity.getLastName());
		boolean exists = false;
		HisJobDtlsEntity jobDtlsEntity = jobRepo.findByCaseDtlsEntity(hisCaseDtlsEntity);
		if (jobDtlsEntity!=null) {
			
			indvInfo.setTotleIncome(jobDtlsEntity.getIncome());
			
			exists = true;
		}
		indvInfo.setEmployed(exists);
		System.out.println(exists);
		indvInfo.setPlanName(hisPlanEntity.getPlanName());
		log.info("EDRuleClientServiceImpl collectInfo() end");
		return indvInfo;
		
	}

}
