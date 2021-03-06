/**
 *
 */
package it.tsc.controller.rest;

import it.tsc.domain.Allarmi;
import it.tsc.service.AnagraficaService;
import it.tsc.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author astraservice
 *
 */
@RestController
public class RestAnagraficaServiceController extends RestBaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(RestAnagraficaServiceController.class);

	@Autowired
	private AnagraficaService anagraficaService;

	/**
	 *
	 */
	public RestAnagraficaServiceController() {

	}

	/**
	 * get TSC User
	 *
	 * @param user
	 * @return
	 */
	@PreAuthorize("hasAuthority('ROLE_ADMIN') or hasAuthority('ROLE_SADMIN') or hasAuthority('ROLE_USER')")
	@RequestMapping(value = {"/user/tscService/getAnagrafica",
			"/admin/tscService/getAnagrafica"}, method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String getAnagrafica(
			@AuthenticationPrincipal Principal user,
			@RequestBody Allarmi allarm, BindingResult result) {
		return JsonUtil.getGsonConverter()
				.toJson(anagraficaService.getAnagrafica(allarm.getAb_codi()));
	}

}
