package com.yan.kafkademo.service;

import com.yan.kafkademo.constant.KafkaConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Listener {


//#{'${kafka.listener.topics}'.split(',')[0]}
    @KafkaListener(id="myListener",containerFactory = "kafkaListenerContainerFactory",topics =  {"#{'${kafka.listener.topics}'.split(',')[0]}"})
    public void listen(List<ConsumerRecord<String, String>> recordList, Acknowledgment acknowledgment) {


        try {
            recordList.forEach((record)->{
                log.info("kafka的topic: " +  record.topic());
                log.info("kafka的partition: " +  record.partition());
                log.info("kafka的key: " + record.key());
                log.info("kafka的value: " +  record.value());
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //手动提交
            acknowledgment.acknowledge();
        }

    }
}
