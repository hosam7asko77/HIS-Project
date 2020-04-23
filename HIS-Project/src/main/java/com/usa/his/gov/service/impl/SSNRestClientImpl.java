package com.usa.his.gov.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.usa.his.gov.controllers.HisAdminController;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.response.SSNClientResponse;
import com.usa.his.gov.service.SSNRestClientService;
/**
 * this class implement SSNRestClien Service using to send SSN to SSNAPI for Validation
 * @author hosam7asko
 *
 */
@Service
public class SSNRestClientImpl implements SSNRestClientService {
	
	/**
	 * Enable logging for the class
	 */

	private static final Logger log = LoggerFactory.getLogger(HisAdminController.class);
	
	/**
	 * inject Rest Template create class object
	 */
	@Autowired
	private RestTemplate restTemplate;
	private static final String SSN_RESTAPI_GET_BY_SSN_URL = "http://localhost:5050/verifySSN?ssn=";
	@Override
	public SSNClientResponse vaildationSSN(String SSN) throws HisException {
		log.info("SSNRestClientImpl vaildationSSN() method start");
		ResponseEntity<SSNClientResponse> responseEntity=restTemplate.getForEntity(SSN_RESTAPI_GET_BY_SSN_URL+SSN, SSNClientResponse.class);
		int statusCode=responseEntity.getStatusCode().value();
		if (statusCode==200) {
			 SSNClientResponse getResponseBody = responseEntity.getBody();
			log.info("SSNRestClientImpl vaildationSSN() method end");
			return getResponseBody;
		}else {
			log.info("SSNRestClientImpl vaildationSSN() method with exception");
			throw new HisException();
		}
		
	}

}
