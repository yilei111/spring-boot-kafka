package com.kafka.producer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.UUID;

/**
 * 生产者消息发送控制层
 *
 * @author yl
 * @version 1.0
 * @className SendController
 * @date 2020/7/23 21:55
 **/
@RestController
@RequestMapping("/kafka")
public class ProducerController {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping(value = "/send")
    public String send() {
        Message message = new Message();
        message.setId(UUID.randomUUID().toString());
        message.setMsg("kakfa消息内容");
        message.setSendTime(new Date());
        System.out.println("消息发送成功==" + message.toString());
        kafkaTemplate.send("kafkaTopic1", JSONObject.toJSONString(message));
        return "消息发送成功！";
    }
}
