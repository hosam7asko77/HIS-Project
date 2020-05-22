package com.usa.his.gov.elg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usa.his.gov.elg.entity.ElgDetailsEntity;

public interface ElgDetailsRepository extends JpaRepository<ElgDetailsEntity, Integer> {
	 List<ElgDetailsEntity> findByCaseNumber(Integer caseNumber);
	 
	

}
