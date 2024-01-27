package com.oluwatunmise.external;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseErrorResponse {
  String message;
  @Valid
  GenerateOTPValidationError errors;
}
