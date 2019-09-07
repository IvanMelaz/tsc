/**
 * 
 */
package com.lotto.generator.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/**
 * @author astraservice
 *
 */
@Component
public class ResourceManager {
	@Autowired
	private ResourceLoader resourceLoader;
	@Value("${app.path}")
	private String path;

	@Value("${app.numbers}")
	private String numbers;

	@Autowired
	private static ApplicationContext context;

	/**
	 * 
	 */
	public ResourceManager() {

	}

	public List<List<String>> loadCovering() throws IOException {
		List<List<String>> result = new ArrayList<>();
		Resource resource = resourceLoader.getResource(path);
		InputStream in = resource.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		while (true) {
			String line = reader.readLine();
			if (line == null)
				break;

			List<String> lines = Arrays.asList(line.split(","));
			lines.sort((e1, e2) -> Integer.valueOf(e1).compareTo(Integer.valueOf(e2)));
			result.add(lines);
		}
		return result;
	}

	public List<String> numbers() {
		List<String> ints = new ArrayList<>();
		Arrays.asList(numbers.split("-")).stream().forEach(r -> {
			ints.add(r);
		});
		return ints.stream().sorted().collect(Collectors.toList());
	}

	public List<String> orderResult() {
		List<String> ints = new ArrayList<>();
		Arrays.asList(numbers.split("-")).stream().forEach(r -> {
			ints.add(r);
		});
		return ints.stream().sorted().collect(Collectors.toList());
	}

}
