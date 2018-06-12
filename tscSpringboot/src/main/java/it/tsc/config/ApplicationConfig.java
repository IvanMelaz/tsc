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
		// TODO Auto-generated constructor stub
	}

	// @Bean
	// public DataSource dataSource() {
	// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	// return builder.setType(EmbeddedDatabaseType.HSQL).build();
	// }
	//
	// @Bean
	// public EntityManagerFactory entityManagerFactory() {
	// HibernateJpaVendorAdapter vendorAdapter = new
	// HibernateJpaVendorAdapter();
	// vendorAdapter.setGenerateDdl(true);
	// LocalContainerEntityManagerFactoryBean factory = new
	// LocalContainerEntityManagerFactoryBean();
	// factory.setJpaVendorAdapter(vendorAdapter);
	// factory.setPackagesToScan("it.tsc.domain");
	// factory.setDataSource(dataSource());
	// factory.afterPropertiesSet();
	// return factory.getObject();
	// }
	//
	// @Bean
	// public PlatformTransactionManager transactionManager() {
	// JpaTransactionManager txManager = new JpaTransactionManager();
	// txManager.setEntityManagerFactory(entityManagerFactory());
	// return txManager;
	// }

}
