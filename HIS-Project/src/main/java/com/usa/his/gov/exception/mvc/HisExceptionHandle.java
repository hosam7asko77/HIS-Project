package com.usa.his.gov.exception.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
/**
 * this class using to handle all exception and show in error page
 * @author hosam7asko
 *
 */
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.usa.his.gov.constant.HisConstant;
import com.usa.his.gov.exception.HisException;
@Controller
@ControllerAdvice
public class HisExceptionHandle {
	
	@ExceptionHandler(value = HisException.class)
	public String hisAllExceptionHandler(Model model) {
		model.addAttribute(HisConstant.ERROR_MESSAGE,new HisException().getMessage());
		return HisConstant.ERROR_PAGE;
	}
}
