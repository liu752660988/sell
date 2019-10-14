package com.etoak.sell.service;

import com.etoak.sell.dto.OrderDTO;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 10:59 2018/12/5
 * @ Description：
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);
    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
