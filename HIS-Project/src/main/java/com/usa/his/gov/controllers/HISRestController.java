package com.usa.his.gov.controllers;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usa.his.gov.appregister.model.HisAppRegister;
import com.usa.his.gov.appregister.service.HisAppRegisterService;
import com.usa.his.gov.dc.service.HisCaseDtlservice;
import com.usa.his.gov.elg.service.EDRuleRestClientService;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.response.HisMessageResponcetModel;
import com.usa.his.gov.model.response.SSNClientResponse;
import com.usa.his.gov.plan.model.HisPlan;
import com.usa.his.gov.plan.service.HisPlanService;
import com.usa.his.gov.service.SSNRestClientService;
import com.usa.his.gov.user.model.HisUserDtls;
import com.usa.his.gov.user.service.HisUserDtlsService;

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
	 * inject SSN Service to check ssn number  
	 */
	@Autowired
	private SSNRestClientService ssnClient;
	/**
	 * inject  HisAppRegisterService 
	 */
	@Autowired
	private HisAppRegisterService appService;
	
	/**
	 * inject  HisAppRegisterService 
	 */
	@Autowired
	private HisPlanService planService;
	/**
	 * inject HisCaseDtlservice create an object
	 */
	@Autowired
	private HisCaseDtlservice caseService;
	/**
	 * this method using to validation email address and return result eithe exist or not
	 * @param email
	 * @return
	 * @throws HisException
	 */
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
			tags = "RestApi/getApplication",
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
	/**
	 * this method using to retrieve all plan from
	 * @return
	 * @throws HisException
	 */
	@ApiOperation(
			value = "Get Plans",
			response = HisAppRegister.class,
			tags = "RestApi/getPlans",
			consumes = "Text",
			produces = "application/json"
			)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Sucecss|OK"),
			@ApiResponse(code = 401,message = "not authorized!"),
			@ApiResponse(code = 403,message = "forbidden!!!"),
			@ApiResponse(code = 404,message = "not found!!!"),
			
	})
	@GetMapping(path = "/getPlans" ,produces = {"application/json","application/xml"})
	public HashMap<String, String> getPlans() throws HisException{
		HashMap<String, String> plans=new HashMap<String, String>(); 
		log.info("HisAdminController getPlans() method starting");
		List<HisPlan> returnValue = planService.getAllPlans();
		for (HisPlan hisPlan : returnValue) {
			plans.put(hisPlan.getPlanId(), hisPlan.getPlanName());
		}
		log.info("HisAdminController getPlans() method end");
		return plans;
	}
	@ApiOperation(
			value = "Check case exist for the app",
			response = HisAppRegister.class,
			tags = "RestApi/isCaseExist",
			consumes = "Text",
			produces = "application/json"
			)
	@ApiResponses(value = {
			@ApiResponse(code = 200,message = "Sucecss|OK"),
			@ApiResponse(code = 401,message = "not authorized!"),
			@ApiResponse(code = 403,message = "forbidden!!!"),
			@ApiResponse(code = 404,message = "not found!!!"),
			
	})
	@GetMapping(path = "/isCaseExist",produces = {"application/json","application/xml"})
	public HisMessageResponcetModel caseExistForApp(@RequestParam("appId") String appId) throws HisException {
		
		HisMessageResponcetModel messagModel = new HisMessageResponcetModel();
		messagModel.setError(false);
		messagModel.setMessage("you can create case for this application");
		boolean returnValue = caseService.appExist(appId);
		if (returnValue) {
			messagModel.setError(true);
			messagModel.setMessage("you can't create case for this application "+appId+" case alrady created ");
		}
		return messagModel;
	}

	

}
