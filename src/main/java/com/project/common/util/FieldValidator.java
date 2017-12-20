package com.project.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldValidator {

    private static final String EMPTY = "";
    private static final String SPACE = " ";

    private FieldValidator() { }

    public static boolean validate(String text) {
        if (text.equals(EMPTY) || text.equals(SPACE)) {
            return false;
        }

        Pattern pattern = Pattern.compile("[^a-z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        return !matcher.find();
    }

}
