# FastOTP (FastOTP-Java-Library)
FastOTP-Java-Library facilitates quick and easy development and integration of Java based applications with the [FASTOTP API](https://fastotp.co/).

- **Contributors:** **Oluwatunmise Olatunbosun**

## Table of Contents

- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation-jar-file)
- [Usage](#usuage)
    - [Generate OTP](#generate-otp)
    - [Validate OTP](#validate-otp)
    - [Get OTP](#get-otp)
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
<dependency>
  <groupId>com.oluwatunmise.Java-FastOtp-Library-1.0</groupId>
  <artifactId>java-fastotp-library-1.0</artifactId>
  <version>1.0</version>
</dependency>
```
2. Make sure you have the necessary repositories configured in your pom.xml:
```xml
<repositories>
    <repository>
        <id>github</id>
        <name>Github Oluwatunmise-olat FastOtp Library</name>
        <url>https://maven.pkg.github.com/Oluwatunmise-olat/fast-otp-java</url>
    </repository>
</repositories>
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

### Usuage

### Generate OTP
### Validate OTP
### Get OTP

## License

The MIT License (MIT). Please see [License File](LICENSE.md) for more information.

## Contributing
Contributions are welcome! If you find any issues or have enhancements, feel free to open a [GitHub issue](https://github.com/Oluwatunmise-olat/fast-otp-java/issues) or submit a [pull request](https://github.com/Oluwatunmise-olat/fast-otp-java/pulls).