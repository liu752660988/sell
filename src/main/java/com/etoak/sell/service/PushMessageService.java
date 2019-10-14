package com.etoak.sell.service;

import com.etoak.sell.dto.OrderDTO;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 13:10 2019/4/8
 * @ Description：消息推送
 */
public interface PushMessageService {

    /**
     * 订单状态变更消息
     * @param orderDTO
     */
    void orderStatus(OrderDTO orderDTO);
}
