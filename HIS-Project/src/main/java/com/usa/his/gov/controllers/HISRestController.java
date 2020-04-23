package com.usa.his.gov.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.HisAppRegister;
import com.usa.his.gov.model.HisUserDtls;
import com.usa.his.gov.model.response.SSNClientResponse;
import com.usa.his.gov.service.HisAppRegisterService;
import com.usa.his.gov.service.HisUserDtlsService;
import com.usa.his.gov.service.SSNRestClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * this class use as rest controller to connect with ajax 
 * @author hosam7asko
 *
 */
@Api(value = "HisRestController" ,description = "REST Api related to his project for ajax")
@RestController
@RequestMapping("/RestApi")
public class HISRestController {

	/**
	 * Enable Logging 
	 */
	Logger log=LoggerFactory.getLogger(HISRestController.class);
	
	/**
	 * inject User Service to performing  the business logic 
	 */
	@Autowired
	private HisUserDtlsService dtlsService;
	/**
	 * this method using to check email  when user try to complete registering
	 * @param email
	 * @return
	 * @throws HisException
	 */
	/**
	 * inject SSN Service to check ssn number  
	 */
	@Autowired
	private SSNRestClientService ssnClient;
	/**
	 * this method using to validation email address and return result eithe exist or not
	 * @param email
	 * @return
	 * @throws HisException
	 */
	@Autowired
	private HisAppRegisterService appService;
	@ApiOperation(
			value = "Validation email",
			response = String.class,
			tags = "RestApi/emailValidation",
			consumes = "Text",
			produces = "application/json"
			)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Sucecss|OK"),
			@ApiResponse(code = 401,message = "not authorized!"),
			@ApiResponse(code = 403,message = "forbidden!!!"),
			@ApiResponse(code = 404,message = "not found!!!"),
			
	})
	@GetMapping(value = "/emailValidation",produces = "application/json")
	public String verifyEmail(@RequestParam("email") String email) throws HisException {
		log.info("HisAdminController verifyEmail() method execution start");
		HisUserDtls userDtls = dtlsService.getUserByEmail(email);
		if (userDtls != null) {
			log.info("HisAdminController verifyEmail() method execution end email is exist");
			return "EXIST";
		} else {
			log.info("HisAdminController verifyEmail() method execution end email not exist");
			return "NOT_EXIST";
		}

	}
	/**
	 * this method using to check email and when user try to complete registering
	 * @param email
	 * @return
	 * @throws HisException
	 */
	@ApiOperation(
			value = "Validation email and password",
			response = String.class,
			tags = "RestApi/emailAndPasswordValidation",
			consumes = "Text",
			produces = "application/json"
			)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Sucecss|OK"),
			@ApiResponse(code = 401,message = "not authorized!"),
			@ApiResponse(code = 403,message = "forbidden!!!"),
			@ApiResponse(code = 404,message = "not found!!!"),
			
	})
	@GetMapping(value = "/emailAndPasswordValidation",produces = "application/json")
	public String verifyEmailAndPasseord(@RequestParam("password") String password,@RequestParam("email")String email) throws HisException {
		log.info("HisAdminController verifyEmailAndPassword() method execution start");
		HisUserDtls userDtls = dtlsService.getUserByEmailAndPassword(email, password);
		if (userDtls!=null) {
			log.info("HisAdminController verifyEmail() method execution end is valid");
			return "VALID";
		}
		log.info("HisAdminController verifyEmail() method execution end invalid");
		return "INVALID";
	}
	@ApiOperation(
			value = "Verify SSN",
			response = SSNClientResponse.class,
			tags = "RestApi/SSNVerify",
			consumes = "Text",
			produces = "application/json"
			)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Sucecss|OK"),
			@ApiResponse(code = 401,message = "not authorized!"),
			@ApiResponse(code = 403,message = "forbidden!!!"),
			@ApiResponse(code = 404,message = "not found!!!"),
			
	})
	@GetMapping("/SSNVerify")
	public @ResponseBody SSNClientResponse getSSN(@RequestParam("ssn") String ssn) throws HisException {
		log.info("HisAdminController getSSN() method start"+ssn);
		SSNClientResponse returnValue=ssnClient.vaildationSSN(ssn);
		log.info("HisAdminController getSSN() method start"+ssn);
		return  returnValue;
	}
	@ApiOperation(
			value = "Get Application",
			response = HisAppRegister.class,
			tags = "Rest/getApplication",
			consumes = "Text",
			produces = "application/json"
			)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Sucecss|OK"),
			@ApiResponse(code = 401,message = "not authorized!"),
			@ApiResponse(code = 403,message = "forbidden!!!"),
			@ApiResponse(code = 404,message = "not found!!!"),
			
	})
	@GetMapping(path = "/getApplication",produces = {"application/json","application/xml"})
	public HisAppRegister getApplicationById(@RequestParam("appId") String appId) throws HisException {
		log.info("HisAdminController getApplicationById() method starting");
		HisAppRegister returnValue = appService.getApplicationById(appId);
		if (returnValue!=null) {
			log.info("HisAdminController getApplicationById() method end");
			return returnValue;
		}else {
			log.info("HisAdminController getApplicationById() method end not found");
			return null;
		}
	}

}
