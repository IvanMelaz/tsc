/**
 *
 */
package it.tsc.smartwatch.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author "astraservice"
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "it.tsc.smartwatch.domain")
@EnableTransactionManagement
public class MYSQLJPAConfig {

	@Value("${mysql.spring.datasource.url}")
	private String url;
	@Value("${mysql.spring.datasource.username}")
	private String user;
	@Value("${mysql.spring.datasource.password}")
	private String password;
	@Value("${mysql.spring.datasource.driver-class-name}")
	private String driverClass;

	@Bean
	@Profile("production")
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}
}
