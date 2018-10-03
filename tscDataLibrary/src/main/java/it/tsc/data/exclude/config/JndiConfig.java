/**
 *
 */
package it.tsc.data.exclude.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import it.tsc.data.config.BaseConfig;

/**
 * @author "astraservice"
 *
 */
@Configuration
@Profile("prod")
public class JndiConfig extends BaseConfig {
	/**
	 * Base Config for Spring Definition
	 */
	public JndiConfig() {
		// TODO Auto-generated constructor stub
	}

	@Primary
	@Bean(name = "entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
			@Qualifier("jndiDataSource") DataSource dataSource)
			throws NamingException {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setPersistenceUnitName(MYSQL_PERSISTENCE_UNIT);
		entityManagerFactory.setDataSource(dataSource);
		return entityManagerFactory;
	}

}
