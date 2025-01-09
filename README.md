# Intro
This project demonstrates a bug in Spring Cloud Config Server, specifically in the decryption of plain text files.

For more about this feature, see the following documentation:
- [Encryption and Decryption](https://docs.spring.io/spring-cloud-config/reference/server/encryption-and-decryption.html)
- [Decrypting Plain Text](https://docs.spring.io/spring-cloud-config/reference/server/serving-binary-files.html#decrypting-plain-text)

# Running the Demo
`mvn test`

`ConfigServerTests.decryptsPlainTextResource` fails with the following cause:
```
Expecting actual:
  "foo={cipher}0512c71fc9294597e4b89d952fdb6f3b111831a0c1a631f7e48f5a8b2de2199a
"
not to contain:
  "{cipher}"
```
