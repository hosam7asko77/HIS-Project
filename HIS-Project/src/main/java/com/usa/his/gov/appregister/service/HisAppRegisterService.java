package com.usa.his.gov.appregister.service;

import java.util.List;

import com.usa.his.gov.appregister.model.HisAppRegister;
import com.usa.his.gov.exception.HisException;
/**
 * this Interface using to performing Application Registration logic
 * @author hosam7asko
 *
 */
public interface HisAppRegisterService {
	/**
	 * use to create new application
	 * @param register
	 * @return
	 * @throws HisException
	 */
	public boolean newApplication(HisAppRegister register)throws HisException;
	/**
	 * this method using to get only one application by using id
	 * @param appId
	 * @return
	 */
	public HisAppRegister getApplicationById(String appId)throws HisException;
	/**
	 * this method using to collect all applications 
	 * @return
	 */
	public List<HisAppRegister> getAllApplications()throws HisException;
	/**
	 * this method using to perform update delete status to application 
	 * @param appId
	 * @return
	 */
	public boolean updateDeleteStatus(boolean ststus,String appId);
	/**
	 * this method using to update application
	 * @param register
	 * @return
	 */
	public boolean updateApplication(HisAppRegister register);
	
	
	

}
