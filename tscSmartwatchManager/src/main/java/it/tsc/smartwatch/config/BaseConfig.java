package it.tsc.smartwatch.config;

import org.springframework.beans.factory.annotation.Value;

public abstract  class BaseConfig {

	@Value("${endpoint.url}")
	protected String endPointUrl;
	@Value("${removeallarm.endpoint.url}")
	protected String removeEndPointUrl;

}
