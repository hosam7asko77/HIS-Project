package com.usa.his.gov.service;

import java.util.List;

import com.usa.his.gov.exception.HisUserDtlsException;
import com.usa.his.gov.model.HisUserDtls;

public interface HisUserDtlsService {

	/**
	 * 
	 * @param userDtls
	 * @return
	 * @throws HisUserDtlsException
	 */
	public HisUserDtls newHisUser(HisUserDtls userDtls) throws HisUserDtlsException;

	/**
	 * 
	 * @return boolean
	 * @throws HisUserDtlsException
	 */
	public List<HisUserDtls> getAllUsers() throws HisUserDtlsException;

	/**
	 * 
	 * @param email
	 * @return HisUserDtls
	 * @throws HisUserDtlsException
	 */
	public HisUserDtls getUserByEmail(String email) throws HisUserDtlsException;

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws HisUserDtlsException
	 */
	public HisUserDtls getUserByEmailAndPassword(String email, String password) throws HisUserDtlsException;

	/**
	 * 
	 * @param status
	 * @return
	 * @throws HisUserDtlsException
	 */
	public List<HisUserDtls> getAllUsersByStatus(String status) throws HisUserDtlsException;

	/**
	 * 
	 * @param pId stand for publicId it is generated value that use as id
	 * 
	 * @return
	 * @throws HisUserDtlsException
	 */
	public HisUserDtls updateUser(String pId) throws HisUserDtlsException;

	/**
	 * 
	 * @param pId pId stand for publicId it is generated value that use as id
	 * @return
	 * @throws HisUserDtlsException
	 */
	public boolean updateRole(String pId) throws HisUserDtlsException;

	/**
	 * 
	 * @param pId
	 * @return
	 * @throws HisUserDtlsException
	 */
	public boolean softDelete(String pId) throws HisUserDtlsException;

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws HisUserDtlsException
	 */
	public HisUserDtls updetePassword(String email, String password) throws HisUserDtlsException;

}
