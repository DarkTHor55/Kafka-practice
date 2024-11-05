package com.kafka.consumer.Service;

import com.kafka.consumer.Entity.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class KafkaMessageListener {
    Logger logger = LoggerFactory.getLogger(KafkaMessageListener.class);
//    @KafkaListener(topics = "bittu-2-topic",groupId = "b2-id")
//    public void consume1(String message) {
//        logger.info("Consumer1 consume message : " + message);
//    }
//    @KafkaListener(topics = "bittu-2-topic",groupId = "b2-id")
//    public void consume2(String message) {
//        logger.info("Consumer2 consume message : " + message);
//    }
//    @KafkaListener(topics = "bittu-2-topic",groupId = "b2-id")
//    public void consume3(String message) {
//        logger.info("Consumer3 consume message : " + message);
//    }
    @KafkaListener(topics = "bittu-topic", groupId = "my-group")
    public void listen(Customer customer) {
        try {
            // Process the message
            System.out.println("Received message: " + customer);
        } catch (Exception e) {
            // Log and handle exceptions
            System.err.println("Error processing message: " + customer);
            e.printStackTrace();
        }
    }
}
