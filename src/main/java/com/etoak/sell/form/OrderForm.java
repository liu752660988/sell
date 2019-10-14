package com.etoak.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 18:44 2018/12/4
 * @ Description：接受前端的入参
 */
@Data
public class OrderForm {

    /** 买家姓名. */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家手机号. */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /** 买家地址. */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家微信ID. */
    @NotEmpty(message = "买家微信ID必填")
    private String openid;

    /** 购物车. */
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
