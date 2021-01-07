/**
 * 
 */
package it.tsc.security.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author astraservice
 *
 */
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
  private static final Logger logger = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
  private String errorPage;

  public CustomAccessDeniedHandler() {}

  public CustomAccessDeniedHandler(String errorPage) {
    this.errorPage = errorPage;
  }

  public String getErrorPage() {
    return errorPage;
  }

  public void setErrorPage(String errorPage) {
    this.errorPage = errorPage;
  }

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
      AccessDeniedException accessDeniedException) throws IOException, ServletException {
    // do some business logic, then redirect to errorPage url
    logger.debug("handle request page: {}", request.getRequestURI());
    response.sendRedirect(errorPage);
  }

}
