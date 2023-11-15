package com.v3.hub.bus.rider.MHubRide.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailSuffixType implements ConstraintValidator<EmailValidationSuffixType, String> {

    private static final String VALID_SUFFIX = "@gmail.com";

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
       return s.contains(VALID_SUFFIX);
    }
}
