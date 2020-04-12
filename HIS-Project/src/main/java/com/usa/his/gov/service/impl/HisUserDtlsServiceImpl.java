package com.usa.his.gov.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.his.gov.constant.HisServiceConstant;
import com.usa.his.gov.entity.HisUserDtlsEntity;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.generate.HisGenerate;
import com.usa.his.gov.model.HisUserDtls;
import com.usa.his.gov.repository.HisUserDtlsRepository;
import com.usa.his.gov.service.HisUserDtlsService;
import com.usa.his.gov.share.HisConverter;

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
	@Autowired
	HisConverter converter;

	@Override
	public HisUserDtls newHisUser(HisUserDtls userDtls) throws HisException {
		HisUserDtlsEntity hisUserDtlsEntity = new HisUserDtlsEntity();
		String publicId = hisGeneraate.generateValues(10);
		userDtls.setPublicId(publicId);
		String generatePassword = hisGeneraate.generateValues(30);
		userDtls.setPassword(generatePassword);
		userDtls.setActiveSwitch(HisServiceConstant.ACTIVE_STATUS);
		userDtls.setStatus(true);
		BeanUtils.copyProperties(userDtls, hisUserDtlsEntity);
		HisUserDtlsEntity saveEntity = dtlsRepository.save(hisUserDtlsEntity);
		if (saveEntity != null) {
			BeanUtils.copyProperties(saveEntity, userDtls);
			return userDtls;
		} else {
			throw new HisException("error data not added plase try agane leater");
		}

	}

	@Override
	public List<HisUserDtls> getAllUsers() throws HisException {
		List<HisUserDtlsEntity> dtlsEntities = dtlsRepository.findAll();
		List<HisUserDtls> usersDtls = converter.ConverHisDtlsEntityToHisUserDtls(dtlsEntities);
		return usersDtls;
	}

	@Override
	public HisUserDtls getUserByEmail(String email) throws HisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HisUserDtls getUserByEmailAndPassword(String email, String password) throws HisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HisUserDtls> getAllUsersByStatus(String status) throws HisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HisUserDtls updateUser(String pId) throws HisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRole(String pId) throws HisException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean softDelete(String pId) throws HisException {
		Integer flag = dtlsRepository.updateSwActiveToInactive(pId);
		if (flag==1) {
			return true;
		}
		return false;
	}

	@Override
	public HisUserDtls updetePassword(String email, String password) throws HisException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HisUserDtls getUserByPublicId(String pId) throws HisException {
		HisUserDtls returnValue = new HisUserDtls();
		HisUserDtlsEntity userDtlsEntity = dtlsRepository.findByPublicId(pId);
		if (userDtlsEntity!=null) {
			BeanUtils.copyProperties(userDtlsEntity, returnValue);
			return returnValue;
			
		}else {
			throw new HisException("No User With the given id :"+pId);
		}
	}

	@Override
	public boolean reActiveUser(String pId) throws HisException {
		Integer flag = dtlsRepository.updateSwActiveToActive(pId);
		if (flag!=null) {
			return true;
		}
		return false;
	}

}
