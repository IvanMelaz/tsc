/**
 * 
 */
package com.lotto.generator;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.lotto.generator.component.CalculationStarter;
import com.lotto.generator.properties.AppProperties;

/**
 * @author astraservice
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Application {
	@Autowired
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private static ApplicationContext context;

	/**
	 * 
	 */
	public Application() {
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) throws IOException {
		CalculationStarter calculationStarter = ctx.getBean("calculationStarter", CalculationStarter.class);
		calculationStarter.startCalculation();
		return args -> {
			//			log.info("Let's inspect the beans provided by Spring Boot and application:");
			//			String[] beanNames = ctx.getBeanDefinitionNames();
			//			Arrays.sort(beanNames);
			//			for (String beanName : beanNames) {
			//				log.info(beanName);
			//			}
		};
	}

}
