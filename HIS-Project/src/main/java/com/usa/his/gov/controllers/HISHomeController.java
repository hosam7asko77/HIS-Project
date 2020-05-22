package com.usa.his.gov.controllers;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.usa.his.gov.constant.HisConstant.*;
import com.usa.his.gov.elg.model.ElgDetails;
import com.usa.his.gov.elg.service.EDRuleRestClientService;
import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.user.controller.HisAdminController;

/**
 * this is home controller class
 * 
 * @author hosam7asko
 *
 */
@Controller
@RequestMapping("/")
public class HISHomeController {
	/**
	 * Enable logging for the class
	 */

	private static final Logger log = LoggerFactory.getLogger(HisAdminController.class);

	@Autowired
	EDRuleRestClientService edService;
	/**
	 * this method use to show index page
	 */
	@GetMapping("/")
	public String showIndex() {
		log.info("HISHomeController showIndex() method start");
		log.info("HISHomeController showIndex() method end");
		return "index";
	}
	@GetMapping("/login")
	public String showLogin() {
		return "fancy-login";
	}
	@GetMapping("/showErrorPage")
	public String showError() {
		return ERROR_PAGE;
	}
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}

	@GetMapping("/sendEdDetails")
	public String getIndvInfo(@RequestParam("caseNumber") Integer caseNumber,RedirectAttributes attributes) throws HisException, ParseException {
		log.info("HisRestController getInv Start");
		ElgDetails details = edService.saveEDInfo(caseNumber);
		if (details != null) {
			attributes.addFlashAttribute(MESSAGE, SUCCESS_MESSAGE);
			return "redirect:/";
		}
		
		return ERROR_PAGE;
		

	}
}
