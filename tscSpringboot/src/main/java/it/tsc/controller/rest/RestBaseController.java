/**
 * 
 */
package it.tsc.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Validator;

/**
 * @author astraservice
 *
 */
@RestController
public class RestBaseController {

  @Autowired
  protected Validator validator;

  /**
   * Base Rest Class
   */
  public RestBaseController() {

  }

}
