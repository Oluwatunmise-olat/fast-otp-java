package com.oluwatunmise.external;

import com.google.gson.annotations.SerializedName;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenerateOTP {
  Number validity;
  @SerializedName("token_length")
  Number tokenLength;
  String type;
  String identifier;
  @Valid
  OTPDelivery delivery;
}


