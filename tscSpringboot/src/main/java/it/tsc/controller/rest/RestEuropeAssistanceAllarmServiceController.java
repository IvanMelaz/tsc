/**
 *
 */
package it.tsc.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.tsc.service.EuropeAssistanceService;

/**
 * @author astraservice
 *
 */

@RestController
public class RestEuropeAssistanceAllarmServiceController {
  private static final Logger logger =
      LoggerFactory.getLogger(RestEuropeAssistanceAllarmServiceController.class);

  @Autowired
  private EuropeAssistanceService europeAssistanceService;

  /**
   * Rest service allarm EuropeAssistance
   *
   * @return
   */
  @RequestMapping(value = { "/allarmiEuropeAssistance" }, method = RequestMethod.GET,
      produces = "application/json")
  public @ResponseBody String allarmiEuropeAssistance() {
    logger.debug("allarmiEuropeAssistance: {}", europeAssistanceService.listJsonAllarmiOpen());
    return europeAssistanceService.listJsonAllarmiOpen();
  }

}
