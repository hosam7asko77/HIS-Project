package com.usa.his.gov.dc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.dc.entity.HisCaseDtlsEntity;
import com.usa.his.gov.dc.entity.HisKidsDtlsEntity;

@Repository
public interface HisKidsDtlsRepository extends JpaRepository<HisKidsDtlsEntity, Integer> {
	public List<HisKidsDtlsEntity> findByCaseDtlsEntity(HisCaseDtlsEntity caseDtlsEntity);

}
