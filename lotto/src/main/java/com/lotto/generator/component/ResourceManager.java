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
import java.util.Comparator;
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

    @Autowired
    private Numbers numbers;

    @Value("${app.path}")
    private String path;

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
            lines.sort(Comparator.comparing(Integer::valueOf));
            result.add(lines);
        }
        return result;
    }

    public List<String> numbers() {
        return numbers.getNumbers();
    }

}
