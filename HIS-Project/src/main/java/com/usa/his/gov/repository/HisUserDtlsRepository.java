package com.usa.his.gov.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.entity.HisUserDtlsEntity;
/**
 * this repository use to perform database operation for user details data
 * @author hosam7asko
 *
 */
@Repository
public interface HisUserDtlsRepository extends JpaRepository<HisUserDtlsEntity, Integer> {
	/**
	 * this method use to get User based on public id
	 * @param publicId
	 * @return
	 */
	public HisUserDtlsEntity findByPublicId(String publicId);
	/**
	 * switch the inactive user to active
	 * @param publicId
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("update HisUserDtlsEntity his set his.activeSwitch='Y' where his.publicId=:publicId")
	public Integer updateSwActiveToActive(String publicId);
	/**
	 * switch the active user to inactive
	 * @param publicId
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("update HisUserDtlsEntity his set his.activeSwitch='N' where his.publicId=:publicId")
	public Integer updateSwActiveToInactive(String publicId);
	
	


}
