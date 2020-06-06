package com.usa.his.gov.dc.controller;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import static com.usa.his.gov.constant.HisConstant.ERROR_PAGE;
import static com.usa.his.gov.constant.HisConstant.MESSAGE;
import static com.usa.his.gov.constant.HisConstant.SUCCESS_MESSAGE;
import static com.usa.his.gov.constant.HisDataCollectionConstant.*;

import com.usa.his.gov.dc.model.HisCaseDtls;
import com.usa.his.gov.dc.model.HisCasePlan;
import com.usa.his.gov.dc.model.HisCrimeDtls;
import com.usa.his.gov.dc.model.HisFamilyDtls;
import com.usa.his.gov.dc.model.HisJobDtls;
import com.usa.his.gov.dc.model.HisKidsDtls;
import com.usa.his.gov.dc.service.HisCaseDtlservice;
import com.usa.his.gov.elg.model.ElgDetails;
import com.usa.his.gov.elg.service.EDRuleRestClientService;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.user.model.HisPlan;
import com.usa.his.gov.user.service.HisPlanService;

@Controller
@RequestMapping("/DC")
public class HISDCController {
	/**
	 * Enable logging for the class
	 */
	private static final Logger log = LoggerFactory.getLogger(HISDCController.class);
	/**
	 * inject HisCaseDtlservice create an object
	 */
	@Autowired
	private HisCaseDtlservice caseService;
	@Autowired
	private HisPlanService planService;
	@Autowired
	EDRuleRestClientService edService;
	private String backToo;

	@GetMapping("/showCaseForm")
	public String caseForm(Model model) {
		log.info("HISDCController caseForm() method starting");
		model.addAttribute(CASE_DETAILS, new HisCaseDtls());
		log.info("HISDCController caseForm() method end");
		return CREATE_CASE_FORM_URL;
	}

	@PostMapping("/processCaseForm")
	public String processCaseForm(HisCaseDtls caseDtls, Model model,HttpSession session)
			throws HisException {
		log.info("HISDCController caseForm() method starting");
		HisCaseDtls returnValue = caseService.newCase(caseDtls);
		if (returnValue == null) {
			log.info("HISDCController caseForm() method end with exception");
			throw new HisException();
		}
		log.info("HISDCController caseForm() method end success");
		session.setAttribute(CASE_PROCESS, "running");
		model.addAttribute(CASE_DETAILS, returnValue);
		return REDIRECT_TO_SELECT_PLAN+"?caseNumber="+returnValue.getCaseNumber();
	}

	@GetMapping("/showSelectPlan")
	public String selectPlan(@RequestParam("caseNumber") Integer caseNumber,Model model) throws HisException {
		log.info("HISDCController selectPlan() method starting");
		HisCaseDtls caseDetails = caseService.getCaseDetails(caseNumber);
		if (caseDetails.getCasePlan()==null) {
			List<HisPlan> plans = planService.getAllPlans();
			model.addAttribute(CASE_NUMBER,caseNumber);
			model.addAttribute(CASE_PALN_DETAILS, new HisCasePlan());
			model.addAttribute(ALL_PLANS, plans);
			log.info("HISDCController selectPlan() method success");
			return SELECT_PALN_FORM_URL;
		}else {
			return REDIRECT_TO_FUMILY+caseNumber;
		}

	}

	@PostMapping("/processSelectPlanForm")
	public String selectPlanProcess(HisCasePlan casePlan, Model model) throws HisException {
		log.info("HISDCController selectPlanProcess() method starting");
		HisCasePlan returnValue = caseService.addCasePlan(casePlan);
		if (returnValue != null) {
			log.info("HISDCController selectPlanProcess() method end success");
			return REDIRECT_TO_FUMILY+casePlan.getCaseNumber();
		} else {
			log.info("HISDCController selectPlanProcess() method end with exception");
			throw new HisException();
			
		}

	}

	@GetMapping("/showFamilyForm")
	public String showFamilyForm(@RequestParam("caseNumber") Integer caseNumber,Model model) throws HisException {
		log.info("HISDCController showFamilyForm() method starting");
		HisFamilyDtls familyDtls = caseService.getFamilyByCase(caseNumber);
		model.addAttribute(CASE_NUMBER, caseNumber);
		model.addAttribute(PROCESS_HANDELER, "processFamily");
		if (familyDtls==null) {
			model.addAttribute(FAMILY_DETAILS, new HisFamilyDtls());
			log.info("HISDCController showFamilyForm() method end");
			return FAMILY_FORM;
		}else {
			model.addAttribute(FAMILY_DETAILS, familyDtls);
			return FAMILY_FORM;
		}

	}

	@PostMapping("/processFamily")
	public String processFamilyForm(HisFamilyDtls familyDtls, Model model) throws HisException {
		log.info("HISDCController processFamilyForm() method starting");
		backToo=BACK_TO_FAMILY;
		HisFamilyDtls returnValue = caseService.addFamilyDtls(familyDtls);
		HisCasePlan plan = caseService.getCasePlanByCaseNumber(returnValue.getCaseNumber());
		 if (plan.getPlanName().equalsIgnoreCase("SNAP")) {
			 log.info("HISDCController processFamilyForm() method end go to crime");
				return REDIRECT_TO_CRIME+returnValue.getCaseNumber()+backToo;
			}
		else if (returnValue.getHaveChild()) {
			log.info("HISDCController processFamilyForm() method end go to kids");
			return REDIRECT_TO_KIDS_DETAILS+returnValue.getCaseNumber();
		}
		 else {
			 log.info("HISDCController processFamilyForm() method end go to job");
			return REDIRECT_TO_JOB_DETAILS+ returnValue.getCaseNumber()+backToo;

		}
	}


	@GetMapping("/showKidsForm")
	public String showKidsForm(@RequestParam("caseNumber") Integer caseNumber,Model model) throws HisException {
		List<HisKidsDtls> allKids = caseService.getAllKids(caseNumber);
		if (allKids != null) {
			model.addAttribute(KIDS_DETAILS_LIST, allKids);
		}
		backToo=BACK_TO_KIDS;
		model.addAttribute(BACK_TO, backToo);
		model.addAttribute(KIDS_DETAILS, new HisKidsDtls());
		model.addAttribute(CASE_NUMBER, caseNumber);
		model.addAttribute(PROCESS_HANDELER, "processKidsForm");
		return KIDS_FORM;
	}

	@PostMapping("/processKidsForm")
	public String processKidsForm(HisKidsDtls kidsDtls, Model model) throws HisException {
		HisKidsDtls returnValue = caseService.addKid(kidsDtls);
		model.addAttribute(PROCESS_HANDELER, "processKidsForm");
		if (returnValue != null) {
			model.addAttribute(KIDS_DETAILS, new HisKidsDtls());
			List<HisKidsDtls> allKids = caseService.getAllKids(returnValue.getCaseNumber());
			HisCaseDtls caseDetails = caseService.getCaseDetails(returnValue.getCaseNumber());
			model.addAttribute(CASE_DETAILS, caseDetails);
			model.addAttribute(KIDS_DETAILS_LIST, allKids);
			model.addAttribute(MESSAGE, "kid added sucessfuly");
			return REDIRECT_TO_KIDS_DETAILS+returnValue.getCaseNumber();
		} else {
			return KIDS_FORM;
		}
	}
	@GetMapping("/deleteKids")
	public String deleteKidsProcess(
			@RequestParam("childId") Integer childId,
			@RequestParam("from")String from,
			@RequestParam("caseNumber")Integer caseNumber,
			Model model) throws HisException {
		log.info("delete Start");
		caseService.deleteKids(childId);
		model.addAttribute(KIDS_DETAILS, new HisKidsDtls());
		List<HisKidsDtls> allKids = caseService.getAllKids(caseNumber);
		model.addAttribute(CASE_NUMBER, caseNumber);
		model.addAttribute(KIDS_DETAILS_LIST, allKids);
		if (from.equalsIgnoreCase("processEditKids")) {
			log.info("in if Start");
			model.addAttribute(PROCESS_HANDELER, "processEditKids");
			return "redirect:/Dc/showEditKids?caseNumber="+caseNumber;
		}else {
			model.addAttribute(PROCESS_HANDELER, "processKidsForm");
			log.info("out  if Start");
			return REDIRECT_TO_KIDS_DETAILS+caseNumber;
		}
		
	}
	@GetMapping("/updateKids")
	public String updateKids(
			@RequestParam("childId") Integer childId,
			@RequestParam("from")String from,
			@RequestParam("caseNumber")Integer caseNumber,Model model) throws HisException {
		
		backToo=BACK_TO_KIDS;
		model.addAttribute(BACK_TO, backToo);
		HisKidsDtls kidDtls = caseService.getKidById(childId);
		List<HisKidsDtls> allKids = caseService.getAllKids(caseNumber);
		model.addAttribute(CASE_NUMBER, caseNumber);
		model.addAttribute(KIDS_DETAILS_LIST, allKids);
		model.addAttribute(KIDS_DETAILS, kidDtls);
		if (from.equalsIgnoreCase("processEditKids")) {
			model.addAttribute(PROCESS_HANDELER, "processEditKids");
			model.addAttribute(KIDS_DETAILS, kidDtls);
			return KIDS_FORM;
//			return "redirect:/DC/showEditKids?caseNumber="+caseNumber;
		}else {
			model.addAttribute(PROCESS_HANDELER, "processKidsForm");
			return KIDS_FORM;
		}
		
	}



	@GetMapping("/showJobForm")
	public String showJobForm(@RequestParam("caseNumber") Integer caseNumber,
			@RequestParam("backTo") String backTo,
			Model model) throws HisException {
		HisJobDtls hisJobDtls = caseService.getJobByCaseNumber(caseNumber);
		model.addAttribute(CASE_NUMBER, caseNumber);
		model.addAttribute(PROCESS_HANDELER, "processJobForm");
		model.addAttribute(BACK_TO, backTo);
		if (hisJobDtls==null) {
			model.addAttribute(JOB_DETAILS, new HisJobDtls());
			return JOB_FORM;	
		}else {
			model.addAttribute(JOB_DETAILS, hisJobDtls);
			return JOB_FORM;
		}
	}

	@PostMapping("/processJobForm")
	public String processJobForm(HisJobDtls jobDtls, Model attributes) throws HisException {
		backToo=BACK_TO_JOB;
		HisJobDtls returnValue = caseService.addJobDetails(jobDtls);
		if (returnValue != null) {
			HisCaseDtls caseDetails = caseService.getCaseDetails(returnValue.getCaseNumber());
			attributes.addAttribute(CASE_DETAILS, caseDetails);
			return REDIRECT_TO_CRIME+caseDetails.getCaseNumber()+backToo;
		} else {
			attributes.addAttribute(MESSAGE, "you can adding this info");
			return JOB_FORM;
		}
	}

	@GetMapping("/showCrimeForm")
	public String showCrimeForm(@RequestParam("caseNumber") Integer caserNumber,@RequestParam("backTo")String backTo, Model model) throws HisException {
		HisCrimeDtls crimeDtls = caseService.getCrimeDtls(caserNumber);
		model.addAttribute(CASE_NUMBER, caserNumber);
		model.addAttribute(PROCESS_HANDELER, "processCrimeForm");
		System.out.println(backTo);
		model.addAttribute(BACK_TO,backTo);
		if (crimeDtls==null) {
		model.addAttribute(CRIME_DETAILS, new HisCrimeDtls());
		return CRIME_FORM;
		}else {
			model.addAttribute(CRIME_DETAILS, crimeDtls);
			return CRIME_FORM;
		}
	}

	@PostMapping("/processCrimeForm")
	public String processCrimeForm(HisCrimeDtls crimeDtls, Model attributes) throws HisException {
		log.info("in HISDCController processCrimeForm() method starting");
		HisCrimeDtls returnValue = caseService.addCrimeDetails(crimeDtls);
		if (returnValue != null) {
			log.info("in HISDCController processCrimeForm() method save");
			attributes.addAttribute(MESSAGE, "Data Collection Successfuly");
			return REDIRECT_CASE_CREATED_PAGE+returnValue.getCaseNumber();
		} else {
			log.info("in HISDCController processCrimeForm() method not save");
			return CRIME_FORM;
		}
	}

	@GetMapping("/showCaseCreated")
	public String CaseCreated(@RequestParam("caseNumber") Integer caseNumber, Model model) throws HisException {
		boolean exist = edService.infoExist(caseNumber);
		if (exist) {
			return "redirect:/";
		}else {
		HisCaseDtls caseDetails = caseService.getCaseDetails(caseNumber);
		System.out.println(caseDetails);
		HisFamilyDtls familyDtls = caseService.getFamilyByCase(caseNumber);
		HisJobDtls jobDtls = caseService.getJobByCaseNumber(caseNumber);
		HisCrimeDtls crimeDtls = caseService.getCrimeDtls(caseNumber);
		model.addAttribute(CASE_DETAILS, caseDetails);
		model.addAttribute(FAMILY_DETAILS, familyDtls);
		model.addAttribute(JOB_DETAILS, jobDtls);
		model.addAttribute(CRIME_DETAILS, crimeDtls);
		if (familyDtls.getHaveChild()) {
			List<HisKidsDtls> allKids = caseService.getAllKids(caseNumber);
			model.addAttribute(KIDS_DETAILS_LIST, allKids);
		}

		return CASE_CREATED;
		}
		
	}

	@GetMapping("/showEditFamily")
	public String showEditFamly(@RequestParam("caseNumber") Integer caseNumber,Model model) throws HisException {
		log.info("HISDCController showEditFamly() method starting");
//		HisFamilyDtls familyDtls = caseService.getFamilyByCase(caseNumber);
		HisCaseDtls caseDetails = caseService.getCaseDetails(caseNumber);
		model.addAttribute(PROCESS_HANDELER, "processEditFamily");
		model.addAttribute(FAMILY_DETAILS,caseDetails.getFamilyDtls());
		log.info("HISDCController showEditFamly() method end");
		return FAMILY_FORM;
	}
	@PostMapping("/processEditFamily")
	public String processEditFamly(HisFamilyDtls familyDtls, Model attributes) throws HisException {
		log.info("HISDCController processFamilyForm() method starting");
		HisFamilyDtls returnValue = caseService.addFamilyDtls(familyDtls);
		HisCaseDtls caseDetails = caseService.getCaseDetails(returnValue.getCaseNumber());
		attributes.addAttribute(CASE_DETAILS, caseDetails);
		log.info("HISDCController processFamilyForm() method end go to kids");
		return REDIRECT_CASE_CREATED_PAGE+returnValue.getCaseNumber();
	}
	@GetMapping("/showEditjobForm")
	public String showEditJob(@RequestParam("caseNumber") Integer caseNumber, Model model) throws HisException {
		HisJobDtls jobDtls = caseService.getJobByCaseNumber(caseNumber);
		model.addAttribute(PROCESS_HANDELER, "processEditJob");
		model.addAttribute(CASE_NUMBER, caseNumber);
		model.addAttribute(JOB_DETAILS, jobDtls);
		return JOB_FORM;
	}

	@PostMapping("/processEditJob")
	public String processEditJob(HisJobDtls jobDtls, Model attributes) throws HisException {
		HisJobDtls returnValue = caseService.addJobDetails(jobDtls);
		if (returnValue != null) {
			HisCaseDtls caseDetails = caseService.getCaseDetails(returnValue.getCaseNumber());
			attributes.addAttribute(CASE_DETAILS, caseDetails);
			return REDIRECT_CASE_CREATED_PAGE+caseDetails.getCaseNumber();
		} else {
			attributes.addAttribute(MESSAGE, "you can adding this info");
			return JOB_FORM;
		}

	}
	@GetMapping("/showEditCrime")
	public String showEditCrime(@RequestParam("caseNumber") Integer caserNumber, Model model) throws HisException {
		HisCrimeDtls crimeDtls = caseService.getCrimeDtls(caserNumber);
		model.addAttribute(CASE_NUMBER, caserNumber);
		model.addAttribute(CRIME_DETAILS, crimeDtls);
		model.addAttribute(PROCESS_HANDELER, "processEditCrime");
		return CRIME_FORM;
	}
	@PostMapping("/processEditCrime")
	public String processEditCrime(HisCrimeDtls crimeDtls, Model attributes) throws HisException {
		log.info("in HISDCController processCrimeForm() method starting");
		HisCrimeDtls returnValue = caseService.addCrimeDetails(crimeDtls);
		if (returnValue != null) {
			log.info("in HISDCController processCrimeForm() method save");
			attributes.addAttribute(MESSAGE, "Data Collection Successfuly");
			return REDIRECT_CASE_CREATED_PAGE+returnValue.getCaseNumber();
		} else {
			log.info("in HISDCController processCrimeForm() method not save");
			return CRIME_FORM;
		}
	}
	@GetMapping("/showEditKids")
	public String showEditKids(@RequestParam("caseNumber")Integer caseNumber, Model model) throws HisException {
		model.addAttribute(KIDS_DETAILS, new HisKidsDtls());
		model.addAttribute(PROCESS_HANDELER, "processEditKids");
			List<HisKidsDtls> allKids = caseService.getAllKids(caseNumber);
			model.addAttribute(CASE_NUMBER, caseNumber);
			model.addAttribute(KIDS_DETAILS_LIST, allKids);
			return KIDS_FORM;
	}
	@PostMapping("/processEditKids")
	public String processEditKids(HisKidsDtls kidsDtls, Model model) throws HisException {
		HisKidsDtls returnValue = caseService.addKid(kidsDtls);
		model.addAttribute(KIDS_DETAILS, new HisKidsDtls());
		model.addAttribute(PROCESS_HANDELER, "processEditKids");
		if (returnValue != null) {
			List<HisKidsDtls> allKids = caseService.getAllKids(returnValue.getCaseNumber());
			HisCaseDtls caseDetails = caseService.getCaseDetails(returnValue.getCaseNumber());
			model.addAttribute(CASE_DETAILS, caseDetails);
			model.addAttribute(KIDS_DETAILS_LIST, allKids);
			return KIDS_FORM;
		} else {
			return KIDS_FORM;
		}
		
	}
	@GetMapping("/sendEdDetails")
	public String getIndvInfo(@RequestParam("caseNumber") Integer caseNumber,RedirectAttributes attributes,HttpSession session) throws HisException, ParseException {
		log.info("HisRestController getInv Start");
		ElgDetails details = edService.saveEDInfo(caseNumber);
		if (details != null) {
			session.setAttribute(CASE_PROCESS, "done");
			attributes.addFlashAttribute(MESSAGE, SUCCESS_MESSAGE);
			return "redirect:/";
		}
		
		return ERROR_PAGE;		
	}
	@GetMapping("/viewAllCases")
	public String showCases(Model model) {
		List<HisCaseDtls> allCases = caseService.getAllCases();
		model.addAttribute(ALL_CASES,allCases);
		return ALL_CASES_PAGE;
	}
	@GetMapping("/deleteCase")
	public String deleteCase(@RequestParam("caseNumber")Integer caseNumber,Model model) throws HisException {
		boolean isDelete = caseService.deleteCase(caseNumber);
		if (isDelete) {
			List<HisCaseDtls> allCases = caseService.getAllCases();
			model.addAttribute(ALL_CASES,allCases);
			model.addAttribute(MESSAGE, "caseDeleted");
			return ALL_CASES_PAGE;
		}
		List<HisCaseDtls> allCases = caseService.getAllCases();
		model.addAttribute(ALL_CASES,allCases);
		model.addAttribute(MESSAGE, "can delete this case");
		return ALL_CASES_PAGE;
	}
	@GetMapping("/moreDetails")
	public String viewMoreDetails(@RequestParam("caseNumber")Integer caseNumber,Model model) throws HisException {
		HisCaseDtls caseDetails = caseService.getCaseDetails(caseNumber);
		System.out.println(caseDetails);
		HisFamilyDtls familyDtls = caseService.getFamilyByCase(caseNumber);
		HisJobDtls jobDtls = caseService.getJobByCaseNumber(caseNumber);
		HisCrimeDtls crimeDtls = caseService.getCrimeDtls(caseNumber);
		model.addAttribute(CASE_DETAILS, caseDetails);
		model.addAttribute(FAMILY_DETAILS, familyDtls);
		model.addAttribute(JOB_DETAILS, jobDtls);
		model.addAttribute(CRIME_DETAILS, crimeDtls);
		if (familyDtls.getHaveChild()) {
			List<HisKidsDtls> allKids = caseService.getAllKids(caseNumber);
			model.addAttribute(KIDS_DETAILS_LIST, allKids);
		}

		return MORE_PAGE;
		
	}
}
