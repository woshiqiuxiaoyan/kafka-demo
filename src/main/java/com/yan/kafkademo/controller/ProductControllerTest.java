package com.yan.kafkademo.controller;

import com.yan.kafkademo.constant.KafkaConstants;
import com.yan.kafkademo.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>Title:ProductControllerTest </p>
 * <p>Description:</p>
 * Created with IntelliJ IDEA.
 * User: qxy
 * Date: 2019/6/19
 * Time: 9:37
 */
@RestController
public class ProductControllerTest {

    @Autowired
    private KafkaProducer producer;

    @Value("#{'${kafka.listener.topics}'.split(',')}")
    private List<String> topics;

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String produceTest(@RequestParam("value") String value){

        for(int i=0;i<100;i++) {
            int tmp = i%topics.size();
            producer.sendMessage(topics.get(0), value,"key-"+i);
        }
        return value;
    }


}
