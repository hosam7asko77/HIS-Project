package com.usa.his.gov.service;

import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.SSNClientResponse;

public interface SSNRestClientService {
	/**
	 * this 
	 * @param SSN
	 * @return
	 * @throws HisException
	 */
	public SSNClientResponse vaildationSSN(String SSN)throws HisException;
	/**
	 * this 
	 * @param SSN
	 * @return
	 * @throws HisException
	 */
	public SSNClientResponse runBatch()throws HisException;

}
