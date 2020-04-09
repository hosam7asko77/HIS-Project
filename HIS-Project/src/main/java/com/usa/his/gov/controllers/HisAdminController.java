package com.usa.his.gov.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usa.his.gov.constant.AdminControllerConstant;
import com.usa.his.gov.exception.HisUserDtlsException;
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
	public String processRegisterForm(Model model,HisUserDtls userDtls) throws HisUserDtlsException {
		HisUserDtls returnValue = new HisUserDtls();
		returnValue=userDtlsService.newHisUser(userDtls);
		if(returnValue!=null) {
			return "redirect:/Admain/showConfirmPage?publicId="+returnValue.getPublicId();	
		}
		return AdminControllerConstant.REGISTER_FORM_PAGE;
	}
	
	
}
