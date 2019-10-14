package com.etoak.sell.enums;

import lombok.Getter;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 20:40 2018/12/3
 * @ Description：订单状态
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{

    NEW(0, "新订单"),
    FINISH(1, "已完成"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
    /*public static OrderStatusEnum getOrderStatusEnum(Integer code){
        for (OrderStatusEnum orderStatusEnum:OrderStatusEnum.values()){
            if (orderStatusEnum.getCode().equals(code)){
                return orderStatusEnum;
            }
        }
        return null;
    }*/
}
