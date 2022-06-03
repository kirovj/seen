package com.github.kirovj.seen.utils;

import java.util.regex.Pattern;

public class Constants {

    private Constants() {
    }

    public static final Pattern LETTER_NUMBER = Pattern.compile("([A-Za-z]+)(\\d+)");
}
