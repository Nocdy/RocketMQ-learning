package com.nocdy.rocketmq.rocketmqdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author Nocdy
 * @description TODO 统一返回结果
 * @date 2022/7/13 22:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Result<T> {
    private T data;
    private int code;
    private String message;

    public Result(int code,String message){
        this(null,code,message);
    }

}
