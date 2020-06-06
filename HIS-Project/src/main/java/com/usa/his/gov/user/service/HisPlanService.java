package com.usa.his.gov.user.service;

import java.util.HashMap;
import java.util.List;

import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.user.model.HisPlan;

public interface HisPlanService {
	/**
	 * this method using to add new plan
	 * 
	 * @param plan
	 * @param pId  public user id
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
	 * 
	 * @param planId
	 * @return
	 * @throws HisException
	 */
	public HisPlan getPlanByPlanId(String planId) throws HisException;

	/**
	 * delete the plan
	 * 
	 * @param planId
	 * @throws HisException
	 */
	public void deletePlan(String planId) throws HisException;

	/**
	 * this method using for update plan details
	 * 
	 * @param plan
	 * @return
	 * @throws HisException
	 */
	public boolean updatePlan(HisPlan plan) throws HisException;
	
	public HisPlan getPlanByName(String planName)throws HisException;
	

}
