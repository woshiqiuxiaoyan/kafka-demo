package com.yan.kafkademo;

import com.yan.kafkademo.constant.KafkaConstants;
import com.yan.kafkademo.service.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkademoApplicationTests {


    @Autowired
    private KafkaProducer producer;

    @Test
    public void contextLoads() {

        producer.sendMessage(KafkaConstants.MY_TOPIC,"woshiyandaye","key9");


    }

}
