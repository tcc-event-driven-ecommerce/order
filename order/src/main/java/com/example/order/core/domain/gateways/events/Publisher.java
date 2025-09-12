package com.example.order.core.domain.gateways.events;

public interface Publisher {
    String publish(String message);
}
