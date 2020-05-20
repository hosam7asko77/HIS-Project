package com.usa.his.gov.appregister.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.appregister.entity.HisAppRegisterEntity;
@Repository
public interface HisAppRegisterReepository extends JpaRepository<HisAppRegisterEntity, String> {

	@Transactional
	@Modifying
	@Query("update HisAppRegisterEntity his set his.deleteStatus=:deleteStatus where his.appId=:appId")
	Integer updateStatus(boolean deleteStatus, String appId);

}
