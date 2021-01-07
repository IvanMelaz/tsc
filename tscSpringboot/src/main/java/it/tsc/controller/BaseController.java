/**
 *
 */
package it.tsc.controller;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import it.tsc.domain.Role;

/**
 * @author astraservice Base class for all controller
 */
@Controller
public class BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(BaseController.class);
	@Autowired
	private MessageSource messageSource;
	private final Locale defaultLocale = new Locale("it", "IT");

	protected String ACTION_ADMIN = "admin";
	protected String ACTION_USER = "user";
	protected String ACTION_INSERT_MFA = "addMfaSecurityCode";
	protected String ACTION_CHECK_MFA = "checkMfaSecurityCode";
	protected String ACTION_ERROR_PAGE = "errorPage";
	protected String WELCOME_PAGE = "index";

	/**
	 *
	 */
	public BaseController() {
		
	}

	public String getMessage(String key) {
		return messageSource.getMessage(key, null, defaultLocale);
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	// Specify name of a specific view that will be used to display the error:
	// Total control - setup a model and return the view name yourself. Or
	// consider subclassing ExceptionHandlerExceptionResolver (see below).
	@ExceptionHandler(Exception.class)
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);

		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", req.getRequestURL());
		mav.setViewName(ACTION_ERROR_PAGE);
		return mav;
	}

	/**
	 * Role Map
	 *
	 * @return
	 */
	protected Map<String, String> roles() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("", "");
		roles.put(Role.ROLE_ADMIN.toString(), "Admin");
		roles.put(Role.ROLE_USER.toString(), "User");
		roles.put(Role.ROLE_BACKOFFICE.toString(), "Back Office");
		return roles;
	}

	/**
	 * check if authenticated add parameter mfaEnabled
	 *
	 * @param request
	 * @return
	 */
	protected boolean isMfaAuthenticated(HttpServletRequest request,
			boolean mfaEnabled) {
		if (!mfaEnabled) {
			/**
			 * user skip MFA authentication
			 */
			return true;
		}
		if (request.getSession().getAttribute("isMfaAuthenticated") == null) {
			return false;
		} else {
			if (request.getSession()
					.getAttribute("isMfaAuthenticated") instanceof String) {
				return request.getSession()
						.getAttribute("isMfaAuthenticated").equals("true");
			} else {
				return false;
			}
		}
	}

	/**
	 * set Authenticated
	 *
	 * @param request
	 * @param value
	 */
	protected void setMfaAuthenticated(HttpServletRequest request,
			String value) {
		request.getSession().setAttribute("isMfaAuthenticated", value);
	}

	/**
	 * get User Role , can return null
	 *
	 * @return
	 */
	protected Role getUserRole() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		logger.debug("auth: {}", auth.getAuthorities().toString());
		if (auth != null && auth.getAuthorities() != null) {
			return Role.fromString(auth.getAuthorities().toString());
		} else {
			return null;
		}
	}

}
