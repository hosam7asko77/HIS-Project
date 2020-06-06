package com.usa.his.gov.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.user.entity.BatchRunDetailsEntity;


@Repository
public interface BatchRunRepository extends CrudRepository<BatchRunDetailsEntity, Integer> {

}
