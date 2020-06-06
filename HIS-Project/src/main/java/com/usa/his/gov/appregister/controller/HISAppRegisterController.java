package com.usa.his.gov.appregister.controller;

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
import static com.usa.his.gov.constant.AppRegisterConstant.*;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.user.controller.HisAdminController;

@Controller
@RequestMapping("/AppRegister")
public class HISAppRegisterController {

	/**
	 * Enable logging for the class
	 */
	private static final Logger log = LoggerFactory.getLogger(HisAdminController.class);
	/**
	 * inject to performing business logic operations
	 */
	@Autowired
	HisAppRegisterService registerService;

	/**
	 * this method using to show application registration form to add new
	 * Application
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/showRegisterForm")
	public String showRegisterForm(Model model) {
		log.info("In HISAppRegisterController showRegisterForm()method starting");
		HisAppRegister hisAppRegister = new HisAppRegister();
		model.addAttribute(PROCESS_FORM, "processRegisterForm");
		model.addAttribute(APP_REGISTER, hisAppRegister);
		log.info("In HISAppRegisterController showRegisterForm()method ending");
		return APP_REGISTER_FORM;
	}

	@PostMapping("/processRegisterForm")
	public String processRegister(HisAppRegister register, RedirectAttributes attributes, Model model)
			throws HisException {
		log.info("In HISAppRegisterController processRegister()method starting");
		boolean isSave = registerService.newApplication(register);
		if (isSave) {
			log.info("In HISAppRegisterController processRegister()method end data saved");
			attributes.addFlashAttribute(MESSAGE, "Application Created");
			return REDIRECT_TO_VIEW_ALL;
		} else {
			model.addAttribute(MESSAGE, "Error im Application Creation");
			model.addAttribute(APP_REGISTER, register);
			log.info("In HISAppRegisterController processRegister()method end data not saved");
			return APP_REGISTER_FORM;
		}

	}

	@GetMapping("/getApplication")
	public String getApplicationById(@RequestParam("appId") String appId, Model model) throws HisException {
		log.info("In HISAppRegisterController getApplicationById()method starting");
		HisAppRegister returnValue = registerService.getApplicationById(appId);
		if (returnValue == null) {
			model.addAttribute(MESSAGE, "Appliction Dose Not Exist");
			log.info("In HISAppRegisterController getApplicationById()method no appliction found ");
			return SEARCH_PAGE;
		}
		model.addAttribute(APP_REGISTER, returnValue);
		log.info("In HISAppRegisterController getApplicationById()method end");
		return SEARCH_PAGE;
	}

	@GetMapping("getAllApp")
	public String getAllApplications(Model model) throws HisException {
		log.info("In HISAppRegisterController getAllApplications()method starting");
		List<HisAppRegister> applications = registerService.getAllApplications();
		model.addAttribute(APP_REGISTER, applications);
		log.info("In HISAppRegisterController getAllApplications()method end");
		return VIEW_ALL_APPLICATIONS;
	}

	@GetMapping("/showUpdateForm")
	public String showUpdateForm(@RequestParam("appId") String appId, Model model) throws HisException {
		log.info("In HISAppRegisterController showUpdateForm()method starting");
		HisAppRegister hisAppRegister = registerService.getApplicationById(appId);
		model.addAttribute(PROCESS_FORM, "processUpdateForm");
		model.addAttribute(APP_REGISTER, hisAppRegister);
		log.info("In HISAppRegisterController showUpdateForm()method ending");
		return APP_REGISTER_FORM;
	}

	@PostMapping("/processUpdateForm")
	public String processUpdate(HisAppRegister register, RedirectAttributes attributes, Model model)
			throws HisException {
		log.info("In HISAppRegisterController processUpdate()method starting");
		boolean isSave = registerService.updateApplication(register);
		if (isSave) {
			log.info("In HISAppRegisterController processUpdate()method end data saved");
			attributes.addFlashAttribute(MESSAGE, "Application Updated");
			return REDIRECT_TO_VIEW_ALL;
		} else {
			model.addAttribute(MESSAGE, "Error im Application Creation");
			model.addAttribute(APP_REGISTER, register);
			log.info("In HISAppRegisterController processUpdate()method end data not saved");
			return APP_REGISTER_FORM;
		}

	}

	@GetMapping("/deleteApp")
	public String deleteApp(@RequestParam("appId") String appId, RedirectAttributes attributes) {
		log.info("In HISAppRegisterController undoDelete()method starting");
		boolean isDelete = registerService.updateDeleteStatus(DELETE, appId);
		if (isDelete) {
			log.info("In HISAppRegisterController deleteApp()method starting");
			attributes.addFlashAttribute(MESSAGE, "Appliction Number his been deleted successfule");
			log.info("In HISAppRegisterController deleteApp()method end not delete");
			return REDIRECT_TO_VIEW_ALL;
		} else {

		}
		attributes.addFlashAttribute(MESSAGE, "Appliction Number is Not  deleted");
		log.info("In HISAppRegisterController deleteApp()method end");
		return REDIRECT_TO_VIEW_ALL;
	}

	@GetMapping("/undoDeleteApp")
	public String undoDelete(@RequestParam("appId") String appId, RedirectAttributes attributes) {
		log.info("In HISAppRegisterController undoDelete()method starting");
		boolean isUndoDelete = registerService.updateDeleteStatus(UNDO_DELETE, appId);
		if (isUndoDelete) {
			attributes.addFlashAttribute(MESSAGE, "Appliction his been undo deleted successfule");
			log.info("In HISAppRegisterController undoDelete()method end ");
			return REDIRECT_TO_VIEW_ALL;
		} else {

		}
		attributes.addFlashAttribute(MESSAGE, "Appliction is Not undo deleted");
		log.info("In HISAppRegisterController undoDelete()method end appliction not undo delete");
		return REDIRECT_TO_VIEW_ALL;

	}
	@GetMapping("/showSearchPage")
	public String showSearch() {
		return "search-page";
	}

}
