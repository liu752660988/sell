package com.etoak.sell.dataobject;

import com.etoak.sell.enums.ProductStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:36 2018/12/3
 * @ Description：商品
 */
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = -2834674660317203060L;
    /** 商品ID. */
    @Id
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

    /** 商品状态. 0正常 1下架*/
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 商品类目编号. */
    private Integer categoryType;

    /** 创建时间. */
    private Date createTime;

    /** 修改时间. */
    private Date updateTime;
}
