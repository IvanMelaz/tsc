/**
 *
 */
package it.tsc.data.config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

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

	@Bean(name = "dataSource")
	public DataSource dataSource() throws NamingException {
		return (DataSource) new JndiTemplate()
				.lookup(environment.getProperty(jdbcUrl));
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
