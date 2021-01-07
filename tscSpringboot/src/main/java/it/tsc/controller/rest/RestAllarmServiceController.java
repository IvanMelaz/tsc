/**
 *
 */
package it.tsc.controller.rest;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.tsc.domain.Allarmi;
import it.tsc.service.CodaEveService;

/**
 * @author astraservice
 *
 */

@RestController
public class RestAllarmServiceController {
  private static final Logger logger = LoggerFactory.getLogger(RestAllarmServiceController.class);

  @Autowired
  private CodaEveService codaEveService;

  /**
   * remove allarm from queue
   *
   * @param allarmi
   * @param user
   * @return
   */
  @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SADMIN') or hasAuthority('ROLE_USER')")
  @RequestMapping(
      value = { "/user/allarmService/removeAllarm", "/admin/allarmService/removeAllarm" },
      method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody Allarmi removeAllarm(@RequestBody Allarmi allarmi,
      @AuthenticationPrincipal Principal user) {
    logger.debug("getSerial_uuid() {} user: {}", allarmi.getId_allarme());
    logger.debug("user: {}", user.getName());
    codaEveService.removeAllarme(allarmi.getId_allarme());
    return allarmi;
  }

  /**
   * update user in Allarmi open
   *
   * @param allarm
   * @param user
   * @return
   */
  @PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SADMIN') or hasAuthority('ROLE_USER')")
  @RequestMapping(
      value = { "/user/codaEveService/updateAllarm", "/admin/codaEveService/updateAllarm" },
      method = RequestMethod.POST, produces = "application/json")
  public @ResponseBody Allarmi updateAllarm(@RequestBody Allarmi allarm,
      @AuthenticationPrincipal Principal user) {
    logger.debug("getSerial_uuid() {} user: {}", allarm.getId_allarme(), user.getName());
    codaEveService.updateAllarme(allarm.getId_allarme(), user.getName());
    return allarm;
  }

}
