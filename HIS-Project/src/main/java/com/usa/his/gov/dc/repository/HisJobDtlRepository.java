package com.usa.his.gov.dc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.dc.entity.HisJobDtlsEntity;
@Repository
public interface HisJobDtlRepository extends JpaRepository<HisJobDtlsEntity, Integer> {
	

}
