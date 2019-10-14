package com.etoak.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 19:17 2018/12/3
 * @ Description：商品详情
 */
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = 7070638103979192841L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
