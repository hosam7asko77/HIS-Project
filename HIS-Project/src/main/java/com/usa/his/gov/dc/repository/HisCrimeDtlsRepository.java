package com.usa.his.gov.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.dc.entity.HisCrimeDtlsEntity;

public interface HisCrimeDtlsRepository extends JpaRepository<HisCrimeDtlsEntity, Integer> {
	
}
