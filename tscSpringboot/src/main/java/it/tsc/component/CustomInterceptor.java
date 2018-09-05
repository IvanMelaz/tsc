/**
 *
 */
package it.tsc.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author "astraservice" this class provide Custom Interceptor
 */
@Component
public class CustomInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = LoggerFactory
			.getLogger(CustomInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) throws Exception {
		log.debug(
				"===========================request begin================================================");
		log.debug("In preHandle method of Interceptor");
		log.debug("Request URL :: " + req.getRequestURL());
		log.debug("Method      : {}", req.getMethod());
		log.debug(
				"==========================request end================================================");

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.debug(
				"===========================request begin================================================");
		log.debug("In postHandle method of Interceptor");
		log.debug("Request URL:: " + request.getRequestURL());
		log.debug("Method      : {}", request.getMethod());
		log.debug(
				"==========================request end================================================");
	}
}
