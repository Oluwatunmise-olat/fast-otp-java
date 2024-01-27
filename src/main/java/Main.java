import com.oluwatunmise.FastOTP;
import com.oluwatunmise.external.*;

/***
 * TODO: Clear and write actual unittest
 */
public class Main {
  public static void main(String[] args) {
    FastOTP fastOTP = new FastOTP("xxx_xxx");
    OTPDelivery delivery = new OTPDelivery("no-reply@gmail.com");
    GenerateOTP payload = new GenerateOTP(10, 6, "numeric", "oo_", delivery);

    try {
      BaseResponse resp = fastOTP.GenerateOTP(payload);
      if (resp.getSuccess()) {
        BaseSuccessResponse generateOTPSuccessResponse = (BaseSuccessResponse) resp.getData();
        System.out.println(generateOTPSuccessResponse.getOtp().getExpiresAt());
      }else {
        BaseErrorResponse baseErrorResponse = (BaseErrorResponse) resp.getData();
        System.out.println(baseErrorResponse.getErrors());
      }
    } catch (Exception e) {
      e.getStackTrace();
    }
  }
}
