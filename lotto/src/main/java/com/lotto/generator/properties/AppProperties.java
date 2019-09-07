/**
 * 
 */
package com.lotto.generator.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author astraservice
 *
 */
@ConfigurationProperties(prefix = "app")
@Validated
public class AppProperties {
	/**
	 * 
	 */
	public AppProperties() {
		// TODO Auto-generated constructor stub
	}

}
