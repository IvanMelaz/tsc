/**
 *
 */
package it.tsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

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
