package it.tsc.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import it.tsc.component.CustomInterceptor;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {
	private static final Logger log = LoggerFactory
			.getLogger(WebAppConfig.class);
	@Autowired
	CustomInterceptor customInterceptor;

	public WebAppConfig() {

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.debug("register Interceptor {}", registry);
		registry.addInterceptor(customInterceptor);
	}

}
