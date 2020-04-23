package com.usa.his.gov.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.his.gov.controllers.HisAdminController;
import com.usa.his.gov.entity.HisPlanEntity;
import com.usa.his.gov.entity.HisUserDtlsEntity;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.HisPlan;
import com.usa.his.gov.repository.HisPlanRepository;
import com.usa.his.gov.repository.HisUserDtlsRepository;
import com.usa.his.gov.service.HisPlanService;
import com.usa.his.gov.share.HisConverter;
/**
 * this class implement Plan service 
 * @author hosam7asko
 *
 */
@Service
public class HisPlanServiceImpl implements HisPlanService {
	
	/**
	 * Enable logging for the class
	 */

	private static final Logger log = LoggerFactory.getLogger(HisAdminController.class);

	/**
	 * inject plan repository to perform database operations
	 */
	@Autowired
	private HisPlanRepository planRepository;
	/**
	 * inject User repository to perform get info database operations
	 */
	@Autowired
	private HisUserDtlsRepository dtlsRepository;
	/**
	 * inject Convert to convert model to entity
	 */
	@Autowired
	private HisConverter converter;
	/**
	 * this method using to add new plan
	 */
	@Override
	public HisPlan newPlan(HisPlan plan,String pId) throws HisException {
		log.info("HisPlanServiceImpl newPlan() method start");
		HisPlanEntity planEntity=new HisPlanEntity();
		HisUserDtlsEntity dtlsEntity=dtlsRepository.findByPublicId(pId);
		BeanUtils.copyProperties(plan, planEntity);
		planEntity.setDtlsEntity(dtlsEntity);
		HisPlanEntity saveValue = planRepository.save(planEntity);
		if (saveValue!=null) {
			BeanUtils.copyProperties(saveValue, plan);
			log.info("HisPlanServiceImpl newPlan() method end success");
			return plan;
		}else {
			log.info("HisPlanServiceImpl newPlan() method end whith exception");
			throw new HisException();
		}
	}

	/**
	 * this method using to retrieve all plans 
	 */
	@Override
	public List<HisPlan> getAllPlans() throws HisException {
		log.info("HisPlanServiceImpl getAllPlans() method start");
		List<HisPlanEntity> allPlans = planRepository.findAll();
		List<HisPlan> returnPlans = converter.convertHisPlanEntityToHisPlan(allPlans);
		log.info("HisPlanServiceImpl getAllPlans() method end");
		return returnPlans;
	}
	
	/**
	 * this method using to get one plan base on plan Id
	 */
	@Override
	public HisPlan getPlanByPlanId(String planId) throws HisException {
	
		log.info("HisPlanServiceImpl getPlanByPlanId() method start");
		HisPlanEntity hisPlanEntity = planRepository.findById(planId).get();
		if (hisPlanEntity!=null) {
			HisPlan plan=new HisPlan();
			BeanUtils.copyProperties(hisPlanEntity, plan);
			log.info("HisPlanServiceImpl getPlanByPlanId() method end sucess");
			return plan;
		}
		log.info("HisPlanServiceImpl getPlanByPlanId() method end with null");
		return null;
	}
	/**
	 * this method use to delete plan base on Plan Id 
	 */
	@Override
	public void deletePlan(String planId) throws HisException {
		log.info("HisPlanServiceImpl deletePlan() method start");
		planRepository.deleteById(planId);
		log.info("HisPlanServiceImpl deletePlan() method end");

	}

	/**
	 * this method use to update plan
	 */
	@Override
	public boolean updatePlan(HisPlan plan) throws HisException {
		log.info("HisPlanServiceImpl updatePlan() method start");
		HisPlanEntity planEntity=planRepository.findById(plan.getPlanId()).get();
		BeanUtils.copyProperties(plan, planEntity);
		System.out.println(planEntity.getDtlsEntity().toString());
		log.info("HisPlanServiceImpl updatePlan() method end");
		return planRepository.save(planEntity)!=null;
	}


}
