package uk.ac.mib.antismashoops.web.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelpController {
	private static final Logger logger = LoggerFactory.getLogger(HelpController.class);

	/**
	 * Handles the URL call to /help path. Displays the help view
	 * 
	 * @return The help HTML view.
	 */

	@RequestMapping("/help")
	public String help() {
		return "help";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(HttpServletRequest req, Exception exception) {
		req.setAttribute("message", exception.getClass() + " - " + exception.getMessage());
		logger.error("Exception thrown: " + exception.getClass());
		logger.error("Exception message: " + exception.getMessage());
		exception.printStackTrace();
		return "error";
	}
}
