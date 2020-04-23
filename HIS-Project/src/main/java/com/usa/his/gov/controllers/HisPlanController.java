package com.usa.his.gov.controllers;

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

import com.usa.his.gov.constant.PlanControlConstant;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.HisPlan;
import com.usa.his.gov.service.HisPlanService;

/**
 * Plan controller class
 * 
 * @author hosam7asko
 *
 */
@Controller
@RequestMapping("/Admin/Plan")
public class HisPlanController {
	
	/**
	 * Enable logging for the class
	 */

	private static final Logger log = LoggerFactory.getLogger(HisAdminController.class);

	/**
	 * inject plan service for performing plan business logic operation
	 */
	@Autowired
	public HisPlanService planService;

	/**
	 * this method use to show plan form
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showPlanForm")
	public String showPlanForm(Model model) {
		log.info("HisPlanController showPlanForm() method start");
		HisPlan plan = new HisPlan();
		model.addAttribute(PlanControlConstant.PLAN_DETAILS, plan);
		log.info("HisPlanController showPlanForm() method end");
		return PlanControlConstant.PLAN_PAGE;
	}

	/**
	 * this method use to process plan form
	 * 
	 * @param plan
	 * @param model
	 * @return
	 * @throws HisException
	 */
	@PostMapping("/planFormProcess")
	public String processPlanForm(HisPlan plan, Model model) throws HisException {
		log.info("HisPlanController showPlanForm() method start");
		String pId = "1kiDVY7FkE";
		HisPlan returnPlan = planService.newPlan(plan, pId);
		if (returnPlan == null) {
			model.addAttribute(PlanControlConstant.MSG, "Error");
			log.info("HisPlanController showPlanForm() method end with error");
			return PlanControlConstant.PLAN_PAGE;
		} else {
			List<HisPlan> allPlans = planService.getAllPlans();
			model.addAttribute(PlanControlConstant.MSG, "Success");
			model.addAttribute(PlanControlConstant.PLAN_DETAILS, allPlans);
			log.info("HisPlanController showPlanForm() method end with success");
			return "redirect:/Admin/Plan/viewPlans";
		}
	}

	/**
	 * this method using to view plans
	 * 
	 * @param model
	 * @return
	 * @throws HisException
	 */
	@GetMapping("/viewPlans")
	public String viewPlans(Model model) throws HisException {
		log.info("HisPlanController viewPlans() method start");
		List<HisPlan> allPlans = planService.getAllPlans();
		model.addAttribute(PlanControlConstant.PLAN_DETAILS, allPlans);
		log.info("HisPlanController viewPlans() method end");
		return PlanControlConstant.VIEW_PLANS_PAGE;
	}

	/**
	 * this method use to update plan
	 * 
	 * @param planId
	 * @param model
	 * @return
	 * @throws HisException
	 */
	@GetMapping("/updatePlan")
	public String updatePlan(@RequestParam("planId") String planId, Model model) throws HisException {
		log.info("HisPlanController updatePlan() method start");
		HisPlan plan = planService.getPlanByPlanId(planId);
		model.addAttribute(PlanControlConstant.PLAN_DETAILS, plan);
		log.info("HisPlanController updatePlan() method end");
		return PlanControlConstant.UPDATE_PLAN_PAGE;
	}

	/**
	 * this method using to delete plan
	 * 
	 * @param planId
	 * @return
	 * @throws HisException
	 */
	@GetMapping("/deletePlan")
	public String deletePaln(@RequestParam("planId") String planId) throws HisException {
		log.info("HisPlanController deletePaln() method start");
		planService.deletePlan(planId);
		log.info("HisPlanController deletePaln() method end");
		return "redirect:/Admin/Plan/viewPlans";
	}

}
