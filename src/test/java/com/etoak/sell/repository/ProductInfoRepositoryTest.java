package com.etoak.sell.repository;

import com.etoak.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:48 2018/12/3
 * @ Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findByProductStatus() {

        List<ProductInfo> result = repository.findByProductStatus(0);
        Assert.assertEquals(1,result.size());
    }

    @Test
    public void saveTest(){

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("1111");
        productInfo.setProductName("驴肉火烧");
        productInfo.setProductPrice(new BigDecimal(4.5));
        productInfo.setProductStock(50);
        productInfo.setProductDescription("很好吃哦");
        productInfo.setProductIcon("http://XXX.img");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(0);
        ProductInfo result = repository.save(productInfo);
        Assert.assertEquals("1111", result.getProductId());
    }
}