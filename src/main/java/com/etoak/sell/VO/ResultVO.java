package com.etoak.sell.VO;

import lombok.Data;

import java.io.Serializable;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 18:57 2018/12/3
 * @ Description：http请求返回的最外层对象
 */
@Data
public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = -3254218952861895588L;

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 返回内容. */
    private T data;
}
