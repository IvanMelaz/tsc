/**
 *
 */
package it.tsc.smartwatch.config;

import javax.sql.DataSource;

import it.tsc.smartwatch.utils.UrlConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author "astraservice"
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "it.tsc.smartwatch.domain")
@EnableTransactionManagement
public class DevelopmentConfig {

	@Value("${endpoint.url}")
	public String endPointUrl;
	@Value("${removeallarm.endpoint.url}")
	public String removeEndPointUrl;

	@Bean
	@Profile("development")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		// schema init
		Resource initSchema = new ClassPathResource("scripts/schema-h2.sql");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(
				initSchema);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
		return dataSource;
	}

	@Bean
	public UrlConfig urlConfig() {
		return new UrlConfig(endPointUrl, removeEndPointUrl);
	}
}
