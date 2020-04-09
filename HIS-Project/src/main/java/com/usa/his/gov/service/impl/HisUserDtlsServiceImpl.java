package com.usa.his.gov.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.his.gov.constant.HisServiceConstant;
import com.usa.his.gov.entity.HisUserDtlsEntity;
import com.usa.his.gov.exception.HisUserDtlsException;
import com.usa.his.gov.generate.HisGenerate;
import com.usa.his.gov.model.HisUserDtls;
import com.usa.his.gov.repository.HisUserDtlsRepository;
import com.usa.his.gov.service.HisUserDtlsService;

/**
 * this is class using to executing the His Users Logic
 * 
 * @author hosam7asko
 *
 */

@Service
public class HisUserDtlsServiceImpl implements HisUserDtlsService {

	@Autowired
	HisUserDtlsRepository dtlsRepository;
	@Autowired
	HisGenerate hisGeneraate;

	@Override
	public HisUserDtls newHisUser(HisUserDtls userDtls) throws HisUserDtlsException {
		HisUserDtlsEntity hisUserDtlsEntity = new HisUserDtlsEntity();
		String publicId = hisGeneraate.generateValues(10);
		userDtls.setPublicId(publicId);
		String generatePassword = hisGeneraate.generateValues(30);
		userDtls.setPassword(generatePassword);
		userDtls.setActiveSwitch(HisServiceConstant.STATUS);
		BeanUtils.copyProperties(userDtls, hisUserDtlsEntity);
		HisUserDtlsEntity saveEntity = dtlsRepository.save(hisUserDtlsEntity);
		if (saveEntity != null) {
			BeanUtils.copyProperties(saveEntity, userDtls);
			return userDtls;
		} else {
			throw new HisUserDtlsException("error data not added plase try agane leater");
		}

	}

	@Override
	public List<HisUserDtls> getAllUsers() throws HisUserDtlsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HisUserDtls getUserByEmail(String email) throws HisUserDtlsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HisUserDtls getUserByEmailAndPassword(String email, String password) throws HisUserDtlsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HisUserDtls> getAllUsersByStatus(String status) throws HisUserDtlsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HisUserDtls updateUser(String pId) throws HisUserDtlsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRole(String pId) throws HisUserDtlsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean softDelete(String pId) throws HisUserDtlsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HisUserDtls updetePassword(String email, String password) throws HisUserDtlsException {
		// TODO Auto-generated method stub
		return null;
	}

}
