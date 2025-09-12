package com.example.order.infrastructure.api;

import com.example.order.infrastructure.events.SnsPublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {

    private final SnsPublisher publisher;

    @PostMapping
    public String createOrder(@RequestParam("message") String message){
        log.info("In the controller");
        return publisher.publish(message);
    }

}
