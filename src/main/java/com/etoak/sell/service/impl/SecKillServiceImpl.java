package com.etoak.sell.service.impl;

import com.etoak.sell.exception.SellException;
import com.etoak.sell.service.RedisLock;
import com.etoak.sell.service.SecKillService;
import com.etoak.sell.util.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 11:28 2019/4/10
 * @ Description：
 */
@Service
public class SecKillServiceImpl implements SecKillService {

    private static final int TIMEOUT = 10 * 1000; // 超时时间10秒
    @Autowired
    private RedisLock redisLock;

    /**
     * 国庆活动，皮蛋粥特价，限量100000份
     */
    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;
    static {

        /**
         * 模拟多个表，商品信息表，库存表，秒杀订单成功表
         */
        products = new HashMap<>();
        stock    = new HashMap<>();
        orders   = new HashMap<>();
        products.put("123456", 100000);
        stock.put("123456", 100000);

    }

    private String queryMap(String productId){

        return "国庆活动， 皮蛋粥特价， 限量份"
                + products.get(productId)
                + "还剩：" + stock.get(productId) + " 份"
                + " 该商品成功下单用户数目： "
                + orders.size() + " 人";
    }

    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }

    // 加锁（防止超卖）：1.synchronized  2.redis分布式锁
    @Override
    public void orderProductMockDiffUser(String productId) {

        // 枷锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if(!redisLock.lock(productId, String.valueOf(time))){
            throw new SellException(101, "人也太多了，换个姿势再试试！");
        }

        // 1.查询该商品库存， 为0则活动结束
        int stockNum = stock.get(productId);
        if (stockNum == 0){
            throw new SellException(100, "秒杀活动结束");
        }else {
            // 2.下单（模拟不同用户openid不同）
            orders.put(KeyUtil.genUniqueKey(), productId);
            // 3.减库存
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stock.put(productId, stockNum);
        }

        // 解锁
        redisLock.unlock(productId, String.valueOf(time));
    }
}
