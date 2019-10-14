package com.etoak.sell.service.impl;

import com.etoak.sell.dto.OrderDTO;
import com.etoak.sell.service.PayService;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.model.RefundResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 13:53 2019/4/2
 * @ Description：
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {


    @Override
    public PayResponse create(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public PayResponse notify(String notifyData) {
        return null;
    }

    @Override
    public RefundResponse refund(OrderDTO orderDTO) {
        return null;
    }
}

