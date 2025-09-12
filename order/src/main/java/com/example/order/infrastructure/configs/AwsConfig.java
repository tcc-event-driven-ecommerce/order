package com.example.order.infrastructure.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.SnsClientBuilder;

@Configuration
public class AwsConfig {

    @Bean
    public SnsClient snsClient(){
        return SnsClient.builder()
                .region(Region.US_EAST_1)
                .build();
    }


}
