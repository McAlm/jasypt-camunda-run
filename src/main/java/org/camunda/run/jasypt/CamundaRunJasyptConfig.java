package org.camunda.run.jasypt;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@Configuration
@EnableEncryptableProperties
public class CamundaRunJasyptConfig {

    @Bean
    @ConfigurationProperties("jasypt.encryptor")
    public SimpleStringPBEConfig jasypConfig() {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        return config;
    }

    @Bean
    public StringEncryptor jasyptEncryptor() {
        // StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();  
        encryptor.setConfig(jasypConfig());
        return encryptor;
    }
}
