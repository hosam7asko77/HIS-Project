package com.usa.his.gov.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.usa.his.gov.constant.HisConstant.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.usa.his.gov.exception.HisException;
import com.usa.his.gov.user.controller.HisAdminController;
import com.usa.his.gov.user.service.HisUserDtlsService;

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
	HisUserDtlsService userService;
	/**
	 * this method use to show index page
	 * @throws HisException 
	 */
	@GetMapping("/")
	public String showIndex(Model  model,HttpSession session) throws HisException { 
		log.info("HISHomeController showIndex() method start");
		String publicId = userService.getPublicId();
		String sessionPublicId = (String) session.getAttribute(PUBLIC_ID_SESSION);
		if (sessionPublicId==null) {
			session.setAttribute(PUBLIC_ID_SESSION, publicId);
		}
		
//		else {
//		model.addAttribute("userDetails", session.getAttribute(PUBLIC_ID_SESSION));
//		}
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


}
