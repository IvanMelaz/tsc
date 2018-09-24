/**
 *
 */
package it.tsc.controller.rest;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.tsc.domain.BaseSmartWatcher;
import it.tsc.domain.MessageSmartWatcher;
import it.tsc.repository.CodaEveDao;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@RestController
public class RestSmartWatcherController {
	private static final Logger log = LoggerFactory
			.getLogger(RestSmartWatcherController.class);

	@Autowired
	private CodaEveDao codaEveDao;

	private static final String CENTRALE = "SMARTWATCH";
	/**
	 *
	 */
	public RestSmartWatcherController() {

	}

	@RequestMapping(value = "/startAlarm", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> startAlarm​(
			@RequestBody BaseSmartWatcher baseSmartWatcher) {
		if (StringUtils.isNotBlank(baseSmartWatcher.getPhoneNumber().trim())) {
			log.debug("user number {} registered",
					baseSmartWatcher.getPhoneNumber());
			try {
				UUID filename = UUID.randomUUID();
				codaEveDao.insertAllarmiInCodaEve_Brondi(
						baseSmartWatcher.getPhoneNumber(), filename.toString(),
						CENTRALE);
			} catch (Exception e) {
				// TODO: handle exception
			}
			return new ResponseEntity<>("", HttpStatus.CREATED);
		} else {
			log.debug("user number {} bad_request",
					baseSmartWatcher.getPhoneNumber());
			return new ResponseEntity<>(
					JsonUtil.getGsonConverter()
							.toJson(new MessageSmartWatcher(
									MessageSmartWatcher.BAD_REQUEST)),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/getAllarms", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody String getAlarm​s() {
		String response = null;

		try {
			response = JsonUtil.getGsonConverter().toJson(codaEveDao.findAll());
		} catch (Exception e) {
			log.error("getAlarm​s Exception: {}", e);
		}
		log.debug("getAlarm​s: {}", response);
		return response;
	}

	@RequestMapping(value = "/removeAllarm", method = RequestMethod.GET, headers = "Accept=application/json")
	public void removeAlarm​(@RequestParam("id_allarme") String id_allarme) {
		log.debug("removeAlarm​​: {}", id_allarme);
		try {
			codaEveDao.removeAllarme(id_allarme);
		} catch (Exception e) {
			log.error("removeAlarm​​s Exception: {}", e);
		}

	}

	// @RequestMapping(value = "/positionUpdate", method = RequestMethod.POST,
	// headers = "Accept=application/json")
	// public ResponseEntity<String> positionUpdate(
	// @RequestBody BaseSmartWatcher baseSmartWatcher) {
	// if (smartWatcherService
	// .checkRegisteredDevice(baseSmartWatcher.getPhoneNumber())) {
	// log.debug("user number {} registered",
	// baseSmartWatcher.getPhoneNumber());
	// return new ResponseEntity<>("", HttpStatus.CREATED);
	// } else {
	// log.debug("user number {} bad_request",
	// baseSmartWatcher.getPhoneNumber());
	// return new ResponseEntity<>(
	// JsonUtil.getGsonConverter()
	// .toJson(new MessageSmartWatcher(
	// MessageSmartWatcher.BAD_REQUEST)),
	// HttpStatus.BAD_REQUEST);
	// }
	// }
	//
	// @RequestMapping(value = "/endAlarm​​", method = RequestMethod.POST,
	// headers = "Accept=application/json")
	// public void endAlarm​(@RequestBody BaseSmartWatcher baseSmartWatcher) {
	//
	// }
	//
	// @RequestMapping(value = "/register​​", method = RequestMethod.POST,
	// headers = "Accept=application/json")
	// public ResponseEntity<String> register​(
	// @RequestBody DeviceSmartWatcher deviceSmartWatcher) {
	// if (smartWatcherService
	// .checkRegisteredDevice(deviceSmartWatcher.getPhoneNumber())) {
	// log.debug("user number {} registered",
	// deviceSmartWatcher.getPhoneNumber());
	// return new ResponseEntity<>("", HttpStatus.CREATED);
	// } else {
	// log.debug("user number {} bad_request",
	// deviceSmartWatcher.getPhoneNumber());
	// return new ResponseEntity<>(
	// JsonUtil.getGsonConverter()
	// .toJson(new MessageSmartWatcher(
	// MessageSmartWatcher.BAD_REQUEST)),
	// HttpStatus.BAD_REQUEST);
	// }
	// }
	//
	// @RequestMapping(value = "/deregister​​", method = RequestMethod.POST,
	// headers = "Accept=application/json")
	// public ResponseEntity<String> deregister(
	// @RequestBody BaseSmartWatcher baseSmartWatcher) {
	// if (smartWatcherService
	// .checkRegisteredDevice(baseSmartWatcher.getPhoneNumber())) {
	// log.debug("user number {} registered",
	// baseSmartWatcher.getPhoneNumber());
	// return new ResponseEntity<>("", HttpStatus.CREATED);
	// } else {
	// log.debug("user number {} bad_request",
	// baseSmartWatcher.getPhoneNumber());
	// return new ResponseEntity<>(
	// JsonUtil.getGsonConverter()
	// .toJson(new MessageSmartWatcher(
	// MessageSmartWatcher.BAD_REQUEST)),
	// HttpStatus.BAD_REQUEST);
	// }
	// }

}
