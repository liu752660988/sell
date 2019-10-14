package com.etoak.sell.enums;

import lombok.Getter;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 15:06 2018/12/3
 * @ Description：商品状态
 */
@Getter
public enum  ProductStatusEnum {

    UP(0, "在架商品"),
    DOWN(1, "下架商品"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }
}
