package com.yu.api_client;

import com.yu.api_client.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("api.clint")
@ComponentScan
public class ApiClintConfig {

    private String accessKey;

    private String secretKey;

    private String url;

    @Bean
    public ApiClient ApiClient() {
        return new ApiClient(accessKey,secretKey,url);
    }

}