package com.nocdy.rocketmq.rocketmqdemo.service.impl;

import com.nocdy.rocketmq.rocketmqdemo.dto.Result;
import com.nocdy.rocketmq.rocketmqdemo.emums.StatusCode;
import com.nocdy.rocketmq.rocketmqdemo.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author Nocdy
 * @description TODO 实习发送消息接口
 * @date 2022/7/13 23:00
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerServiceImpl implements ProducerService {


    private final RocketMQTemplate rocketmqTemplate;

    private Message<String> buildMessage(String msg){
        return  MessageBuilder.withPayload(msg).build();
    }

    private String setDestination(String topic,String tag){
        return StringUtils.hasLength(tag)?topic+":"+tag:topic;
    }

    @Override
    public Result<Object> sendMessage(String topic, String tag, String msg) {
        String destination=setDestination(topic,tag);
        Message<String> message=buildMessage(msg);
        rocketmqTemplate.send(destination,message);
        return new Result<>(StatusCode.SEND_MESSAGE.getCode(),
                StatusCode.SEND_MESSAGE.getMessage());
    }

    @Override
    public Result<Object> sendSyncMessage(String topic, String tag, String msg) {
        String destination=setDestination(topic,tag);
        Message<String> message=buildMessage(msg);
        SendResult sendResult=rocketmqTemplate.syncSend(destination,message);
        if(SendStatus.SEND_OK.equals(sendResult.getSendStatus())){
            return new Result<>(StatusCode.SEND_SUCCESS.getCode(),
                    StatusCode.SEND_SUCCESS.getMessage());
        }
        else{
            return new Result<>(sendResult.getSendStatus(),
                    StatusCode.SEND_FAILURE.getCode(),
                    StatusCode.SEND_FAILURE.getMessage());
        }
    }

    @Override
    public Result<Object> sendAsyncMessage(String topic, String tag, String msg) {
        String destination=setDestination(topic,tag);
        Message<String> message=buildMessage(msg);
        rocketmqTemplate.asyncSend(destination, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println(sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                throwable.printStackTrace();
            }
        });
        return new Result<>(StatusCode.SEND_ASYNC_MESSAGE.getCode(),
                StatusCode.SEND_ASYNC_MESSAGE.getMessage());
    }
}
