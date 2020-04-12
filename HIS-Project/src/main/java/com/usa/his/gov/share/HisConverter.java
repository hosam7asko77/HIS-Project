package com.usa.his.gov.share;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.usa.his.gov.entity.HisUserDtlsEntity;
import com.usa.his.gov.model.HisUserDtls;


/**
 * this class to convert model to entity
 * @author hosam7asko
 *
 */
@Component
public class HisConverter {

/**
 * this method use to convert (HisUserDtlsEntity To HisUserDtls)
 * @param dtlsEntities
 * @return
 */
	public List<HisUserDtls> ConverHisDtlsEntityToHisUserDtls(List<HisUserDtlsEntity> dtlsEntities){
		List<HisUserDtls> returnValue=new ArrayList<>();
		for (HisUserDtlsEntity  dtlsEntity: dtlsEntities) {
			HisUserDtls dtoModel=new HisUserDtls();
			BeanUtils.copyProperties(dtlsEntity, dtoModel);
			returnValue.add(dtoModel);
			
		}
		return returnValue;

	}
}
