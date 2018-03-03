/**
 *
 */
package it.tsc.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

/**
 * @author "astraservice"
 *
 */
@Configuration
@Profile("dev")
public class JdbcConfig extends BaseConfig {
	/**
	 *
	 */
	public JdbcConfig() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Property placeholder configurer needed to process @Value annotations
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigurerAbstractDao() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(name = "entityManagerFactory")
	/**
	 *
	 * @return
	 */
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceUnitName(MYSQL_PERSISTENCE_UNIT);
		return entityManagerFactory;
	}

}
