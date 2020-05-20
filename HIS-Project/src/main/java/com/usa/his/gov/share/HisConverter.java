package com.usa.his.gov.share;

import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.usa.his.gov.appregister.entity.HisAppRegisterEntity;
import com.usa.his.gov.appregister.model.HisAppRegister;
import com.usa.his.gov.dc.entity.HisKidsDtlsEntity;
import com.usa.his.gov.dc.model.HisKidsDtls;
import com.usa.his.gov.plan.entity.HisPlanEntity;
import com.usa.his.gov.plan.model.HisPlan;
import com.usa.his.gov.user.entity.HisUserDtlsEntity;
import com.usa.his.gov.user.model.HisUserDtls;

/**
 * this class to convert model to entity
 * 
 * @author hosam7asko
 *
 */
@Component
public class HisConverter {

	/**
	 * this method use to convert (HisUserDtlsEntity To HisUserDtls)
	 * 
	 * @param dtlsEntities
	 * @return
	 */
	public List<HisUserDtls> ConverHisDtlsEntityToHisUserDtls(List<HisUserDtlsEntity> dtlsEntities) {
		List<HisUserDtls> returnValue = new ArrayList<>();
		for (HisUserDtlsEntity dtlsEntity : dtlsEntities) {
			HisUserDtls dtoModel = new HisUserDtls();
			BeanUtils.copyProperties(dtlsEntity, dtoModel);
			returnValue.add(dtoModel);

		}
		return returnValue;

	}

	/**
	 * this method use to convert (HisPlanEntity To HisPlan)
	 * 
	 * @param planEntities
	 * @return
	 */
	public List<HisPlan> convertHisPlanEntityToHisPlan(List<HisPlanEntity> planEntities) {
		List<HisPlan> returnValue = new ArrayList<>();
		for (HisPlanEntity planEntity : planEntities) {
			HisPlan dtoModel = new HisPlan();
			BeanUtils.copyProperties(planEntity, dtoModel);
			returnValue.add(dtoModel);
		}
		return returnValue;
	}
	/**
	 * this method use to convert (HisAppRegisterEntity To HisAppRegister) 
	 * @param appEntities
	 * @return
	 */
	public List<HisAppRegister> convertHisAppRegisterEntityToHisAppRegister(List<HisAppRegisterEntity> appEntities) {
		List<HisAppRegister> returnValue = new ArrayList<>();
		for (HisAppRegisterEntity planEntity : appEntities) {
			HisAppRegister dtoModel = new HisAppRegister();
			BeanUtils.copyProperties(planEntity, dtoModel);
			returnValue.add(dtoModel);
		}
		return returnValue;
	}
	/**
	 * this method use to convert (HisKidsDtlsEntity HisKidsDtls)
	 * @param kidsEntites
	 * @return
	 */
	public List<HisKidsDtls> convertHisKidsDtlsEntityToHisKidsDtls(List<HisKidsDtlsEntity> kidsEntites) {
		List<HisKidsDtls> returnValue = new ArrayList<>();
		for (HisKidsDtlsEntity kidsEntity : kidsEntites) {
			HisKidsDtls dtoModel = new HisKidsDtls();
			BeanUtils.copyProperties(kidsEntity, dtoModel);
			returnValue.add(dtoModel);
		}
		return returnValue;
	}
	/**
	 * this method using to convert multiPart to byte 
	 * @param file
	 * @return
	 */
	public byte[] converMultiPartTByte(MultipartFile file) {
		byte [] reportFile=null;
		try {
		reportFile=file.getBytes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return reportFile;
		
	}

}
