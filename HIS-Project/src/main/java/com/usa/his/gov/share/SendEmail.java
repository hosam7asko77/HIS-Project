package com.usa.his.gov.share;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.usa.his.gov.constant.HisConstant;
import com.usa.his.gov.model.HisUserDtls;

/**
 * this class using to send email
 * 
 * @author hosam7asko
 *
 */
@Component
public class SendEmail {
	/**
	 * Enable logging for the class
	 */
	private Logger log = LoggerFactory.getLogger(SendEmail.class);
	/**
	 * send confirm email with temp password File name
	 */

	private final static String HTML_EMAIL_BODY = "HTML_BODY_FILE.txt";
	/**
	 * send forget password email File name
	 */
	private final static String HTML_FORGET_BODY = "FORGET_PASSWORD.txt";
	/**
	 * inject java mail sender object to performing send email
	 */
	@Autowired
	private JavaMailSender sender;

	/**
	 * this method using to send email for complete register
	 * 
	 * @param account
	 * @return
	 */
	public boolean sendTempPasswordToEmail(HisUserDtls account) {
		log.info("SendEmail sendTempPasswordToEmail()method start");
		boolean flag = false;
		try {
			String htmlBody = getEmailBody(HTML_EMAIL_BODY);
			htmlBody = htmlBody.replace("$firstName", account.getFirstName());
			htmlBody = htmlBody.replace("$temPassword", account.getPassword());
			htmlBody = htmlBody.replace("$email", account.getEmail());
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, false);
			helper.setTo(account.getEmail());
			helper.setSubject(HisConstant.EMAIL_SUBJECT);
			helper.setText(htmlBody, true);
			// helper.addInline("logoImage", new
			// File("src\\main\\resources/\\tatic\\img\\core-img\\logo.png"));
			sender.send(message);
			flag = true;
			log.info("SendEmail sendTempPasswordToEmail()method end email sent");
		} catch (MessagingException e) {
			log.info("SendEmail sendTempPasswordToEmail()method end exception whith Messaging ");
			flag = false;
			e.printStackTrace();
		} catch (IOException e) {
			log.info("SendEmail sendTempPasswordToEmail()method end exception when reding file");
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * this method using to send Message forget password
	 * 
	 * @param account
	 * @return
	 */

	public boolean sendForgetPassword(HisUserDtls account) {
		log.info("SendEmail sendForgetPassword()method start");
		boolean flag = false;
		try {
			String htmlBody = getEmailBody(HTML_FORGET_BODY);
			htmlBody = htmlBody.replace("$firstName", account.getFirstName());
			htmlBody = htmlBody.replace("$password", account.getPassword());
			MimeMessage message = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, false);
			helper.setTo(account.getEmail());
			helper.setSubject(HisConstant.FORGET_SUBJECT);
			helper.setText(htmlBody);
			sender.send(message);
			flag = true;
			log.info("SendEmail sendForgetPassword()method end email sent");

		} catch (MessagingException e) {
			log.info("SendEmail sendForgetPassword()method end exception whith Messaging ");
			flag = false;
			e.printStackTrace();
		} catch (IOException e) {
			log.info("SendEmail sendForgetPassword()method end exception when reding file");
			flag = false;
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * this to read the html file
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	private String getEmailBody(String fileName) throws IOException {
		log.info("SendEmail getEmailBody()method start");
		StringBuffer buffer = new StringBuffer("");
		ClassPathResource resource = new ClassPathResource(fileName);

		File reader = resource.getFile();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(reader))) {
			String line = bufferedReader.readLine();
			while (line != null) {
				buffer.append(line);
				line = bufferedReader.readLine();
			}
		}
		String mailBody = buffer.toString();
		log.info("SendEmail getEmailBody()method end");
		return mailBody;
	}
}
