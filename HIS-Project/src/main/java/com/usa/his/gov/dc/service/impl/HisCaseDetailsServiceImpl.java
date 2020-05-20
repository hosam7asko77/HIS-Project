package com.usa.his.gov.dc.service.impl;


import java.util.Base64;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.dc.entity.HisCasePlanEntity;
import com.usa.his.gov.dc.entity.HisCrimeDtlsEntity;
import com.usa.his.gov.dc.entity.HisFamilyDtlsEntity;
import com.usa.his.gov.dc.entity.HisJobDtlsEntity;
import com.usa.his.gov.dc.entity.HisKidsDtlsEntity;
import com.usa.his.gov.dc.model.HisCaseDtls;
import com.usa.his.gov.dc.model.HisCasePlan;
import com.usa.his.gov.dc.model.HisCrimeDtls;
import com.usa.his.gov.dc.model.HisFamilyDtls;
import com.usa.his.gov.dc.model.HisJobDtls;
import com.usa.his.gov.dc.model.HisKidsDtls;
import com.usa.his.gov.dc.repository.HisCaseDtlsRepository;
import com.usa.his.gov.dc.repository.HisCasePlanRepoistory;
import com.usa.his.gov.dc.repository.HisCrimeDtlsRepository;
import com.usa.his.gov.dc.repository.HisFamilyRepository;
import com.usa.his.gov.dc.repository.HisJobDtlRepository;
import com.usa.his.gov.dc.repository.HisKidsDtlsRepository;
import com.usa.his.gov.dc.service.HisCaseDtlservice;
import com.usa.his.gov.appregister.entity.HisAppRegisterEntity;
import com.usa.his.gov.appregister.repository.HisAppRegisterReepository;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.plan.repository.HisPlanRepository;
import com.usa.his.gov.share.HisConverter;
import com.usa.his.gov.user.entity.HisUserDtlsEntity;
import com.usa.his.gov.user.repository.HisUserDtlsRepository;

/**
 * this class which implement HiscaseDtlService using to performing case
 * business logic
 * 
 * @author hosam7asko
 *
 */
@Service
public class HisCaseDetailsServiceImpl implements HisCaseDtlservice {
	/**
	 * Enable logging for the class
	 */
	private static final Logger log = LoggerFactory.getLogger(HisCaseDetailsServiceImpl.class);
	/**
	 * inject HisCaseDtlsRepository create an object
	 */
	@Autowired
	private HisCaseDtlsRepository caseRepositor;

	@Autowired
	private HisAppRegisterReepository appRepository;

	@Autowired
	private HisUserDtlsRepository userRepository;

	@Autowired
	private HisCasePlanRepoistory casePlanRepository;

	@Autowired
	private HisPlanRepository planReposiotry;
	@Autowired
	private HisFamilyRepository familyRepository;

	@Autowired
	private HisKidsDtlsRepository kidsRepoistory;
	@Autowired
	private HisJobDtlRepository jobRepository;
	@Autowired
	private HisCrimeDtlsRepository crimeRepository;
	/**
	 * inject Convert to convert model to entity
	 */
	@Autowired
	private HisConverter converter;
	

	/**
	 * this method using to create new Case
	 */
	@Override
	public HisCaseDtls newCase(HisCaseDtls caseDtls) throws HisException {
		log.info("in HisCaseDetailsServiceImpl newCase() method starting");
		HisAppRegisterEntity appRegister = appRepository.findById(caseDtls.getAppRegister()).get();
		HisUserDtlsEntity userDtls = userRepository.findById(caseDtls.getUserId()).get();
		HisCaseDtlsEntity caseDtlsEntity = new HisCaseDtlsEntity();
		BeanUtils.copyProperties(caseDtls, caseDtlsEntity);
		caseDtlsEntity.setAppRegister(appRegister);
		caseDtlsEntity.setDtlsEntity(userDtls);
		HisCaseDtlsEntity returnValue = caseRepositor.save(caseDtlsEntity);
		if (returnValue != null) {
			BeanUtils.copyProperties(returnValue, caseDtls);
			log.info("in HisCaseDetailsServiceImpl newCase() method end");
			return caseDtls;
		} else {
			log.info("in HisCaseDetailsServiceImpl newCase() method end with exception");
			throw new HisException();
		}

	}

	@Override
	public HisCaseDtls getCaseDetails(Integer caseNumber) throws HisException {
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(caseNumber).get();
		if (caseDtlsEntity != null) {
			HisCaseDtls caseDtls = new HisCaseDtls();
			BeanUtils.copyProperties(caseDtlsEntity, caseDtls);
			caseDtls.setAppRegister(caseDtlsEntity.getAppRegister().getAppId());
			return caseDtls;
		}
		return null;
	}

	@Override
	public HisCasePlan addCasePlan(HisCasePlan casePlan) throws HisException {
		HisCasePlanEntity casePlanEntity = new HisCasePlanEntity();
		casePlanEntity.setCaseDtlsEntity(caseRepositor.findById(casePlan.getCaseNumber()).get());
		casePlanEntity.setPlanEntity(planReposiotry.findById(casePlan.getPlanId()).get());
		HisCasePlanEntity saveCasePlan = casePlanRepository.save(casePlanEntity);
		if (saveCasePlan != null) {
			casePlan.setCaseNumber(saveCasePlan.getCaseDtlsEntity().getCaseNumber());
			casePlan.setPlanId(saveCasePlan.getPlanEntity().getPlanId());
			return casePlan;
		} else {
			throw new HisException();
		}
	}

	@Override
	public HisFamilyDtls addFamilyDtls(HisFamilyDtls familyDtls) throws HisException {
		if (familyDtls.getHaveChild()==null) {
			familyDtls.setHaveChild(false);
		}
		HisFamilyDtlsEntity familyDtlsEntity = new HisFamilyDtlsEntity();
		BeanUtils.copyProperties(familyDtls, familyDtlsEntity);
		familyDtlsEntity.setCaseDtlsEntity(caseRepositor.findById(familyDtls.getCaseNumber()).get());
		HisFamilyDtlsEntity saveFamily = familyRepository.save(familyDtlsEntity);
		if (saveFamily != null) {
			BeanUtils.copyProperties(saveFamily, familyDtls);
			return familyDtls;
		} else {
			throw new HisException();
		}

	}

	@Override
	public HisKidsDtls addKid(HisKidsDtls kidsDtls) throws HisException {
		HisKidsDtlsEntity kidsDtlsEntity = new HisKidsDtlsEntity();
		BeanUtils.copyProperties(kidsDtls, kidsDtlsEntity);
		kidsDtlsEntity.setCaseDtlsEntity(caseRepositor.findById(kidsDtls.getCaseNumber()).get());
		HisKidsDtlsEntity savedValue = kidsRepoistory.save(kidsDtlsEntity);
		if (savedValue != null) {
			BeanUtils.copyProperties(savedValue, kidsDtls);
			kidsDtls.setCaseNumber(savedValue.getCaseDtlsEntity().getCaseNumber());
			return kidsDtls;
		} else {
			throw new HisException();
		}
	}

	@Override
	public List<HisKidsDtls> getAllKids(Integer caseNumber) throws HisException {
		List<HisKidsDtlsEntity> listOfKids = kidsRepoistory
				.findByCaseDtlsEntity(caseRepositor.findById(caseNumber).get());
		List<HisKidsDtls> kidsDtls = converter.convertHisKidsDtlsEntityToHisKidsDtls(listOfKids);
		return kidsDtls;
	}

	@Override
	public HisJobDtls addJobDetails(HisJobDtls jobDtls) throws HisException {
		System.out.println(jobDtls.getCaseNumber());
		HisJobDtlsEntity jobDtlsEntity = new HisJobDtlsEntity();
		BeanUtils.copyProperties(jobDtls, jobDtlsEntity);
		jobDtlsEntity.setCaseDtlsEntity(caseRepositor.findById(jobDtls.getCaseNumber()).get());
		HisJobDtlsEntity savedValue = jobRepository.save(jobDtlsEntity);
		if (savedValue != null) {
			BeanUtils.copyProperties(savedValue, jobDtls);
			return jobDtls;
		}else {
			throw new HisException();
		}
		
	}

	@Override
	public HisCrimeDtls addCrimeDetails(HisCrimeDtls crimeDtls) throws HisException {
		log.info("in HisCaseDetailsServiceImpl HisCrimeDtls() method starting");
		HisCrimeDtlsEntity crimeDtlsEntity = new HisCrimeDtlsEntity();
		BeanUtils.copyProperties(crimeDtls, crimeDtlsEntity);
		String incidentType = getIncidentType(crimeDtls.getIncidentType());
		crimeDtlsEntity.setIncidentType(incidentType);
		crimeDtlsEntity.setCaseDtlsEntity(caseRepositor.findById(crimeDtls.getCaseNumber()).get());
		crimeDtlsEntity.setCrimeReport(converter.converMultiPartTByte(crimeDtls.getCrimeReport()));
		HisCrimeDtlsEntity savedValue = crimeRepository.save(crimeDtlsEntity);
		if (savedValue != null) {
			log.info("in HisCaseDetailsServiceImpl HisCrimeDtls() method copy");
			BeanUtils.copyProperties(savedValue, crimeDtls);
			crimeDtls.setCaseNumber(savedValue.getCaseDtlsEntity().getCaseNumber());
			return crimeDtls;
		}else {
			log.info("in HisCaseDetailsServiceImpl HisCrimeDtls() the not save starting");
			throw new HisException();
		}
	}

	@Override
	public boolean appExist(String appId) throws HisException {
		HisAppRegisterEntity appRegisterEntity = appRepository.findById(appId).get();
		HisCaseDtlsEntity findByAppRegister = caseRepositor.findByAppRegister(appRegisterEntity);
		if (findByAppRegister == null) {
			return false;
		}else
		{
		return true;
		}
	}
	
	private String getIncidentType(String[] types) {
		StringBuilder stringBuilder=new StringBuilder();
		for (String string : types) {
			stringBuilder.append(" ").append(string);
		}
		String returnValue=stringBuilder.toString();
		return returnValue;
	}

	@Override
	public HisFamilyDtls getFamilyByCase(Integer caseNumber) throws HisException {
		HisCaseDtlsEntity hisCaseDtlsEntity = caseRepositor.findById(caseNumber).get();
		HisFamilyDtlsEntity familyDtlsEntity = familyRepository.findByCaseDtlsEntity(hisCaseDtlsEntity);
		if (familyDtlsEntity != null) {
			HisFamilyDtls hisFamilyDtls = new HisFamilyDtls();
			BeanUtils.copyProperties(familyDtlsEntity, hisFamilyDtls);
			hisFamilyDtls.setCaseNumber(familyDtlsEntity.getCaseDtlsEntity().getCaseNumber());
			return hisFamilyDtls;
		}else {
			return null;
		}
		
	}

	@Override
	public HisJobDtls getJobByCaseNumber(Integer caseNumber) throws HisException {
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(caseNumber).get();
		HisJobDtlsEntity jobDtlsEntity=jobRepository.findByCaseDtlsEntity(caseDtlsEntity);
		if (jobDtlsEntity != null) {
			HisJobDtls hisJobDtls = new HisJobDtls();
			BeanUtils.copyProperties(jobDtlsEntity, hisJobDtls);
			hisJobDtls.setCaseNumber(jobDtlsEntity.getCaseDtlsEntity().getCaseNumber());
			return hisJobDtls;
		}else {
			return null;
		}
		
	}

	@Override
	public HisCrimeDtls getCrimeDtls(Integer caseNumber) throws HisException {
		HisCrimeDtlsEntity crimeDtlsEntity = crimeRepository.findByCaseDtlsEntity(caseRepositor.findById(caseNumber).get());
		if (crimeDtlsEntity != null) {
			HisCrimeDtls hisCrimeDtls = new HisCrimeDtls();
			BeanUtils.copyProperties(crimeDtlsEntity, hisCrimeDtls);
			hisCrimeDtls.setReportImage(Base64.
					getEncoder()
					.encodeToString(crimeDtlsEntity.getCrimeReport()));
			hisCrimeDtls.setIncidentType(crimeDtlsEntity.getIncidentType().split(" "));
			return hisCrimeDtls;
		}else {
			return null;
		}
		
	}

	@Override
	public void deleteKids(Integer kidsId) throws HisException {
		kidsRepoistory.deleteById(kidsId);
	}

	@Override
	public HisKidsDtls getKidById(Integer KidId) throws HisException {
		HisKidsDtlsEntity hisKidsDtlsEntity = kidsRepoistory.findById(KidId).get();
		if (hisKidsDtlsEntity != null) {
			HisKidsDtls kidsDtls = new HisKidsDtls();
			BeanUtils.copyProperties(hisKidsDtlsEntity, kidsDtls);
			kidsDtls.setCaseNumber(hisKidsDtlsEntity.getCaseDtlsEntity().getCaseNumber());
			System.out.println(kidsDtls.getCaseNumber());
			return kidsDtls;
		}else {
			throw new HisException();
		}
		
	}

	@Override
	public HisCasePlan getPlanByCaseNumber(Integer caseNumber) throws HisException {
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(caseNumber).get();
		HisCasePlanEntity planEntity = casePlanRepository.findByCaseDtlsEntity(caseDtlsEntity);
		if (planEntity != null) {
			HisCasePlan hisCasePlan = new HisCasePlan();
			BeanUtils.copyProperties(planEntity, hisCasePlan);
			hisCasePlan.setCaseNumber(planEntity.getCaseDtlsEntity().getCaseNumber());
			return hisCasePlan;
		}
		return null;
	}


}
