package com.oluwatunmise;

import com.oluwatunmise.external.*;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FastOTPTest {
  @org.junit.jupiter.api.Test
  void generateOTPGivenInValidApiKeyShouldReturnAnErrorResponse() throws Exception {
    GenerateOTP payload = new GenerateOTP(
        10,
        6,
        "numeric",
        "java_test",
        new OTPDelivery("java@no-reply.com")
    );
    FastOTP fastOTP = new FastOTP("test_api_key");

    BaseResponse response = fastOTP.GenerateOTP(payload);
    assertFalse(response.getSuccess());
    assertTrue(response.getData() instanceof BaseErrorResponse);
    assertNotNull(((BaseErrorResponse) response.getData()).getMessage());
    assertEquals(401, response.getStatusCode());
  }

  @org.junit.jupiter.api.Test
  void generateOTPGivenValidApiKeyOrPayloadShouldReturnASuccessResponse() throws Exception {
    GenerateOTP payload = new GenerateOTP(
        10,
        6,
        null,
        "java_test",
        new OTPDelivery("java@no-reply.com")
    );
    FastOTP fastOTPMock = mock(FastOTP.class);

    OTPSuccessResponseMeta otpSuccessResponseMeta = new OTPSuccessResponseMeta(
        "2024-01-19T00:24:06.000000Z",
        "2024-01-19T00:24:06.000000Z",
        "2024-01-19T17:04:06.000000Z",
        "9b202659-fee7-46ab-836b-cdd310c4f327",
        "oluwatunmise",
        "pending",
        "alpha_numeric",
        List.of(new String[]{"email"}),
        new OTPDelivery("hello@pluto.tech")
    );
    BaseSuccessResponse baseSuccessResponseResponse = new BaseSuccessResponse(otpSuccessResponseMeta);
    BaseResponse baseResponse = new BaseResponse(200, baseSuccessResponseResponse, true);

    when(fastOTPMock.GenerateOTP(payload)).thenReturn(baseResponse);

    BaseResponse response = fastOTPMock.GenerateOTP(payload);
    assertTrue(response.getSuccess());
    assertTrue(response.getData() instanceof BaseSuccessResponse);
    System.out.println(response.getData());
  }

  @org.junit.jupiter.api.Test
  void validateOTPGivenInvalidTokenShouldReturnAnErrorResponse() throws Exception {
    FastOTP fastOTPMock = mock(FastOTP.class);

    BaseErrorResponse baseErrorResponse = new BaseErrorResponse("Invalid token", null);
    BaseResponse baseResponse = new BaseResponse(406, baseErrorResponse, false);

    when(fastOTPMock.ValidateOTP(any())).thenReturn(baseResponse);

    BaseResponse response = fastOTPMock.ValidateOTP(new ValidateOTP("oluwatunmise", "<string>"));
    assertFalse(response.getSuccess());
    assertTrue(response.getData() instanceof BaseErrorResponse);
    assertNotNull(((BaseErrorResponse) response.getData()).getMessage());
    assertEquals(response.getStatusCode(), 406);
  }

  @org.junit.jupiter.api.Test
  void validateOTPGivenValidTokenShouldReturnASuccessResponse() throws Exception {
    FastOTP fastOTPMock = mock(FastOTP.class);

    OTPSuccessResponseMeta otpSuccessResponseMeta = new OTPSuccessResponseMeta(
        "2024-01-19T00:24:06.000000Z",
        "2024-01-19T00:24:06.000000Z",
        "2024-01-19T17:04:06.000000Z",
        "9b202659-fee7-46ab-836b-cdd310c4f327",
        "oluwatunmise",
        "pending",
        "alpha_numeric",
        List.of(new String[]{"email"}),
        new OTPDelivery("hello@pluto.tech")
    );
    BaseSuccessResponse baseSuccessResponseResponse = new BaseSuccessResponse(otpSuccessResponseMeta);
    BaseResponse baseResponse = new BaseResponse(200, baseSuccessResponseResponse, true);

    when(fastOTPMock.ValidateOTP(any())).thenReturn(baseResponse);

    BaseResponse response = fastOTPMock.ValidateOTP(new ValidateOTP("oluwatunmise", "TOKEN"));
    assertTrue(response.getSuccess());
    assertTrue(response.getData() instanceof BaseSuccessResponse);
    assertNotNull(response.getData());
    assertEquals(response.getStatusCode(), 200);
  }

  @org.junit.jupiter.api.Test
  void getOTPGivenInValidOTPIdentifierShouldReturnAnErrorResponse() throws Exception {
    FastOTP fastOTPMock = mock(FastOTP.class);

    BaseErrorResponse baseErrorResponse = new BaseErrorResponse("Otp not found", null);
    BaseResponse baseResponse = new BaseResponse(404, baseErrorResponse, false);

    when(fastOTPMock.GetOTP(eq("matrix"))).thenReturn(baseResponse);

    BaseResponse response = fastOTPMock.GetOTP("matrix");
    assertFalse(response.getSuccess());
    assertTrue(response.getData() instanceof BaseErrorResponse);
    assertNotNull(((BaseErrorResponse) response.getData()).getMessage());
  }

  @org.junit.jupiter.api.Test
  void getOTPGivenValidOTPIdentifierShouldReturnASuccessResponse() throws Exception {
    FastOTP fastOTPMock = mock(FastOTP.class);

    OTPSuccessResponseMeta otpSuccessResponseMeta = new OTPSuccessResponseMeta(
        "2024-01-19T00:24:06.000000Z",
        "2024-01-19T00:24:06.000000Z",
        "2024-01-19T17:04:06.000000Z",
        "9b202659-fee7-46ab-836b-cdd310c4f327",
        "oluwatunmise",
        "pending",
        "alpha_numeric",
        List.of(new String[]{"email"}),
        new OTPDelivery("hello@pluto.tech")
    );
    BaseSuccessResponse baseSuccessResponseResponse = new BaseSuccessResponse(otpSuccessResponseMeta);
    BaseResponse baseResponse = new BaseResponse(200, baseSuccessResponseResponse, true);

    when(fastOTPMock.GetOTP(eq("matrix"))).thenReturn(baseResponse);

    BaseResponse response = fastOTPMock.GetOTP("matrix");
    assertTrue(response.getSuccess());
    assertTrue(response.getData() instanceof BaseSuccessResponse);
    assertNotNull(response.getData());
  }

}