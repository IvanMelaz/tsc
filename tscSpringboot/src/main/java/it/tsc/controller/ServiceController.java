/**
 *
 */
package it.tsc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.tsc.service.UserService;

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
