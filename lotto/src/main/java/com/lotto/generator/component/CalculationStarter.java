/**
 * 
 */
package com.lotto.generator.component;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author astraservice
 *
 */
@Component
public class CalculationStarter {
	private static final Logger log = LoggerFactory.getLogger(CalculationStarter.class);

	@Autowired
	ResourceManager resourceManager;
	String SEPARATOR = " ";

	/**
	 * 
	 */
	public CalculationStarter() {
		// TODO Auto-generated constructor stub
	}

	public void startCalculation() throws IOException {
		if (resourceManager.numbers().size() != resourceManager.loadCovering().size()) {
			throw new IllegalArgumentException("different size from numbers - coverage");
		}

		List<String> numbers = resourceManager.numbers();
		for (List<String> items : resourceManager.loadCovering()) {
			String result = "";
			for (String index : items) {
				result += numbers.get(Integer.valueOf(index) - 1) + SEPARATOR;
			}
			log.info(result);
		}
	}

}
