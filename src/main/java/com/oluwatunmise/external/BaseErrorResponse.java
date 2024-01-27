package com.oluwatunmise.external;

import lombok.Data;

@Data
public class BaseErrorResponse {
  String message;
  GenerateOTPValidationError errors;
}
