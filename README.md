# FastOTP (FastOTP-Java-Library)
FastOTP-Java-Library facilitates quick and easy development and integration of Java based applications with the [FASTOTP API](https://fastotp.co/).

Visit [FastOTP](https://fastotp.co/) to get your api key and setup an account.
[FastOTP Documentation](https://docs.fastotp.co/introduction)

- **Contributors:** **Oluwatunmise Olatunbosun**

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation-jar-file)
- [Usage](#usage)
    - [Generate OTP](#generate-otp)
    - [Validate OTP](#validate-otp)
    - [Get OTP](#get-otp)
    - [Response Details](#response-details)
- [Contributing](#contributing)
- [License](#license)

# Getting Started

### Prerequisites

- Java 17 or later
- Maven (for building and testing)

### Installation (Jar file)
To use Java-FastOtp in your project, follow these steps:
1. Add the following dependency to your project's `pom.xml`:
```xml
<dependencies>
  /** Your Other Dependencies */
  <dependency>
    <groupId>com.oluwatunmise</groupId>
    <artifactId>java-fastotp-library-1.0</artifactId>
    <version>1.0</version>
  </dependency>
</dependencies>
```
2. Configure the repository in your pom.xml:
```xml
<distributionManagement>
  <repository>
    <id>github</id>
    <name>Github Oluwatunmise-olat FastOtp Library</name>
    <url>https://maven.pkg.github.com/Oluwatunmise-olat/fast-otp-java</url>
  </repository>
</distributionManagement>
```
3. Build Project
```shell
mvn clean install
```
4. Test
```shell
mvn test
```

### Jar
Download latest Java-FastOTP Library jar file from [here](https://github.com/Oluwatunmise-olat/fast-otp-java/releases/latest)

### Usage
### Generate OTP

```java
import com.oluwatunmise.FastOTP;
import com.oluwatunmise.external.*;

public class Main {
  public static void main(String[] args) throws Exception {
    String apiKey = "xxx_xxx";
    FastOTP fastOTP = new FastOTP(apiKey);
    
    OTPDelivery otpDelivery = new OTPDelivery("java@no-reply.com");
    GenerateOTP generateOTP = new GenerateOTP(
        10, 
        6, 
        "alpha_numeric",
        "java_test", 
        otpDelivery
    );
    BaseResponse baseResponse = fastOTP.GenerateOTP(generateOTP);
    
    if (baseResponse.getSuccess()) {
      BaseSuccessResponse baseSuccessResponse = (BaseSuccessResponse) baseResponse.getData();
      System.out.println(baseSuccessResponse.getOtp().getDeliveryDetails());
      System.out.println(baseSuccessResponse.getOtp().getIdentifier());
    }else {
      BaseErrorResponse baseErrorResponse = (BaseErrorResponse) baseResponse.getData();
      System.out.println(baseErrorResponse.getErrors());
      System.out.println(baseErrorResponse.getMessage());
    }
  }
}
```
### Validate OTP
```java
import com.oluwatunmise.FastOTP;
import com.oluwatunmise.external.BaseErrorResponse;
import com.oluwatunmise.external.BaseResponse;
import com.oluwatunmise.external.BaseSuccessResponse;
import com.oluwatunmise.external.ValidateOTP;

public class Main {
  public static void main(String[] args) throws Exception {
    String apiKey = "xxx_xxx";
    FastOTP fastOTP = new FastOTP(apiKey);

    ValidateOTP validateOTP = new ValidateOTP("your_identifier", "4567");
    BaseResponse baseResponse = fastOTP.ValidateOTP(validateOTP);
    
    if (baseResponse.getSuccess()) {
      BaseSuccessResponse baseSuccessResponse = (BaseSuccessResponse) baseResponse.getData();
      System.out.println(baseSuccessResponse.getOtp().getDeliveryDetails());
      System.out.println(baseSuccessResponse.getOtp().getIdentifier());
    }else {
      BaseErrorResponse baseErrorResponse = (BaseErrorResponse) baseResponse.getData();
      System.out.println(baseErrorResponse.getErrors());
      System.out.println(baseErrorResponse.getMessage());
    }
  }
}
```
### Get OTP
```java
import com.oluwatunmise.FastOTP;
import com.oluwatunmise.external.BaseResponse;

public class Main {
  public static void main(String[] args) throws Exception {
    String apiKey = "xxx_xxx";
    FastOTP fastOTP = new FastOTP(apiKey);
    BaseResponse baseResponse = fastOTP.GetOTP("matrix");

    System.out.println(baseResponse);
    System.out.println(baseResponse.getStatusCode());
    System.out.println(baseResponse.getData());
    System.out.println(baseResponse.getSuccess());
  }
}
```

### Response Details
The `BaseResponse` object provides the following information:

- `statusCode`: HTTP status code received from fast otp.
- `success`: Indicates whether the response falls within the 200-300 success range.
- `data`: The actual data returned by fast otp.

## License

The MIT License (MIT). Please see [License File](LICENSE.md) for more information.

## Contributing
Contributions are welcome! If you find any issues or have enhancements, feel free to open a [GitHub issue](https://github.com/Oluwatunmise-olat/fast-otp-java/issues) or submit a [pull request](https://github.com/Oluwatunmise-olat/fast-otp-java/pulls).