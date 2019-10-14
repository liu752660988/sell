package com.etoak.sell.exception;

import com.etoak.sell.enums.ResultEnum;
import lombok.Getter;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 9:07 2018/12/4
 * @ Description：异常处理
 */
@Getter
public class SellException extends RuntimeException{

    private Integer code;

    public SellException(ResultEnum resultEnum){
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
