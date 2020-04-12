package com.usa.his.gov.service;

import java.util.List;

import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.HisPlan;

public interface HisPlanService {
	/**
	 * this method using to add new plan
	 * 
	 * @param plan
	 * @return
	 * @throws HisException
	 */
	public HisPlan newPlan(HisPlan plan) throws HisException;

	/**
	 * this method use to get all the plan
	 * 
	 * @return
	 * @throws HisException
	 */
	public List<HisPlan> getAllPlans() throws HisException;
/**
 * this method use to get plan by plan id
 * @param planId
 * @return
 * @throws HisException
 */
	public HisPlan getPlanByPlanId(String planId)throws HisException;
/**
 * delete the plan
 * @param planId
 * @throws HisException
 */
	public void deletePlan(String planId)throws HisException;
}
