package com.kafka.producer.Service;

import com.kafka.producer.Entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.lang.*;

@Component
public class KafkaMessageProducer {
    @Autowired
    private KafkaTemplate<String , Object> template;

    public void sendMessageByKafka(String message){
        for (int i = 0; i < 10000; i++) {
            CompletableFuture<SendResult<String,Object>> futre=template.send("bittu-2-topic", message);

        }



    } public void sendEventByKafka(Customer customer){
        try {
            CompletableFuture<SendResult<String,Object>> futre=template.send("bittu-topic", customer);

        }catch (Exception e) {
            System.out.println("Error sending event");
        }
    }

}
