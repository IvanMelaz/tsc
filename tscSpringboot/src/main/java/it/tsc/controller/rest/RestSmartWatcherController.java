/**
 *
 */
package it.tsc.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.tsc.domain.BaseSmartWatcher;
import it.tsc.domain.DeviceSmartWatcher;
import it.tsc.domain.MessageSmartWatcher;
import it.tsc.service.SmartWatcherService;
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
	private SmartWatcherService smartWatcherService;
	/**
	 *
	 */
	public RestSmartWatcherController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/startAlarm", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> startAlarm​(
			@RequestBody BaseSmartWatcher baseSmartWatcher) {
		if (smartWatcherService
				.checkRegisteredDevice(baseSmartWatcher.getPhoneNumber())) {
			log.debug("user number {} registered",
					baseSmartWatcher.getPhoneNumber());
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

	@RequestMapping(value = "/positionUpdate", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> positionUpdate(
			@RequestBody BaseSmartWatcher baseSmartWatcher) {
		if (smartWatcherService
				.checkRegisteredDevice(baseSmartWatcher.getPhoneNumber())) {
			log.debug("user number {} registered",
					baseSmartWatcher.getPhoneNumber());
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

	@RequestMapping(value = "/endAlarm​​", method = RequestMethod.POST, headers = "Accept=application/json")
	public void endAlarm​(@RequestBody BaseSmartWatcher baseSmartWatcher) {

	}

	@RequestMapping(value = "/register​​", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> register​(
			@RequestBody DeviceSmartWatcher deviceSmartWatcher) {
		if (smartWatcherService
				.checkRegisteredDevice(deviceSmartWatcher.getPhoneNumber())) {
			log.debug("user number {} registered",
					deviceSmartWatcher.getPhoneNumber());
			return new ResponseEntity<>("", HttpStatus.CREATED);
		} else {
			log.debug("user number {} bad_request",
					deviceSmartWatcher.getPhoneNumber());
			return new ResponseEntity<>(
					JsonUtil.getGsonConverter()
							.toJson(new MessageSmartWatcher(
									MessageSmartWatcher.BAD_REQUEST)),
					HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/deregister​​", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<String> deregister(
			@RequestBody BaseSmartWatcher baseSmartWatcher) {
		if (smartWatcherService
				.checkRegisteredDevice(baseSmartWatcher.getPhoneNumber())) {
			log.debug("user number {} registered",
					baseSmartWatcher.getPhoneNumber());
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

}
