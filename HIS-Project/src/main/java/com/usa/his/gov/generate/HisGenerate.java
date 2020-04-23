package com.usa.his.gov.generate;

import java.security.SecureRandom;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * this class using to generate value for variable
 * 
 * @author hosam7asko
 *
 */
@Component
public class HisGenerate {
	/**
	 * Enable logging for the class
	 */
	Logger log = LoggerFactory.getLogger(HisGenerate.class);
	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	/**
	 * method to generate public
	 * 
	 * @param length
	 * @return
	 */
	public String generateValues(int length) {
		log.info("HisGenerate generateValues()method call");
		return generateRandomString(length);
	}

	/**
	 * 
	 * @param length
	 * @return
	 */
	private String generateRandomString(int length) {
		log.info("HisGenerate generateRandomString()method start");
		StringBuilder returnValue = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));

		}
		log.info("HisGenerate generateRandomString()method end");
		return new String(returnValue);
	}

}
