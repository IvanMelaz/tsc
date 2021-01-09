package com.lotto.generator.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Numbers {

    @Value("${app.numbers}")
    private String numbers;

    public List<String> getNumbers() {
        List<String> ints = Arrays.stream(numbers.split("-")).collect(Collectors.toList());
        return ints.stream().sorted().collect(Collectors.toList());
    }

}
