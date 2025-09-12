package com.example.order.infrastructure.events;

import com.example.order.core.domain.gateways.events.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Slf4j
@Service
public class SnsPublisher implements Publisher {

    private final SnsClient snsClient;

    private final String snsArn;

    public SnsPublisher(SnsClient snsClient, @Value("${sns.topic.arn}") String snsArn){
        this.snsClient = snsClient;
        this.snsArn = snsArn;
    }

    @Override
    public String publish(String message) {
        log.info("Inside publisher");
        PublishRequest request = PublishRequest.builder()
                .topicArn(snsArn)
                .message(message)
                .build();

        PublishResponse result = snsClient.publish(request);

        return result.messageId();
    }
}
