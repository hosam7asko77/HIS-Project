package com.usa.his.gov.appregister.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.his.gov.appregister.entity.HisAppRegisterEntity;
import com.usa.his.gov.appregister.model.HisAppRegister;
import com.usa.his.gov.appregister.repository.HisAppRegisterReepository;
import com.usa.his.gov.appregister.service.HisAppRegisterService;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.share.HisConverter;
import com.usa.his.gov.user.controller.HisAdminController;
import com.usa.his.gov.user.entity.HisUserDtlsEntity;
import com.usa.his.gov.user.repository.HisUserDtlsRepository;

/**
 * this class which is implement HisAppServiec
 * 
 * @author hosam7asko
 *
 */
@Service
public class HisAppRegisterServiceImpl implements HisAppRegisterService {
	/**
	 * Enable logging for the class
	 */
	private static final Logger log = LoggerFactory.getLogger(HisAdminController.class);
	/**
	 * inject HisAppRegisterReepository create an object
	 */
	@Autowired
	HisAppRegisterReepository appReepository;
	/**
	 * inject HisUserDtlsRepository to performing database operations
	 */
	@Autowired
	HisUserDtlsRepository userRepository;
	/**
	 * inject Convert to convert model to entity
	 */
	@Autowired
	private HisConverter converter;

	@Override
	public boolean newApplication(HisAppRegister register) throws HisException {
		log.info("HisAppRegisterServiceImpl newApplication() method starting");
		HisAppRegisterEntity registerEntity = new HisAppRegisterEntity();
		HisUserDtlsEntity dtlsEntity = userRepository.findByPublicId(register.getPublicUserId());
		registerEntity.setDtlsEntity(dtlsEntity);
		registerEntity.setDeleteStatus(false);
		BeanUtils.copyProperties(register, registerEntity);
		HisAppRegisterEntity savedValue = appReepository.save(registerEntity);
		if (savedValue != null) {
			log.info("HisAppRegisterServiceImpl newApplication() method end successfuly");
			return true;
		} else {
			log.info("HisAppRegisterServiceImpl newApplication() method end with exception");
			throw new HisException();
		}
	}

	@Override
	public HisAppRegister getApplicationById(String appId) throws HisException {
		log.info("HisAppRegisterServiceImpl getApplicationById() method starting");
		HisAppRegisterEntity registerEntity = appReepository.findById(appId).get();
		if (registerEntity != null) {
			HisAppRegister returnValue = new HisAppRegister();
			BeanUtils.copyProperties(registerEntity, returnValue);
			log.info("HisAppRegisterServiceImpl getApplicationById() method end successfuly");
			return returnValue;
		}
		log.info("HisAppRegisterServiceImpl getApplicationById() method end and return null");
		return null;
	}

	@Override
	public List<HisAppRegister> getAllApplications() throws HisException {
		log.info("HisAppRegisterServiceImpl getAllApplications() method end successfuly");
		List<HisAppRegisterEntity> listEntities = appReepository.findAll();
		List<HisAppRegister> returnValue = converter.convertHisAppRegisterEntityToHisAppRegister(listEntities);
		log.info("HisAppRegisterServiceImpl getAllApplications() method end end");
		return returnValue;
	}

	@Override
	public boolean updateDeleteStatus(boolean ststus,String appId) {
		 boolean returnValue=false;
		Integer updateStatus = appReepository.updateStatus(ststus, appId);
		if (updateStatus!=0) {
			returnValue=true;
			return returnValue;
			
		}
		return returnValue;
	}

	@Override
	public boolean updateApplication(HisAppRegister register) {
		HisAppRegisterEntity registerEntity = new HisAppRegisterEntity();
		BeanUtils.copyProperties(register, registerEntity);
		HisAppRegisterEntity savedValue = appReepository.save(registerEntity);
		return savedValue!=null;
	}

}
