/**
 * 
 */
package it.tsc.security.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * @author astraservice
 *
 */
public class AuthSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

  @Override
  protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {
    // Get the role of logged in user
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    String role = auth.getAuthorities().toString();
    String targetUrl = "";
    if (role.contains("ROLE_ADMIN")) {
      targetUrl = "/admin";
    } else if (role.contains("ROLE_USER")) {
      targetUrl = "/home";
    }
    return targetUrl;
  }
}