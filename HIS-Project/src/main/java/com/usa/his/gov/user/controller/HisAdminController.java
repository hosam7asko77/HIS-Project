package com.usa.his.gov.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.usa.his.gov.constant.AdminControllerConstant;
import com.usa.his.gov.constant.HisConstant;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.request.UpdatePasswordRequest;
import com.usa.his.gov.user.model.HisUserDtls;
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

	/**
	 * this method using to show registeration page
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/Manager/showForm")
	public String singUp(Model model) {
		log.info("HisAdminController singUp() method execution start");
		model.addAttribute(AdminControllerConstant.DETAILS, new HisUserDtls());
		model.addAttribute(AdminControllerConstant.PROCESS_FORM, "processForm");
		log.info("HisAdminController singUp() method execution end");
		return AdminControllerConstant.REGISTER_FORM_PAGE;

	}

	/**
	 * this method using to process registration form
	 * 
	 * @param userDtls
	 * @param attributes
	 * @return
	 * @throws HisException
	 */
	@PostMapping("/Manager/processForm")
	public String processRegisterForm(@ModelAttribute("details") HisUserDtls userDtls, RedirectAttributes attributes)
			throws HisException {
		log.info("HisAdminController processRegisterForm() method execution starts");
		HisUserDtls returnValue = new HisUserDtls();
		returnValue = userDtlsService.newHisUser(userDtls);
		if (returnValue != null) {
			attributes.addFlashAttribute("Msg", "Success");
			log.info("HisAdminController processRegisterForm() method execution end success");
			return AdminControllerConstant.REDIRECT_VIEW_PAGE;
		}
		log.info("HisAdminController processRegisterForm() method execution end with exception");
		return AdminControllerConstant.REGISTER_FORM_PAGE;
	}

	/**
	 * this method using to view all users and allow admin to managing them
	 * 
	 * @param model
	 * @return
	 * @throws HisException
	 */
	@GetMapping("/Manager/viewUsers")
	public String viewUsers(Model model) throws HisException {
		log.info("HisAdminController viewUsers() method execution starts");
		List<HisUserDtls> allUsers = userDtlsService.getAllUsers();
		model.addAttribute(AdminControllerConstant.DETAILS, allUsers);
		log.info("HisAdminController viewUsers() method execution end");
		return AdminControllerConstant.VIEW_USERS;
	}

	/**
	 * this method using to show update form
	 * 
	 * @param pId
	 * @param model
	 * @return
	 * @throws HisException
	 */
	@GetMapping("/Manager/showFormForUpdate")
	public String showFormForUpdateUser(@RequestParam("publicId") String pId, Model model) throws HisException {
		log.info("HisAdminController showFormForUpdateUser() method execution starts");
		HisUserDtls userDtls = userDtlsService.getUserByPublicId(pId);
		model.addAttribute(AdminControllerConstant.DETAILS, userDtls);
		model.addAttribute(AdminControllerConstant.PROCESS_FORM, "ProcessUpdateForm");
		log.info("HisAdminController showFormForUpdateUser() method execution end");
		return AdminControllerConstant.REGISTER_FORM_PAGE;
	}

	/**
	 * this method using to process update form
	 * 
	 * @param userDtls
	 * @param attributes
	 * @return
	 * @throws HisException
	 */
	@PostMapping("/Manager/processUpdateForm")
	public String processUpdateForm(@ModelAttribute("details") HisUserDtls userDtls, RedirectAttributes attributes)
			throws HisException {
		log.info("HisAdminController processUpdateForm() method execution starts");
		HisUserDtls returnValue = new HisUserDtls();
		returnValue = userDtlsService.updateUser(userDtls);
		if (returnValue != null) {
			System.out.println("Process update Call");
			attributes.addFlashAttribute("Msg", "Update Success");
			log.info("HisAdminController processUpdateForm() method execution end success");
			return AdminControllerConstant.REDIRECT_VIEW_PAGE;
		}
		log.info("HisAdminController processUpdateForm() method execution exception");
		return AdminControllerConstant.REGISTER_FORM_PAGE;
	}

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


}
