package com.etoak.sell.service;

import com.etoak.sell.dataobject.SellerInfo;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:53 2018/12/10
 * @ Description：卖家端Service
 */
public interface SellerService {

    //卖家端通过openid获得卖家信息
    SellerInfo findSellerInfoByOpenid(String openid);
}
