package com.lotto.test;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {

    @Test
    public void regExpTest() {
        String search = "search for inside String \n\r" +
                "$accountNumber for replacement";
        Pattern pattern = Pattern.compile("\\$accountNumber");
        Matcher matcher = pattern.matcher(search);
        System.out.println("search result: " + !matcher.find());

    }
}
