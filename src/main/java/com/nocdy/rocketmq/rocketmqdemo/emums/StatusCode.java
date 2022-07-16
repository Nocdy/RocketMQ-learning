package com.nocdy.rocketmq.rocketmqdemo.emums;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Nocdy
 * @description TODO 业务状态码枚举类
 * @date 2022/7/13 23:17
 */
@Getter
public enum StatusCode {

    //描述发送消息状态

    SEND_FAILURE(5001,"发送消息失败"),
    SEND_SUCCESS(2001,"发送消息成功"),
    SEND_MESSAGE(2002,"单向发送消息"),
    SEND_ASYNC_MESSAGE(2003,"异步发送消息");

    private final int code;
    private final String message;

    StatusCode(int code, String message){
        this.message=message;
        this.code=code;
    }

}
