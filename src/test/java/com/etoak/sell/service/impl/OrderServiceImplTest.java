package com.etoak.sell.service.impl;

import com.etoak.sell.dataobject.OrderDetail;
import com.etoak.sell.dto.CartDTO;
import com.etoak.sell.dto.OrderDTO;
import com.etoak.sell.enums.OrderStatusEnum;
import com.etoak.sell.enums.PayStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 13:54 2018/12/4
 * @ Description：OrderServiceImplTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "58585858";
    private final String ORDER_ID = "1543904760716969270";
    @Test
    public void create() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("小木木");
        orderDTO.setBuyerPhone("15858585858");
        orderDTO.setBuyerAddress("菏泽");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> cartDTOList = new ArrayList<>();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("1111");
        orderDetail.setProductQuantity(1);

        OrderDetail orderDetail2 = new OrderDetail();
        orderDetail2.setProductId("1113");
        orderDetail2.setProductQuantity(1);

        cartDTOList.add(orderDetail);
        cartDTOList.add(orderDetail2);
        orderDTO.setOrderDetailList(cartDTOList);
        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}", result);
        Assert.assertNotNull(result);
    }

    @Test
    public void findOne() {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【通过orderId查询某个订单】 result={},orderId={}", result, ORDER_ID);
        Assert.assertNotNull(result);
    }

    @Test
    public void findList() {
        PageRequest request = new PageRequest(0, 2);
        Page<OrderDTO> orderDTOPage = orderService.findList(BUYER_OPENID, request);
        log.info("【通过buyerId查询此人订单列表】 orderDTOPage={}", orderDTOPage);
        Assert.assertNotNull(orderDTOPage);
    }

    @Test
    public void cancel() {
        OrderDTO orderDTO = orderService.findOne("1543991684382886519");
        OrderDTO result = orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    public void finish() {
        OrderDTO orderDTO = orderService.findOne("1543991766515697989");
        OrderDTO result = orderService.finish(orderDTO);
        Assert.assertEquals(OrderStatusEnum.FINISH.getCode(), result.getOrderStatus());
    }

    @Test
    public void paid() {
        OrderDTO orderDTO = orderService.findOne("1543991936856941692");
        OrderDTO result = orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }

    @Test
    public void list(){
        PageRequest request = PageRequest.of(0,10);
        Page<OrderDTO> orderDTOPage = orderService.findList(request);
        log.info("【查询订单列表】 orderDTOPage={}", orderDTOPage);
        Assert.assertTrue("查询所有的订单列表", orderDTOPage.getTotalElements() > 0);
    }
}