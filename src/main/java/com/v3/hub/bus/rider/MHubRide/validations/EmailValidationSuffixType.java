package com.v3.hub.bus.rider.MHubRide.validations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;



@Target({ElementType.FIELD, ElementType.TYPE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailSuffixType.class)
public @interface EmailValidationSuffixType {

    String message() default "chaEmail suffix should only be @gmail.com";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
