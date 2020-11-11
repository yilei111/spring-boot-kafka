package com.kafka.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
 * 消费者端消费消息
 * @className ConsumerMessageHandler
 * @author yl
 * @date 2020/7/23 21:57
 * @version 1.0
 **/
@Component
public class ConsumerMessageHandler {

    @KafkaListener(topics = {"kafkaTopic1"})
    public void listen(ConsumerRecord<?, ?> record){
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object object = kafkaMessage.get();
            System.out.println("---->"+record);
            System.out.println("消费者端消费消息：---->"+object.toString());
        }
    }
}
