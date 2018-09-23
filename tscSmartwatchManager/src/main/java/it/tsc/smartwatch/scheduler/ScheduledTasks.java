/**
 *
 */
package it.tsc.smartwatch.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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

	@Scheduled(fixedDelayString = "${fixed.rate}")
	public void startScheduler() {
		log.info("The time is now {}", dateFormat.format(new Date()));
	}
}
