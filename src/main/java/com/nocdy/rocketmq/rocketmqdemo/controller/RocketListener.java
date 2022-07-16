package com.nocdy.rocketmq.rocketmqdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.ExtRocketMQTemplateConfiguration;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author Nocdy
 * @description TODO 定义消息消费者，消费模式为顺序消费,消息模式为集群轮询模式
 * @date 2022/7/13 0:05
 */
@Component
@Slf4j
@RocketMQMessageListener(topic = "myTopic",consumeMode = ConsumeMode.ORDERLY,
        consumerGroup = "group01",
        messageModel = MessageModel.CLUSTERING)
public class RocketListener implements RocketMQListener<String> {


    @Override
    public void onMessage(String message) {
        System.out.println("收到消息:"+message);
    }
}
