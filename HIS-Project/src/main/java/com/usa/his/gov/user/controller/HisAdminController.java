package com.usa.his.gov.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.his.gov.appregister.model.HisAppRegister;
import com.usa.his.gov.appregister.service.HisAppRegisterService;
import com.usa.his.gov.constant.AdminControllerConstant;
import com.usa.his.gov.constant.HisConstant;
import com.usa.his.gov.dc.model.HisCaseDtls;
import com.usa.his.gov.dc.service.HisCaseDtlservice;
import com.usa.his.gov.elg.model.ElgDetails;
import com.usa.his.gov.elg.service.EDRuleRestClientService;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.UpdatePasswordRequest;
import com.usa.his.gov.user.model.HisPlan;
import com.usa.his.gov.user.model.HisUserDtls;
import com.usa.his.gov.user.service.HisPlanService;
import com.usa.his.gov.user.service.HisUserDtlsService;

@Controller
@RequestMapping("/Admin")
public class HisAdminController {
	/**
	 * Enable logging for the class
	 */

	private static final Logger log = LoggerFactory.getLogger(HisAdminController.class);
	/**
	 * injecting service class object for performing business operations
	 */
	@Autowired
	private HisUserDtlsService userDtlsService;
	@Autowired 
	HisAppRegisterService appService;
	@Autowired
	HisCaseDtlservice caseDtlservice;
	@Autowired
	HisPlanService planService;
	@Autowired
	EDRuleRestClientService edRulesService;
	/**
	 * update InActive user Status to Active
	 * 
	 * @param pId
	 * @return
	 * @throws HisException
	 */

	@GetMapping("/Manager/makeActive")
	public String makeActive(@RequestParam("publicId") String pId) throws HisException {
		log.info("HisAdminController makeActive() method execution start");
		userDtlsService.reActiveUser(pId);
		log.info("HisAdminController makeActive() method execution end");
		return "redirect:/Admin/viewUsers";
	}

	/**
	 * update Active user Status to InActive
	 * 
	 * @param pId
	 * @return
	 * @throws HisException
	 */
	@GetMapping("/Manager/makeInactive")
	public String makeInactive(@RequestParam("publicId") String pId) throws HisException {
		log.info("HisAdminController makeInActive() method execution start");
		userDtlsService.softDelete(pId);
		log.info("HisAdminController makeInActive() method execution stop");
		return "redirect:/Admin/viewUsers";
	}

	/**
	 * this method use to show last step in registration by show user new password
	 * set form user should set new password
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showSetPassword")
	public String showSetPassword(Model model) {
		log.info("HisAdminController showSetPassword() method execution start");
		UpdatePasswordRequest passwordRequest = new UpdatePasswordRequest();
		model.addAttribute(AdminControllerConstant.SET_PASSWORD_REQUEST, passwordRequest);
		log.info("HisAdminController verifyEmail() method execution end");
		return AdminControllerConstant.SET_PASSWORD_PAGE;
	}

	/**
	 * this method using to process new password form
	 * 
	 * @param request
	 * @param attributes
	 * @return
	 * @throws HisException
	 */
	@PostMapping("/setPasswordProcess")
	public String setPasswordProcess(UpdatePasswordRequest request, RedirectAttributes attributes) throws HisException {
		log.info("HisAdminController setPasswordProcess() method execution start");
		HisUserDtls userDtls = userDtlsService.updetePassword(request.getEmail(), request.getPassword());
		if (userDtls!=null) {
		attributes.addFlashAttribute(AdminControllerConstant.DETAILS, userDtls);
		log.info("HisAdminController setPasswordProcess() method end");
		return HisConstant.LOGIN_PAGE;
		}else {
			log.info("HisAdminController setPasswordProcess() method end with exception");
			return AdminControllerConstant.SET_PASSWORD_PAGE;
		}
	}
	@GetMapping("/")
	public String showDashboard(Model model) throws HisException {
		HisPlan plan = new HisPlan();
		model.addAttribute(AdminControllerConstant.PLAN_DETAILS, plan);
		List<HisPlan> allPlans = planService.getAllPlans();
		model.addAttribute(AdminControllerConstant.PLANS, allPlans);
		List<HisUserDtls> allUsers = userDtlsService.getAllUsers();
		model.addAttribute(AdminControllerConstant.DETAILS, allUsers);
		int appSize = appService.getAllApplications().size();
		model.addAttribute(AdminControllerConstant.APP_NO,appSize);
		int caseSize = caseDtlservice.getAllCases().size();
		model.addAttribute(AdminControllerConstant.CASE_NO, caseSize);
		model.addAttribute("elgDnNo", edRulesService.getCountStatus("DN"));
		model.addAttribute("elgApNo", edRulesService.getCountStatus("AP"));
		return AdminControllerConstant.DASHBORD_PAGE;
	}
	@GetMapping("/userProfile")
	public String showUserProfile(Model model) {
		log.info("HisAdminController singUp() method execution start");
		model.addAttribute(AdminControllerConstant.DETAILS, new HisUserDtls());
		model.addAttribute(AdminControllerConstant.PROCESS_FORM, "processForm");
		log.info("HisAdminController singUp() method execution end");
		return AdminControllerConstant.USER_PROFIL;
	}
	@GetMapping("/tables")
	public String showTables(Model model) throws HisException {
		List<HisAppRegister> applications = appService.getAllApplications();
		List<HisCaseDtls> cases = caseDtlservice.getAllCases();
		List<HisPlan> plans = planService.getAllPlans();
		List<ElgDetails> elg = edRulesService.getAllElg();
		model.addAttribute(AdminControllerConstant.APPLICATIONS, applications);
		model.addAttribute(AdminControllerConstant.CASES, cases);
		model.addAttribute(AdminControllerConstant.PLANS, plans);
		model.addAttribute(AdminControllerConstant.ELGS, elg);
		return AdminControllerConstant.TABELS;
	}
	@PostMapping("/planFormProcess")
	public String processPlanForm(HisPlan plan, Model model) throws HisException {
		log.info("HisPlanController showPlanForm() method start");
		HisPlan returnPlan = planService.newPlan(plan);
		if (returnPlan == null) {
			model.addAttribute(AdminControllerConstant.MSG, "Error");
			log.info("HisPlanController showPlanForm() method end with error");
			return AdminControllerConstant.REDIRECT_TO_DASHBOARD;
		} else {
			return AdminControllerConstant.REDIRECT_TO_DASHBOARD;
		}
	}

	@PostMapping("/updatePlanFormProcess")
	public String processUpdatePlanForm(HisPlan plan, Model model) throws HisException {
		log.info("HisPlanController showPlanForm() method start");
		HisPlan returnPlan = planService.newPlan(plan);
		if (returnPlan == null) {
			model.addAttribute(AdminControllerConstant.MSG, "Error");
			log.info("HisPlanController showPlanForm() method end with error");
			return AdminControllerConstant.REDIRECT_TO_DASHBOARD;
		} else {
			return AdminControllerConstant.REDIRECT_TO_DASHBOARD;
		}
	}
	@GetMapping("/deletePlan")
	public String deletePaln(@RequestParam("planId") String planId) throws HisException {
		log.info("HisPlanController deletePaln() method start");
		planService.deletePlan(planId);
		log.info("HisPlanController deletePaln() method end");
		return AdminControllerConstant.REDIRECT_TO_DASHBOARD;
	}

}
