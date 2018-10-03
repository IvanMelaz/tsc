/**
 *
 */
package it.tsc.data.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author "astraservice"
 *
 */
@Configuration
@PropertySource(value = {"classpath:db.properties"})
public class BaseConfig {
	@Value("${mysql-persistence-unit}")
	protected String MYSQL_PERSISTENCE_UNIT;

	@Value("${cassandra-persistence-unit}")
	protected String CASSANDRA_PERSISTENCE_UNIT;

	@Value("${jdbc.url}")
	protected String jdbcUrl;

	@Autowired
	protected Environment environment;
	/**
	 *
	 */
	public BaseConfig() {
		// TODO Auto-generated constructor stub
	}

}
