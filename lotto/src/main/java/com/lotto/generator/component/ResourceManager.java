/**
 *
 */
package com.lotto.generator.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
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

    /**
     * return max item coverage
     * @param coverage
     * @return
     */
    public int getCoverageMaxItem(List<List<String>> coverage){
        List<Integer> numberItems = new ArrayList<>();
        coverage.forEach(cov -> {
            cov.forEach(itm -> {
                List<String> itms = Arrays.stream(itm.split("\\s")).filter(s-> !s.trim().equals("")).collect(Collectors.toList());
                itms.forEach(r -> {numberItems.add(Integer.valueOf(r));});
            });
        });
        Optional<Integer> max = numberItems
                .stream()
                .reduce(Integer::max);
        return max.get();
    }

    public String replaceCoverageItemsWithNumbers(String items,List<String> numbers,String SEPARATOR){
        List<Integer> integers = convertAsInteger(items);
        StringBuilder result = new StringBuilder();
        integers.forEach(in -> result.append(numbers.get(in-1)).append(SEPARATOR));
        return result.toString();
    }

    public List<Integer> convertAsInteger(String item){
        List<Integer> numberItems = new ArrayList<>();
        List<String> itms = Arrays.stream(item.split("\\s")).filter(s-> !s.trim().equals("")).collect(Collectors.toList());
        itms.forEach(r -> {numberItems.add(Integer.valueOf(r));});
        return numberItems;
    }

}
