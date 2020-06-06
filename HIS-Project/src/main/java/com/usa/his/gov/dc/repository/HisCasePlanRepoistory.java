package com.usa.his.gov.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.dc.entity.HisCasePlanEntity;

public interface HisCasePlanRepoistory extends JpaRepository<HisCasePlanEntity, Integer> {
	

}
