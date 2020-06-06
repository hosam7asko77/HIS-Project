package com.usa.his.gov.dc.service.impl;


import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

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
import com.usa.his.gov.share.HisConverter;
import com.usa.his.gov.user.entity.HisPlanEntity;
import com.usa.his.gov.user.entity.HisUserDtlsEntity;
import com.usa.his.gov.user.repository.HisPlanRepository;
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
		HisUserDtlsEntity userDtls = userRepository.findByPublicId(caseDtls.getUserId());
		HisCaseDtlsEntity caseDtlsEntity = new HisCaseDtlsEntity();
		BeanUtils.copyProperties(caseDtls, caseDtlsEntity);
		caseDtlsEntity.setDtlsEntity(userDtls);
		HisCaseDtlsEntity returnValue = caseRepositor.save(caseDtlsEntity);
		if (returnValue != null) {
			HisAppRegisterEntity appRegister = appRepository.findById(caseDtls.getAppRegister()).get();
			appRegister.setCaseDtlsEntity(returnValue);
			appRepository.save(appRegister);
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
		System.out.println(caseNumber);
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(caseNumber).get();
		if (caseDtlsEntity != null) {
			HisCaseDtls caseDtls = new HisCaseDtls();
			BeanUtils.copyProperties(caseDtlsEntity, caseDtls);
			System.out.println("sjghfhg "+caseDtls.getFamilyDtls());
			HisAppRegisterEntity appRegisterEntity = appRepository.findByCaseDtlsEntity(caseDtlsEntity);
			caseDtls.setAppRegister(appRegisterEntity.getAppId());
			return caseDtls;
		}
		return null;
	}

	@Override
	public HisCasePlan addCasePlan(HisCasePlan casePlan) throws HisException {
		HisCasePlanEntity casePlanEntity = new HisCasePlanEntity();
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(casePlan.getCaseNumber()).get();
		BeanUtils.copyProperties(casePlan, casePlanEntity);
		HisCasePlanEntity saveCasePlan = casePlanRepository.save(casePlanEntity);
		if (saveCasePlan != null) {
			caseDtlsEntity.setCasePlanEntity(saveCasePlan);
			caseRepositor.save(caseDtlsEntity);
			BeanUtils.copyProperties(saveCasePlan, casePlan);
			casePlan.setCaseNumber(caseDtlsEntity.getCaseNumber());
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
		HisFamilyDtlsEntity saveFamily = familyRepository.save(familyDtlsEntity);
		if (saveFamily != null) {
			HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(familyDtls.getCaseNumber()).get();
			caseDtlsEntity.setFamilyDtlsEntity(saveFamily);
			caseRepositor.save(caseDtlsEntity);
			BeanUtils.copyProperties(saveFamily, familyDtls);
			familyDtls.setCaseNumber(caseDtlsEntity.getCaseNumber());
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
		HisJobDtlsEntity jobDtlsEntity = new HisJobDtlsEntity();
		BeanUtils.copyProperties(jobDtls, jobDtlsEntity);
		HisJobDtlsEntity savedValue = jobRepository.save(jobDtlsEntity);
		if (savedValue != null) {
			HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(jobDtls.getCaseNumber()).get();
			caseDtlsEntity.setJobDetailsEntity(savedValue);
			caseRepositor.save(caseDtlsEntity);
			BeanUtils.copyProperties(savedValue, jobDtls);
			jobDtls.setCaseNumber(caseDtlsEntity.getCaseNumber());
			return jobDtls;
		}else {
			throw new HisException();
		}
		
	}

	@Override
	public HisCrimeDtls addCrimeDetails(HisCrimeDtls crimeDtls) throws HisException {
		log.info("in HisCaseDetailsServiceImpl HisCrimeDtls() method starting");
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(crimeDtls.getCaseNumber()).get();
		HisCrimeDtlsEntity crimeDtlsEntity = new HisCrimeDtlsEntity();
		BeanUtils.copyProperties(crimeDtls, crimeDtlsEntity);
		String incidentType = getIncidentType(crimeDtls.getIncidentType());
		crimeDtlsEntity.setIncidentType(incidentType);
		crimeDtlsEntity.setCrimeReport(converter.converMultiPartTByte(crimeDtls.getCrimeReport()));
		HisCrimeDtlsEntity savedValue = crimeRepository.save(crimeDtlsEntity);
		if (savedValue != null) {
			log.info("in HisCaseDetailsServiceImpl HisCrimeDtls() method copy");
			caseDtlsEntity.setCrimeDtlsEntity(savedValue);
			caseRepositor.save(caseDtlsEntity);
			BeanUtils.copyProperties(savedValue, crimeDtls);
			crimeDtls.setCaseNumber(caseDtlsEntity.getCaseNumber());
			return crimeDtls;
		}else {
			log.info("in HisCaseDetailsServiceImpl HisCrimeDtls() the not save starting");
			throw new HisException();
		}
	}

	@Override
	public boolean appExist(String appId) throws HisException {
		HisAppRegisterEntity appRegisterEntity = appRepository.findById(appId).get();
		if (appRegisterEntity.getCaseDtlsEntity() == null) {
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
		if (hisCaseDtlsEntity.getFamilyDtlsEntity()==null) {
			return null;
		}
		HisFamilyDtlsEntity familyDtlsEntity = familyRepository.findById(hisCaseDtlsEntity.getFamilyDtlsEntity().getCaseFamilyId()).get();
		if (familyDtlsEntity != null) {
			HisFamilyDtls hisFamilyDtls = new HisFamilyDtls();
			BeanUtils.copyProperties(familyDtlsEntity, hisFamilyDtls);
			hisFamilyDtls.setCaseNumber(hisCaseDtlsEntity.getCaseNumber());
			return hisFamilyDtls;
		}else {
			return null;
		}
		
	}

	@Override
	public HisJobDtls getJobByCaseNumber(Integer caseNumber) throws HisException {
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(caseNumber).get();
		if (caseDtlsEntity.getJobDetailsEntity()==null) {
			return null;
		}
		HisJobDtlsEntity jobDtlsEntity=jobRepository.findById(caseDtlsEntity.getJobDetailsEntity().getJobId()).get();
		if (jobDtlsEntity != null) {
			HisJobDtls hisJobDtls = new HisJobDtls();
			BeanUtils.copyProperties(jobDtlsEntity, hisJobDtls);
			hisJobDtls.setCaseNumber(caseDtlsEntity.getCaseNumber());
			return hisJobDtls;
		}else {
			return null;
		}
		
	}

	@Override
	public HisCrimeDtls getCrimeDtls(Integer caseNumber) throws HisException {
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(caseNumber).get();
		if (caseDtlsEntity.getCrimeDtlsEntity()==null) {
			return null;
		}
		HisCrimeDtlsEntity crimeDtlsEntity = crimeRepository.findById(caseDtlsEntity.getCrimeDtlsEntity().getCrimeId()).get();
		if (crimeDtlsEntity != null) {
			HisCrimeDtls hisCrimeDtls = new HisCrimeDtls();
			BeanUtils.copyProperties(crimeDtlsEntity, hisCrimeDtls);
			hisCrimeDtls.setReportImage(Base64.
					getEncoder()
					.encodeToString(crimeDtlsEntity.getCrimeReport()));
			hisCrimeDtls.setIncidentType(crimeDtlsEntity.getIncidentType().split(" "));
			hisCrimeDtls.setCaseNumber(caseNumber);
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
	public HisCasePlan getCasePlanByCaseNumber(Integer caseNumber) throws HisException {
		HisCaseDtlsEntity caseDtlsEntity = caseRepositor.findById(caseNumber).get();
		HisCasePlanEntity casePlanEntity = casePlanRepository.findById(caseDtlsEntity.getCasePlanEntity().getCasePlanId()).get();
		if (casePlanEntity != null) {
			HisCasePlan hisCasePlan = new HisCasePlan();
			BeanUtils.copyProperties(casePlanEntity, hisCasePlan);
			hisCasePlan.setCaseNumber(caseDtlsEntity.getCaseNumber());
			hisCasePlan.setPlanName(casePlanEntity.getPlanName());
			return hisCasePlan;
		}
		return null;
	}

	@Override
	public List<HisCaseDtls> getAllCases() {
		List<HisCaseDtlsEntity> all = caseRepositor.findAll();
		return converter.converCaseDtlsToCaseEntity(all);
	}

	@Override
	public boolean deleteCase(Integer CaseNumber) throws HisException {
		HisCaseDtlsEntity entity = caseRepositor.findById(CaseNumber).get();
		HisAppRegisterEntity appRegisterEntity = appRepository.findByCaseDtlsEntity(entity);
		appRegisterEntity.setCaseDtlsEntity(null);
		appRepository.save(appRegisterEntity);
		caseRepositor.deleteById(CaseNumber);
		Optional<HisCaseDtlsEntity> caseDtlsEntity = caseRepositor.findById(CaseNumber);
		if (caseDtlsEntity.isPresent()==false) {
			return true;
		}else
		{
			return false;
		}
		
	}


}
