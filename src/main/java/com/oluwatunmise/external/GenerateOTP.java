package com.oluwatunmise.external;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateOTP {
  Number validity;
  Number token_length;
  String type;
  String identifier;

  @Valid
  OTPDelivery delivery;
}


