package com.etoak.sell.repository;

import com.etoak.sell.dataobject.OrderDetail;
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
 * @ Date       ：Created in 21:13 2018/12/3
 * @ Description：OrderDetailRepositoryTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1112");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("1112");
        orderDetail.setProductName("肉夹馍");
        orderDetail.setProductPrice(new BigDecimal(5.0));
        orderDetail.setProductQuantity(5);
        orderDetail.setProductIcon("http://XXX.img");
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> orderDetailList = repository.findByOrderId("123456");
        Assert.assertNotEquals(0,orderDetailList.size());
    }
}