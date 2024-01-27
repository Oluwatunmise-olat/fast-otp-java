package com.oluwatunmise;

import com.google.gson.Gson;
import com.oluwatunmise.external.GenerateOTP;
import com.oluwatunmise.external.FastOTPHttpClient;
import com.oluwatunmise.external.ValidateOTP;
import lombok.*;

import java.net.http.HttpResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FastOTP {
  private String apiKey;

  @Getter(AccessLevel.NONE)
  private final FastOTPHttpClient apiClient = new FastOTPHttpClient();

  public String GenerateOTP(GenerateOTP payload) throws Exception {
    String stringifiedPayload = new Gson().toJson(payload);
    HttpResponse<String> response = apiClient.sendPostRequest("/generate", stringifiedPayload, apiKey);

    return response.body();
  }

  public String ValidateOTP(ValidateOTP payload) throws Exception {
    String stringifiedPayload = new Gson().toJson(payload);
    HttpResponse<String> response = apiClient.sendPostRequest("/validate", stringifiedPayload, apiKey);

    return response.body();
  }

  public String GetOTP(String otpIdentifier) throws Exception {
    HttpResponse<String> response = apiClient.sendGetRequest(String.format("/%s", otpIdentifier), apiKey);

    return response.body();
  }
}