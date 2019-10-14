package com.etoak.sell.service;

import com.etoak.sell.dto.OrderDTO;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 13:51 2019/4/2
 * @ Description： 支付
 */
public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

    RefundResponse refund(OrderDTO orderDTO);
}
