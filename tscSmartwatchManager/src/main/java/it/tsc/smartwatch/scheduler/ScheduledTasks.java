/**
 *
 */
package it.tsc.smartwatch.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import it.tsc.smartwatch.config.UrlConfig;
import it.tsc.smartwatch.domain.CodaEve;
import it.tsc.smartwatch.domain.repository.CodaEveDao;
import it.tsc.smartwatch.utils.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory
			.getLogger(ScheduledTasks.class);
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(
			"HH:mm:ss");

	@Autowired
	private UrlConfig urlConfig;

	@Autowired
	private CodaEveDao codaEveDao;

	@Scheduled(fixedDelayString = "${fixed.rate}")
	public void startScheduler() {
		log.info("The time is now {} config: {}", dateFormat.format(new Date()),
				urlConfig.getUrlPath());
		try {
			if (urlConfig.readJsonFromUrl().isPresent()) {
				String data = urlConfig.readJsonFromUrl().get();
				log.info("read data: {} idAllarme: {}", data);
				Gson gson = new GsonBuilder().setDateFormat("mm DD, yyyy")
						.excludeFieldsWithoutExposeAnnotation().create();
				List<CodaEve> codaEves = JsonUtil.getGsonConverter()
						.fromJson(data, new TypeToken<List<CodaEve>>() {
						}.getType());
				for (CodaEve codaEve : codaEves) {
					String telefono = codaEve.getTelefono();
					log.info("insert telefono: {}", telefono);
					if (!StringUtils.isEmpty(telefono)) {
						UUID uuid = UUID.randomUUID();
						codaEveDao.insertAllarmiInCodaEve_Brondi(telefono,
								uuid.toString(), "SMARTWATCH");
						urlConfig.removeAllarm(codaEve.getId_allarme().trim());
					}

				}
			} else {
				log.info("time {} data not present: {}");
			}
		} catch (Exception e) {
			log.error("Exception: {}", e);
		}
	}
}
