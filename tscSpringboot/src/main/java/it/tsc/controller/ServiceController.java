/**
 *
 */
package it.tsc.controller;

import it.tsc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author "astraservice" Controller that contains service
 */
@Controller
public class ServiceController extends BaseController {
  @Autowired
  private UserService userService;

  /**
   *
   */
  public ServiceController() {
    
  }

  protected UserService getUserService() {
    return userService;
  }

}
