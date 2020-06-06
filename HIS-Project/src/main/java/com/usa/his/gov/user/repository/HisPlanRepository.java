package com.usa.his.gov.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.user.entity.HisPlanEntity;
/**
 * this repository use to perform database operation for plans details data
 * @author hosam7asko
 *
 */
@Repository
public interface HisPlanRepository extends JpaRepository<HisPlanEntity, String> {
	HisPlanEntity findByPlanName(String planName);
	

}
