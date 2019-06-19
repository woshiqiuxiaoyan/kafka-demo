package com.yan.kafkademo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * <p>Title:TestConsumer </p>
 * <p>Description:</p>
 * Created with IntelliJ IDEA.
 * User: qxy
 * Date: 2019/6/19
 * Time: 14:48
 */
/*@Slf4j
@Service
public class TestConsumer implements AcknowledgingConsumerAwareMessageListener<String,String> {



    @Override
    public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment, Consumer<?, ?> consumer) {
        log.info("Before receiving:" + consumerRecord.toString());
        String value = consumerRecord.value();
//        MessageDto<FriendRelationDto> message = JSON.parseObject(value, new TypeReference<MessageDto<FriendRelationDto>>(){});
        try {
//            friendRelationService.process(message.getData());

            log.info("========消费都消费 : {}",value);
            acknowledgment.acknowledge();//提交offset

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/
