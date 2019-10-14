package com.etoak.sell.service;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 11:25 2019/4/10
 * @ Description：
 */
public interface SecKillService {

    String querySecKillProductInfo(String productId);

    // 主要的秒杀逻辑
    void orderProductMockDiffUser(String productId);
}
