package com.kafka.producer.Controller;

import com.kafka.producer.Entity.Customer;
import com.kafka.producer.Service.KafkaMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/producer")
public class EventController {
    @Autowired
    private KafkaMessageProducer kafkaMessageProducer;

    @PostMapping("/send/{message}")
    public ResponseEntity<?> sendMessage(@PathVariable("message") String message){
        try {
            for (int i = 0; i < 1000; i++) {
                kafkaMessageProducer.sendMessageByKafka(message);
            }
            return ResponseEntity.ok("Message sent successfully");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to send message: " + e.getMessage());
        }

    }
    @PostMapping("/send")
    public ResponseEntity<?> sendEvent(@RequestBody Customer customer){
        try {
                kafkaMessageProducer.sendEventByKafka(customer);
            return ResponseEntity.ok("Message sent successfully");
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Failed to send message: " + e.getMessage());
        }

    }
}

