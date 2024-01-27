package com.oluwatunmise.annotations;

import com.oluwatunmise.validator.AtLeastOneNonBlankValidator;
import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Constraint(validatedBy = AtLeastOneNonBlankValidator.class)
public @interface AtLeastOneNonBlank {
  String message() default "At least one field must be provided";
}
