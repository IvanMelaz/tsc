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
	public ResponseEntity<String> startAlarms(
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
	public @ResponseBody String getAlarms() {
		String response = null;

		try {
			response = JsonUtil.getGsonConverter().toJson(codaEveDao.findAll());
		} catch (Exception e) {
			log.error("getAlarms Exception: {}", e);
		}
		log.debug("getAlarms: {}", response);
		return response;
	}

	@RequestMapping(value = "/removeAllarm", method = RequestMethod.GET, headers = "Accept=application/json")
	public void removeAlarms(@RequestParam("id_allarme") String id_allarme) {
		log.debug("removeAllarm id_allarme: {}", id_allarme);
		try {
			codaEveDao.removeAllarme(id_allarme);
		} catch (Exception e) {
			log.error("removeAlars Exception: {}", e);
		}

	}

	@RequestMapping(value = "/removeAllAllarms", method = RequestMethod.GET, headers = "Accept=application/json")
	public void removeAllAllarms() {
		log.debug("removeAllAllarms: {}");
		try {
			codaEveDao.deleteAll();
		} catch (Exception e) {
			log.error("removeAlarms Exception: {}", e);
		}

	}

	@RequestMapping(value = "/insert_allarmi_codaeve_brondi", method = RequestMethod.GET)
	public void insertAllarmiCodaeveBrondi(@RequestParam("telefono") String telefono,
								 @RequestParam("filename") String filename,
								 @RequestParam("centrale") String centrale) {
		log.debug("insertAllarmiCodaeveBrondi: telefono: {} filename: {} centrale: {}",telefono,filename,centrale);
		try {
			codaEveDao.insertAllarmiInCodaEve_Brondi(trimValue(telefono),trimValue(filename),trimValue(centrale));
		} catch (Exception e) {
			log.error("insertAllarmiCodaeveBrondi Exception: {}", e);
		}
	}

	@RequestMapping(value = "/insert_allarmi_codaeve", method = RequestMethod.GET)
	public void insertAllarmiInCodaEve(@RequestParam("matricola") String matricola,
										   @RequestParam("evento") String evento,
										   @RequestParam("centrale") String centrale,
										   @RequestParam("mux") String mux,
										   @RequestParam("ritardo") String ritardo
	) {
		log.debug("insertAllarmiInCodaEve: matricola: {} evento: {} centrale: {}",matricola,evento,centrale);
		try {
			codaEveDao.insertAllarmiInCodaEve(trimValue(matricola),trimValue(evento),trimValue(centrale),
					trimValue(mux),trimValue(ritardo));
		} catch (Exception e) {
			log.error("insertAllarmiInCodaEve Exception: {}", e);
		}
	}

	/**
	 * trim the value
	 * @param value
	 * @return
	 */
	private String trimValue(String value){
		return value != null?value.trim():null;
	}
}
