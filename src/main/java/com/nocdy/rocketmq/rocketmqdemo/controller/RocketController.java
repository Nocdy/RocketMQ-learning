package com.nocdy.rocketmq.rocketmqdemo.controller;

import com.nocdy.rocketmq.rocketmqdemo.constans.Constant;
import com.nocdy.rocketmq.rocketmqdemo.dto.Result;
import com.nocdy.rocketmq.rocketmqdemo.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Nocdy
 * @description TODO 发送消息控制类
 * @date 2022/7/13 23:40
 */
@RestController
@Slf4j
@RequiredArgsConstructor
public class RocketController {

    private final ProducerService producerService;

    @GetMapping("/sendMsg/{msg}")
    public Result<Object> sendMessage(@PathVariable("msg")String msg){
        return producerService.sendMessage(Constant.TOPIC,Constant.TAG,msg);
    }

    @GetMapping("/sendSyncMsg/{msg}")
    public Result<Object> sendSyncMessage(@PathVariable("msg")String msg){
        return producerService.sendSyncMessage(Constant.TOPIC,Constant.TAG,msg);
    }

    @GetMapping("/sendAsyncMsg/{msg}")
    public Result<Object> sendAsyncMessage(@PathVariable("msg")String msg){
        return producerService.sendAsyncMessage(Constant.TOPIC,Constant.TAG,msg);
    }

}
