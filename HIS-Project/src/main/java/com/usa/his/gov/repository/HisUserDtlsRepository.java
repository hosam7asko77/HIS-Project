package com.usa.his.gov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usa.his.gov.entity.HisUserDtlsEntity;
/**
 * this repository use to perform database operation for user details data
 * @author hosam7asko
 *
 */
@Repository
public interface HisUserDtlsRepository extends JpaRepository<HisUserDtlsEntity, Integer> {


}
