package com.usa.his.gov.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.usa.his.gov.constant.AdminControllerConstant;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.model.HisUserDtls;
import com.usa.his.gov.service.HisUserDtlsService;

@Controller
@RequestMapping("Admin")
public class HisAdminController {

	@Autowired
	HisUserDtlsService userDtlsService;
	@GetMapping("/showForm")
	public String showRegisterForm(Model model) {
		HisUserDtls dtls=new HisUserDtls();
		model.addAttribute(AdminControllerConstant.DETAILS, dtls);
		return AdminControllerConstant.REGISTER_FORM_PAGE;
		
	}
	@PostMapping("/processForm")
	public String processRegisterForm(Model model,HisUserDtls userDtls) throws HisException {
		HisUserDtls returnValue = new HisUserDtls();
		returnValue=userDtlsService.newHisUser(userDtls);
		if(returnValue!=null) {
			return "redirect:/Admin/viewUsers";	
		}
		return AdminControllerConstant.REGISTER_FORM_PAGE;
	}
	@GetMapping("/viewUsers")
	public String viewUsers(Model model) throws HisException {
		List<HisUserDtls> allUsers = userDtlsService.getAllUsers();
		model.addAttribute(AdminControllerConstant.DETAILS, allUsers);
		return AdminControllerConstant.VIEW_USERS;
	}
	@GetMapping("/showFormForUpdate")
	public String updateUser(@RequestParam("publicId") String pId ,Model model) throws HisException {
		HisUserDtls userDtls=userDtlsService.getUserByPublicId(pId);
		model.addAttribute(AdminControllerConstant.DETAILS,userDtls);
		return AdminControllerConstant.REGISTER_FORM_PAGE;
	}
	@GetMapping("/makeActive")
	public String makeActive(@RequestParam("publicId") String pId) throws HisException {
		userDtlsService.reActiveUser(pId);
		return "redirect:/Admin/viewUsers";
	}
	@GetMapping("/makeInactive")
	public String makeInactive(@RequestParam("publicId") String pId) throws HisException {
		userDtlsService.softDelete(pId);
		
		return "redirect:/Admin/viewUsers";
	}
	
	
	
}
