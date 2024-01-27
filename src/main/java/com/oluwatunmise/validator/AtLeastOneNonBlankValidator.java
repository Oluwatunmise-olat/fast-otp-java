package com.oluwatunmise.validator;

import com.oluwatunmise.annotations.AtLeastOneNonBlank;
import com.oluwatunmise.external.GenerateOTP;
import com.oluwatunmise.external.OTPDelivery;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class AtLeastOneNonBlankValidator implements ConstraintValidator<AtLeastOneNonBlank, GenerateOTP> {
  @Override
  public boolean isValid(GenerateOTP fastOTP, ConstraintValidatorContext constraintValidatorContext) {
    if (fastOTP == null) return false;

    return isAtLeastOneNonBlank(fastOTP.getDelivery());
  }

  private boolean isAtLeastOneNonBlank(OTPDelivery fastOTPDelivery) {
    Boolean atLeastOneNonBlank = false;

    for (Field field : fastOTPDelivery.getClass().getDeclaredFields()) {
      if (!field.getName().isBlank()) {
        atLeastOneNonBlank = true;
        break;
      };
    }

    return atLeastOneNonBlank;
  }
}
