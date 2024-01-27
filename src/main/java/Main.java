import com.oluwatunmise.FastOTP;
import com.oluwatunmise.external.GenerateOTP;
import com.oluwatunmise.external.OTPDelivery;

/***
 * TODO: Clear and write actual unittest
 */
public class Main {
  public static void main(String[] args){
    FastOTP fastOTP = new FastOTP("xxx_xxx");
    OTPDelivery delivery = new OTPDelivery("no-reply@gmail.com");
    GenerateOTP payload = new GenerateOTP(10, 6, "numeric", "oo_", delivery);

    try {
      String resp = fastOTP.GenerateOTP(payload);
      System.out.println(resp);
    } catch (Exception e) {
      System.out.println("....");
    }
  }
}
