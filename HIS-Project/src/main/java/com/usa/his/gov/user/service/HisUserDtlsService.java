package com.usa.his.gov.user.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.user.model.HisUserDtls;

public interface HisUserDtlsService extends UserDetailsService{

	/**
	 * 
	 * @param userDtls
	 * @return
	 * @throws HisException
	 */
	public HisUserDtls newHisUser(HisUserDtls userDtls) throws HisException;

	/**
	 * 
	 * @return boolean
	 * @throws HisException
	 */
	public List<HisUserDtls> getAllUsers() throws HisException;

	/**
	 * 
	 * @param email
	 * @return HisUserDtls
	 * @throws HisException
	 */
	public HisUserDtls getUserByEmail(String email) throws HisException;

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws HisException
	 */
	public HisUserDtls getUserByEmailAndPassword(String email, String password) throws HisException;

	/**
	 * 
	 * @return
	 * @throws HisException
	 */
	public List<HisUserDtls> getAllUsersByStatus(Boolean status) throws HisException;

	/**
	 * 
	 * @param pId stand for publicId it is generated value that use as id
	 * 
	 * @return
	 * @throws HisException
	 */
	public HisUserDtls updateUser(HisUserDtls hisUserDtls) throws HisException;

	/**
	 * 
	 * @param pId pId stand for publicId it is generated value that use as id
	 * @return
	 * @throws HisException
	 */
	public boolean updateRole(String pId) throws HisException;

	/**
	 * this method use to make the user Inactive
	 * @param pId
	 * @return
	 * @throws HisException
	 */
	public boolean softDelete(String pId) throws HisException;

	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws HisException
	 */
	public HisUserDtls updetePassword(String email, String password) throws HisException;

	/**
	 * get user details
	 * 
	 * @param pid
	 * @return
	 * @throws HisException
	 */
	public HisUserDtls getUserByPublicId(String pid) throws HisException;
	/**
	 * this method use make user active
	 * @param pId
	 * @return
	 * @throws HisException
	 */
	public boolean reActiveUser(String pId)throws HisException;

}
