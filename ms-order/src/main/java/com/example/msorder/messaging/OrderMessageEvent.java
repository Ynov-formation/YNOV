package com.example.msorder.messaging;

import com.example.msorder.dto.CommandeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageEvent {

    @Autowired
    StreamBridge streamBridge;

    public void notifyCustomer(String topic, CommandeDto message) {
        streamBridge.send(topic, message);
    }
}
