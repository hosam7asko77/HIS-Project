package com.usa.his.gov.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.his.gov.appregister.entity.HisAppRegisterEntity;
import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;

public interface HisCaseDtlsRepository extends JpaRepository<HisCaseDtlsEntity, Integer> {
	public HisCaseDtlsEntity  findByAppRegister(HisAppRegisterEntity appRegister);
	

}
