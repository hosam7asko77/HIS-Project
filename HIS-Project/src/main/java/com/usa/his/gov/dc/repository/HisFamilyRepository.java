package com.usa.his.gov.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.dc.entity.HisFamilyDtlsEntity;
@Repository
public interface HisFamilyRepository extends JpaRepository<HisFamilyDtlsEntity, Integer> {
	
}
