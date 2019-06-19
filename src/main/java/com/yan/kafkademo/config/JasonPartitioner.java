package com.yan.kafkademo.config;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

import java.util.Map;

import static com.yan.kafkademo.constant.KafkaConstants.numPartitions;

/**
 * <p>Title:JasonPartitioner </p>
 * <p>Description:在发送一条消息时，可以指定这条消息的key，Producer根据这个key和Partition机制来判断应该将这条消息发送到哪个Parition。</p>
 * Created with IntelliJ IDEA.
 * User: qxy
 * Date: 2019/6/19
 * Time: 16:08
 */
@Slf4j
public class JasonPartitioner<T> implements Partitioner {


    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {

        int partition = 0;
        try {
            partition = Math.abs(key.hashCode() % numPartitions);
        } catch (Exception e) {
            log.error("====分配partition失败",e);
            return partition;
        }

        log.info("partition: {}" , partition);
        return partition;

    }

    @Override
    public void close() {
        System.out.println("=====我是关闭====");
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
