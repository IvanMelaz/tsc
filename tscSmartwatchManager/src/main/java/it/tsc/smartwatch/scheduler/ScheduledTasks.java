package it.tsc.smartwatch.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import it.tsc.smartwatch.utils.UrlConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.google.gson.reflect.TypeToken;

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
		log.info("The time is:{} config:{}", dateFormat.format(new Date()),
				urlConfig.getUrlPath());
		try {
			if (urlConfig.readJsonFromUrl().isPresent()) {
				String data = urlConfig.readJsonFromUrl().get();
				log.info("read data:{}", data);
				List<CodaEve> codaEves = JsonUtil.getGsonConverter()
						.fromJson(data, new TypeToken<List<CodaEve>>() {
						}.getType());
				for (CodaEve codaEve : codaEves) {
					String phone = codaEve.getTelefono();
					log.info("insert phone: {}", phone);
					if (!StringUtils.isEmpty(phone)) {
						UUID uuid = UUID.randomUUID();
						codaEveDao.insertAllarmiInCodaEve_Brondi(phone,
								uuid.toString(), "SMARTWATCH");
						urlConfig.removeAllarm(codaEve.getId_allarme().trim());
					}

				}
			} else {
				log.info("data not present: {}",urlConfig.readJsonFromUrl());
			}
		} catch (Exception e) {
			log.error("Exception: {}", e.getMessage());
		}
	}
}
