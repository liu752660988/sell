package com.etoak.sell.service.impl;

import com.etoak.sell.dto.OrderDTO;
import com.etoak.sell.service.OrderService;
import com.etoak.sell.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 17:08 2019/4/8
 * @ Description：
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PushMessageService pushMessageService;


    @Test
    public void orderStatus() throws Exception{
        OrderDTO orderDTO = orderService.findOne("1543904760716969270");
        pushMessageService.orderStatus(orderDTO);
    }
}