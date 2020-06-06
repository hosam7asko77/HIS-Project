package com.usa.his.gov.elg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usa.his.gov.elg.entity.ElgDetailsEntity;

public interface ElgDetailsRepository extends JpaRepository<ElgDetailsEntity, Integer> {
	 public List<ElgDetailsEntity> findByCaseNumber(Integer caseNumber);
	 @Query("select count(e) from ElgDetailsEntity e where planStatus=:planStatus")
	 public long countByPlanStatus(String planStatus);
	 
	

}
