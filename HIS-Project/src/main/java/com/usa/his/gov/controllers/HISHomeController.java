package com.usa.his.gov.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.usa.his.gov.constant.HisConstant;
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
		return HisConstant.ERROR_PAGE;
	}
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
}
