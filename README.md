# jasypt-camunda-run
Offers a ready to use lib to use jasypt within CamundaRun to encrypt properties

## build the project
```mvn clean package```

## encrypt a property
```java -jar camunda-run-jasypt-${version}-jar-with-dependencies.jar```

alternatively: run the main class Encrypt directly from your IDE

You'll need to enter the text to encrypt as well as a password.

## Usage in CamundaRun

Required dependencies in CamundaRun distro:
1. Download jasypt-spring-boot-3.0.4.jar from https://mvnrepository.com/artifact/com.github.ulisesbocchio/jasypt-spring-boot/3.0.4 
2. download jasypt-1.9.3.jar from https://mvnrepository.com/artifact/org.jasypt/jasypt/1.93

3. place the camunda-run-jasypt-${version}.jar along with dependencies from 1. and 2. into 
    ${camundaRunDir}/configuration/userLibs
4. add the following properties to camundaRun default.yml (resp. production.yml):
```
jasypt:
  encryptor:
    bean: jasyptEncryptor
    pool-size: 4
    password: ${YOUR_JASYPT_PASSWORD}
    algorithm: PBEWithMD5AndTripleDES 
```

Now enter your encrypted property in the yml file with ENC(...), e.g.
```
spring:
    datasource:
        password: ENC(YOUR_ENCRYPTED_DB_PASSWORD)
```