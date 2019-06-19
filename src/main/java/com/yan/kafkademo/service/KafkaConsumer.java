package com.yan.kafkademo.service;

import com.yan.kafkademo.constant.KafkaConstants;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
   /* @KafkaListener(topics = {KafkaConstants.MY_TOPIC})
    public void receiveMessage(ConsumerRecord<String,String> record){
        System.out.println("message :  " + record.value());
    }*/
}
