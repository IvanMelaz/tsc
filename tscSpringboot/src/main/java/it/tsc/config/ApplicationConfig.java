/**
 *
 */
package it.tsc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author "astraservice"
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "it.tsc.repository")
@EnableTransactionManagement
public class ApplicationConfig {

	/**
	 *
	 */
	public ApplicationConfig() {
		
	}

}
