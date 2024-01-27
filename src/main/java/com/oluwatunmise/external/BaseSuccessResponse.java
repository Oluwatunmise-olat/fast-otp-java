package com.oluwatunmise.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseSuccessResponse {
  OTPSuccessResponseMeta otp;
}
