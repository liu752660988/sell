package com.etoak.sell.repository;

import com.etoak.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 20:57 2018/12/3
 * @ Description：
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
