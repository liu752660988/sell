package com.etoak.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 19:14 2018/12/3
 * @ Description：商品(包含类目)
 */
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -929247694228855343L;

    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    private List<ProductInfoVO> foods;

}
