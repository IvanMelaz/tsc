/**
 *
 */
package it.tsc.smartwatch.config;

import javax.sql.DataSource;

import it.tsc.smartwatch.utils.UrlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Objects;
import java.util.Properties;

/**
 * @author "astraservice"
 *
 */
@Configuration
@EnableJpaRepositories(basePackages = "it.tsc.smartwatch.domain")
@EnableTransactionManagement
@Profile("production")
public class ProductionConfig extends BaseConfig{

	@Autowired
	private Environment env;

	@Value("${mysql.spring.datasource.url}")
	private String url;
	@Value("${mysql.spring.datasource.username}")
	private String user;
	@Value("${mysql.spring.datasource.password}")
	private String password;
	@Value("${mysql.spring.datasource.driver-class-name}")
	private String driverClass;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClass);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		return dataSource;
	}

	/**
	 * Declare the JPA entity manager factory.
	 */
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory =
				new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setDataSource(dataSource());

		// Classpath scanning of @Component, @Service, etc annotated class
		entityManagerFactory.setPackagesToScan(
				env.getProperty("entitymanager.packagesToScan"));

		// Vendor adapter
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);

		// Hibernate properties
		Properties additionalProperties = new Properties();
		additionalProperties.put(
				"hibernate.dialect",
				Objects.requireNonNull(env.getProperty("hibernate.dialect")));
		additionalProperties.put(
				"hibernate.show_sql",
				Objects.requireNonNull(env.getProperty("hibernate.show_sql")));
		additionalProperties.put(
				"hibernate.hbm2ddl.auto",
				Objects.requireNonNull(env.getProperty("hibernate.hbm2ddl.auto")));
		entityManagerFactory.setJpaProperties(additionalProperties);

		return entityManagerFactory;
	}

	/**
	 * Declare the transaction manager.
	 */
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager =
				new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(
				entityManagerFactory().getObject());
		return transactionManager;
	}

	/**
	 * PersistenceExceptionTranslationPostProcessor is a bean post processor
	 * which adds an advisor to any bean annotated with Repository so that any
	 * platform-specific exceptions are caught and then rethrown as one
	 * Spring's unchecked data access exceptions (i.e. a subclass of
	 * DataAccessException).
	 */
	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public UrlConfig urlConfig() {
		return new UrlConfig(endPointUrl, removeEndPointUrl);
	}
}
