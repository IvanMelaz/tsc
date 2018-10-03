/**
 *
 */
package it.tsc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author astraservice Class for bean configuration service
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
public class ServiceConfig {

	@Bean(name = "bcryptEncoder")
	public BCryptPasswordEncoder bcryptEncoder() {
		return new BCryptPasswordEncoder();
	}

}
