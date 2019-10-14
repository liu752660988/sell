package com.etoak.sell.service.impl;

import com.etoak.sell.dataobject.ProductInfo;
import com.etoak.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 16:57 2018/12/3
 * @ Description：ProductServiceImplTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne("1111");
        Assert.assertEquals("1111",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productService.findUpAll();
        Assert.assertNotEquals(0,result.size());
    }

    @Test
    public void findAll() {
        PageRequest pageable = new PageRequest(0,2);
        Page<ProductInfo> result = productService.findAll(pageable);
        System.out.println(result.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1112");
        productInfo.setProductName("肉夹馍");
        productInfo.setProductPrice(new BigDecimal(5.0));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("很好吃哦");
        productInfo.setProductIcon("http://XXX.img");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(0);
        ProductInfo result = productService.save(productInfo);
        Assert.assertEquals("1112",result.getProductId());
    }
}