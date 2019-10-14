package com.etoak.sell.form;

import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 16:06 2018/12/6
 * @ Description：
 */
@Data
public class ProductForm {
    /** 商品ID. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 商品单价. */
    private BigDecimal productPrice;

    /** 商品库存. */
    private Integer productStock;

    /** 商品描述. */
    private String productDescription;

    /** 商品图片. */
    private String productIcon;

    /** 商品类目编号. */
    private Integer categoryType;
}
