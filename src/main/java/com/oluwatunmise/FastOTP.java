package com.oluwatunmise;

import com.google.gson.Gson;
import com.oluwatunmise.external.*;
import lombok.*;

import java.lang.reflect.Type;
import java.net.http.HttpResponse;

@Data
@AllArgsConstructor
public class FastOTP {
  private String apiKey;

  @Getter(AccessLevel.NONE)
  private final FastOTPHttpClient apiClient = new FastOTPHttpClient();

  public BaseResponse GenerateOTP(GenerateOTP payload) throws Exception {
    String stringifiedPayload = new Gson().toJson(payload);
    HttpResponse<String> response = apiClient.sendPostRequest("/generate", stringifiedPayload, apiKey);

    return formatResponse(response);
  }

  public BaseResponse ValidateOTP(ValidateOTP payload) throws Exception {
    String stringifiedPayload = new Gson().toJson(payload);
    HttpResponse<String> response = apiClient.sendPostRequest("/validate", stringifiedPayload, apiKey);
    return formatResponse(response);
  }

  public BaseResponse GetOTP(String otpIdentifier) throws Exception {
    HttpResponse<String> response = apiClient.sendGetRequest(String.format("/%s", otpIdentifier), apiKey);
    return formatResponse(response);
  }

  private <T> BaseResponse<T> formatResponse(HttpResponse<String> httpResponse) {
    Boolean success  = httpResponse.statusCode() >= 200 && httpResponse.statusCode() <= 300 ? true : false;
    Type responseType = success ? BaseSuccessResponse.class : BaseErrorResponse.class;

    return new BaseResponse(
        httpResponse.statusCode(),
        new Gson().fromJson(httpResponse.body(), responseType),
        success
    );
  }
}