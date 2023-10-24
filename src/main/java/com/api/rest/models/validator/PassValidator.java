package com.api.rest.models.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassValidator {

    private Pattern pattern;
    private Matcher matcher;
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,20}$";
    public PassValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }
    public boolean isValid(final String password) {
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
