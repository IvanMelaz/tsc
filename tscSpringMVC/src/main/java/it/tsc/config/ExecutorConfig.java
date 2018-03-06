/**
 *
 */
package it.tsc.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;

/**
 * @author "astraservice"
 *
 */
public class ExecutorConfig {
	private ScheduledExecutorService executorService = null;
	/**
	 *
	 */
	public ExecutorConfig() {
		// TODO Auto-generated constructor stub
	}

	@Bean(name = "executorService")
	public ScheduledExecutorService executorService() {
		return executorService = Executors.newSingleThreadScheduledExecutor();
	}

	@PreDestroy
	public void shutwownExecutor() {
		// Your code..
		if (!executorService.isShutdown()) {
			executorService.shutdown();
		}
	}

}
