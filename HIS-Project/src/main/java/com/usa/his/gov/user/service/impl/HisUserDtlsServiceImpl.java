package com.usa.his.gov.user.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.usa.his.gov.constant.HisConstant;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.generate.HisGenerate;
import com.usa.his.gov.share.HisConverter;
import com.usa.his.gov.share.SendEmail;
import com.usa.his.gov.user.entity.HisUserDtlsEntity;
import com.usa.his.gov.user.model.HisUserDtls;
import com.usa.his.gov.user.repository.HisUserDtlsRepository;
import com.usa.his.gov.user.service.HisUserDtlsService;

/**
 * this is class using to executing the His Users Logic
 * 
 * @author hosam7asko
 *
 */

@Service
public class HisUserDtlsServiceImpl implements HisUserDtlsService {

	/**
	 * Enable logging for the class
	 */
	
	private Logger log = LoggerFactory.getLogger(HisUserDtlsServiceImpl.class);
	/**
	 * inject repository object to performing database operation side
	 */
	
	@Autowired
	private HisUserDtlsRepository dtlsRepository;
	
	/**
	 * inject Generate class object to generate values 
	 */
	
	@Autowired
	private HisGenerate hisGeneraate;
	@Autowired
	
	/**
	 * inject Converter class object to convert objects  
	 */
	
	private HisConverter converter;
	@Autowired
	/**
	 * inject SendEmail class object to send an email to user 
	 */
	private SendEmail send;

	/**
	 * this method using to save new user data to database
	 */
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public HisUserDtls newHisUser(HisUserDtls userDtls) throws HisException {
		log.info("HisUserDtlsServiceImpl newHisUser() method start");
		HisUserDtlsEntity hisUserDtlsEntity = new HisUserDtlsEntity();
		String publicId = hisGeneraate.generateValues(10);
		userDtls.setPublicId(publicId);
		String generatePassword = hisGeneraate.generateValues(30);
		userDtls.setPassword(generatePassword);
		userDtls.setActiveSwitch(HisConstant.ACTIVE_STATUS);
		userDtls.setStatus(false);
		BeanUtils.copyProperties(userDtls, hisUserDtlsEntity);
		log.info("newHisUser() method send email block start");
		boolean flag = send.sendTempPasswordToEmail(userDtls);
		if (flag) {
			log.info("newHisUser() method send email block end");
			HisUserDtlsEntity saveEntity = dtlsRepository.save(hisUserDtlsEntity);
			log.info("newHisUser() method save block start");
			if (saveEntity != null) {

				BeanUtils.copyProperties(saveEntity, userDtls);
				log.info("newHisUser() method save block end sucess");
				log.info("HisUserDtlsServiceImpl newHisUser() method end");
				return userDtls;

			} else {
				
				throw new HisException("error data not added plase try agane leater");
			}

		} else {
			throw new HisException("error when send email");
		}

	}

	/**
	 * this method using to retrieve all users data from database
	 */
	
	@Override
	public List<HisUserDtls> getAllUsers() throws HisException {
		log.info("HisUserDtlsServiceImpl getAllUsers() method start");
		List<HisUserDtlsEntity> dtlsEntities = dtlsRepository.findAll();
		List<HisUserDtls> usersDtls = converter.ConverHisDtlsEntityToHisUserDtls(dtlsEntities);
		log.info("HisUserDtlsServiceImpl getAllUsers() method end");
		return usersDtls;
	}

	/**
	 * this method using to retrieve user info base on email 
	 */
	
	@Override
	public HisUserDtls getUserByEmail(String email) throws HisException {
		System.out.println("email"+email);
		log.info("HisUserDtlsServiceImpl getUserByEmail() method start :"+email);
		HisUserDtlsEntity entity = dtlsRepository.findByEmail(email);
		if (entity != null) {
			HisUserDtls userDtls = new HisUserDtls();
			BeanUtils.copyProperties(entity, userDtls);
			System.out.println("User Details"+userDtls.toString());
			log.info("HisUserDtlsServiceImpl getUserByEmail() method end");
			return userDtls;
		}
		log.info("HisUserDtlsServiceImpl getUserByEmail() method exception");
		return null;
	}

	@Override
	public HisUserDtls getUserByEmailAndPassword(String email, String password) throws HisException {
		log.info("HisUserDtlsServiceImpl getUserByEmailAndPassword() method start");
		HisUserDtlsEntity userDtlsEntity = dtlsRepository.findByEmailAndPassword(email, password);
		if (userDtlsEntity != null) {
			HisUserDtls userDtls = new HisUserDtls();
			BeanUtils.copyProperties(userDtlsEntity, userDtls);
			System.out.println(userDtls.toString());
			log.info("HisUserDtlsServiceImpl getUserByEmailAndPassword() method end success");
			return userDtls;

		}
		log.info("HisUserDtlsServiceImpl getUserByEmailAndPassword() method end exception");
		return null;
	}
	/**
	 * get Unlock users
	 */
	@Override
	public List<HisUserDtls> getAllUsersByStatus(Boolean status) throws HisException {
		log.info("HisUserDtlsServiceImpl getAllUsersByStatus() method start");
		List<HisUserDtlsEntity> dtlsList = dtlsRepository.findByStatus(true);
		List<HisUserDtls> userDtlsList = converter.ConverHisDtlsEntityToHisUserDtls(dtlsList);
		log.info("HisUserDtlsServiceImpl getAllUsersByStatus() method end");
		return userDtlsList;
	}

	/**
	 * this method using to update the user
	 */
	@Override
	public HisUserDtls updateUser(HisUserDtls hisUserDtls) throws HisException {
		log.info("HisUserDtlsServiceImpl updateUser() method start");
		HisUserDtlsEntity userDtlsEntity = new HisUserDtlsEntity();
		HisUserDtlsEntity getEntity = dtlsRepository.findByPublicId(hisUserDtls.getPublicId());
		BeanUtils.copyProperties(hisUserDtls, userDtlsEntity);
		userDtlsEntity.setUserId(getEntity.getUserId());
		userDtlsEntity.setActiveSwitch(getEntity.getActiveSwitch());
		userDtlsEntity.setPassword(getEntity.getPassword());
		userDtlsEntity.setStatus(getEntity.getStatus());
		HisUserDtlsEntity savedValue = dtlsRepository.save(userDtlsEntity);
		if (savedValue != null) {
			log.info("HisUserDtlsServiceImpl updateUser() method start");

			BeanUtils.copyProperties(savedValue, hisUserDtls);
			return hisUserDtls;
		} else {
			log.info("HisUserDtlsServiceImpl updateUser() method end exception");
			throw new HisException("unable to update user");
		}

	}

	@Override
	public boolean updateRole(String pId) throws HisException {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * soft delete user this method user to update the swActive
	 */
	@Override
	public boolean softDelete(String pId) throws HisException {
		log.info("HisUserDtlsServiceImpl softDelete() method start");
		Integer flag = dtlsRepository.updateSwActiveToInactive(pId);
		if (flag == 1) {
			log.info("HisUserDtlsServiceImpl softDelete() method end");
			return true;
		}
		return false;
	}

	/**
	 * update user password after complete register and set the password
	 */
	@Override
	public HisUserDtls updetePassword(String email, String password) throws HisException {
		log.info("HisUserDtlsServiceImpl updetePassword() method start");
		Boolean status = true;
		String pass=bCryptPasswordEncoder.encode(password);
		Integer flag = dtlsRepository.updatePasswordAndStatus(pass, status, email);
		if (flag == 1) {
			HisUserDtls userDtls = getUserByEmail(email);
			log.info("HisUserDtlsServiceImpl updetePassword() method end");
			return userDtls;
		}else {
			log.info("HisUserDtlsServiceImpl updetePassword() method end exception"+flag);
		throw new HisException("error in update password");
		}
	}

	/**
	 * this method using to retrieve the user baser on the public id and return user details
	 */
	@Override
	public HisUserDtls getUserByPublicId(String pId) throws HisException {
		log.info("HisUserDtlsServiceImpl getUserByPublicId() method start");
		HisUserDtls returnValue = new HisUserDtls();
		HisUserDtlsEntity userDtlsEntity = dtlsRepository.findByPublicId(pId);
		if (userDtlsEntity != null) {
			BeanUtils.copyProperties(userDtlsEntity, returnValue);
			log.info("HisUserDtlsServiceImpl getUserByPublicId() method end");
			return returnValue;

		} else {
			log.info("HisUserDtlsServiceImpl getUserByPublicId() method end exception");
			throw new HisException("No User With the given id :" + pId);
		}
	}

	/**
	 * this method use to make Inactive user Active based on public id 
	 */
	@Override
	public boolean reActiveUser(String pId) throws HisException {
		log.info("HisUserDtlsServiceImpl reActiveUser() method start");
		Integer flag = dtlsRepository.updateSwActiveToActive(pId);
		if (flag != null) {
			log.info("HisUserDtlsServiceImpl reActiveUser() method start");
			return true;
		}
		log.info("HisUserDtlsServiceImpl reActiveUser() method end exception");
		return false;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("HisUserDtlsServiceImpl updetePassword() method start");
		HisUserDtlsEntity userDtlsEntity = dtlsRepository.findByEmail(username);
		if (userDtlsEntity==null) {
			System.out.println("null");
			 throw new UsernameNotFoundException(username);
		}
		
		String s=userDtlsEntity.getPassword();
		UserBuilder builder=User.withUsername(userDtlsEntity.getEmail()).password(s)
				.roles(userDtlsEntity.getRoleType());
		return builder.build();
		
		/*return new User(username,
				userDtlsEntity.getPassword(), 
				userDtlsEntity.getStatus(),
				true,
				true,
				true, 
				new ArrayList<>());
				*/
	}

}
