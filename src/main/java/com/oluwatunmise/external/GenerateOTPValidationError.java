package com.oluwatunmise.external;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class GenerateOTPValidationError {
  List<String> delivery;
  List<String> identifier;
  @SerializedName("token_length")
  List<String> tokenLength;
  List<String> type;
  List<String> validity;
}
