package com.usa.his.gov.dc.service;

import java.util.List;

import com.usa.his.gov.dc.model.HisCaseDtls;
import com.usa.his.gov.dc.model.HisCasePlan;
import com.usa.his.gov.dc.model.HisCrimeDtls;
import com.usa.his.gov.dc.model.HisFamilyDtls;
import com.usa.his.gov.dc.model.HisJobDtls;
import com.usa.his.gov.dc.model.HisKidsDtls;
import com.usa.his.gov.exception.HisException;

/**
 * 
 * @author hosam7asko
 *
 */
public interface HisCaseDtlservice {

	/**
	 * this method using to create new case
	 * 
	 * @param caseDtls
	 * @return
	 * @throws HisException
	 */
	public HisCaseDtls newCase(HisCaseDtls caseDtls) throws HisException;

	/**
	 * this method using to getCaseDetails by case number
	 * 
	 * @param caseNumber
	 * @return
	 * @throws HisException
	 */
	public HisCaseDtls getCaseDetails(Integer caseNumber) throws HisException;

	/**
	 * this method using to add the selected plan
	 * 
	 * @param casePlan
	 * @return
	 * @throws HisException
	 */
	public HisCasePlan addCasePlan(HisCasePlan casePlan) throws HisException;

	public HisCasePlan getCasePlanByCaseNumber(Integer caseNumber) throws HisException;
	/**
	 * this method using to add family details
	 * 
	 * @param familyDtls
	 * @return
	 * @throws HisException
	 */
	
	public HisFamilyDtls addFamilyDtls(HisFamilyDtls familyDtls) throws HisException;

	/**
	 * this method using to adding new kid
	 * 
	 * @param kidsDtls
	 * @return
	 * @throws HisException
	 */
	public HisKidsDtls addKid(HisKidsDtls kidsDtls) throws HisException;

	/**
	 * this method using to retrieving all kids Details;
	 * @param caseNumber
	 * @return
	 * @throws HisException
	 */
	public List<HisKidsDtls> getAllKids(Integer caseNumber) throws HisException;
	/**
	 * this method using to adding new job Details;
	 * @param jobDtls
	 * @return
	 * @throws HisException
	 */
	public HisJobDtls addJobDetails(HisJobDtls jobDtls)throws HisException;
	/**
	 * this method using to adding crime details
	 * @param crimeDtls
	 * @return
	 * @throws HisException
	 */
	public HisCrimeDtls addCrimeDetails(HisCrimeDtls crimeDtls)throws HisException;
	/**
	 * this method using to check if the application exist or not
	 * @param appId
	 * @return
	 * @throws HisException
	 */
	public boolean appExist(String appId)throws HisException;
	/**
	 * this method using to get family details base on case number
	 * @param caseNumber
	 * @return
	 * @throws HisException
	 */
	public HisFamilyDtls getFamilyByCase(Integer caseNumber)throws HisException;
	/**
	 * this method using to get job details base on case Number 
	 * @param caseNumber
	 * @return
	 * @throws HisException
	 */
	public HisJobDtls getJobByCaseNumber(Integer caseNumber)throws HisException;
	/**
	 * this method using to get crime details base on case Number
	 * @param caseBumber
	 * @return
	 * @throws HisException
	 */
	public HisCrimeDtls getCrimeDtls(Integer caseBumber)throws HisException;

	public void deleteKids(Integer kidsId)throws HisException;

	public HisKidsDtls getKidById(Integer KidId)throws HisException;
	
	public List<HisCaseDtls> getAllCases();
	public boolean deleteCase(Integer CaseNumber)throws HisException;
	
}
