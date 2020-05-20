package com.usa.his.gov.user.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.user.entity.HisUserDtlsEntity;

/**
 * this repository use to perform database operation for user details data
 * 
 * @author hosam7asko
 *
 */
@Repository
public interface HisUserDtlsRepository extends JpaRepository<HisUserDtlsEntity, Integer> {
	/**
	 * this method use to get User based on public id
	 * 
	 * @param publicId
	 * @return
	 */
	public HisUserDtlsEntity findByPublicId(String publicId);

	/**
	 * get User by email
	 * 
	 * @param email
	 * @return
	 */
	public HisUserDtlsEntity findByEmail(String email);

	/**
	 * switch the inactive user to active
	 * 
	 * @param publicId
	 * @return
	 */

	public HisUserDtlsEntity findByEmailAndPassword(String email,String password);
	@Transactional
	@Modifying
	@Query("update HisUserDtlsEntity his set his.activeSwitch='Y' where his.publicId=:publicId")
	public Integer updateSwActiveToActive(String publicId);

	/**
	 * switch the active user to inactive
	 * 
	 * @param publicId
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("update HisUserDtlsEntity his set his.activeSwitch='N' where his.publicId=:publicId")
	public Integer updateSwActiveToInactive(String publicId);

	/**
	 * update password and status after user complete register
	 * 
	 * @param password
	 * @param status
	 * @param email
	 * @return
	 */
	@Transactional
	@Modifying
	@Query("update HisUserDtlsEntity his set his.password=:password, his.status=:status where his.email=:email")
	public Integer updatePasswordAndStatus(String password, Boolean status, String email);
	/**
	 * get all users by status either lock(true) or unlock(false)
	 * @param status
	 * @return
	 */
	public List<HisUserDtlsEntity> findByStatus(Boolean status);

}
