package com.nocdy.rocketmq.rocketmqdemo.service;

import com.nocdy.rocketmq.rocketmqdemo.dto.Result;

/**
 * @author Nocdy
 * @description TODO 生产者发送消息功能接口
 * @date 2022/7/13 22:46
 */
public interface ProducerService {

    /**
     * 单向发送消息
     * @param topic broker中对应的topic
     * @param tag topic 的二级分类
     * @param msg 消息
     * @return 返回发送结果
     */
    Result<Object> sendMessage(String topic, String tag, String msg);


    /**
     * 单同步发送消息
     * @param topic broker中对应的topic
     * @param tag topic 的二级分类
     * @param msg 消息
     * @return 返回发送结果
     */
     Result<Object> sendSyncMessage(String topic,String tag,String msg);

    /**
     * 异步发送消息
     * @param topic broker中对应的topic
     * @param tag topic 的二级分类
     * @param msg 消息
     * @return 返回发送结果
     */
     Result<Object> sendAsyncMessage(String topic,String tag,String msg);


}
