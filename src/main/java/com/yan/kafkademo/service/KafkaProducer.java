package com.yan.kafkademo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Slf4j
@Component
public class KafkaProducer {
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String topic, String message,String key){
        ProducerRecord<String, String> producerRecord = new ProducerRecord(topic, key, message);
       ListenableFuture<SendResult<String,String>> sender = kafkaTemplate.send(producerRecord);

       sender.addCallback( (t)->{},(e)->log.error("===========发送失败",e));
    }
}