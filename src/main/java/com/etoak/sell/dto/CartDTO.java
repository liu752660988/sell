package com.etoak.sell.dto;

import lombok.Data;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 13:33 2018/12/4
 * @ Description：购物车
 */
@Data
public class CartDTO {

    /** 商品ID. */
    private String productId;

    /** 商品数量. */
    private Integer pruductQuantity;

    public CartDTO(String productId, Integer pruductQuantity) {
        this.productId = productId;
        this.pruductQuantity = pruductQuantity;
    }
}
