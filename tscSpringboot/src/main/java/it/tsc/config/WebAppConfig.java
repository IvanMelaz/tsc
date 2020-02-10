package it.tsc.config;

import javax.xml.ws.Endpoint;

import it.tsc.webservice.impl.TeleMedicareEndPointImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import it.tsc.component.CustomInterceptor;

@Configuration
@EnableWebSecurity
public class WebAppConfig implements WebMvcConfigurer {
	private static final Logger log = LoggerFactory
			.getLogger(WebAppConfig.class);
	
	@Autowired
	CustomInterceptor customInterceptor;

	@Autowired
	private Bus bus;

	public WebAppConfig() {

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.debug("register Interceptor {}", registry);
		registry.addInterceptor(customInterceptor);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "index.html");
	}

/*	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new TeleMedicareEndPointImpl());
		endpoint.publish("/Telemedicare");
		return endpoint;
	}*/

}
