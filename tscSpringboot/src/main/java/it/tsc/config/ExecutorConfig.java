/**
 *
 */
package it.tsc.config;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "astraservice"
 *
 */
@Configuration
public class ExecutorConfig {
  private ScheduledExecutorService scheduledExecutorService = null;

  /**
   *
   */
  public ExecutorConfig() {
    // TODO Auto-generated constructor stub
  }

  @Bean(name = "scheduledExecutorService")
  public ScheduledExecutorService scheduledExecutorService() {
    return scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
  }

  @PreDestroy
  public void shutwownExecutor() {
    // Your code..
    if (!scheduledExecutorService.isShutdown()) {
      scheduledExecutorService.shutdown();
    }
  }

}
