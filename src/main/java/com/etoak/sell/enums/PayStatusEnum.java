package com.etoak.sell.enums;

import lombok.Getter;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 20:45 2018/12/3
 * @ Description：支付状态
 */
@Getter
public enum PayStatusEnum implements CodeEnum{

    WAIT(0, "未支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
