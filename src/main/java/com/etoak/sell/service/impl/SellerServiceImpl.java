package com.etoak.sell.service.impl;

import com.etoak.sell.dataobject.SellerInfo;
import com.etoak.sell.repository.SellerInfoRepository;
import com.etoak.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:55 2018/12/10
 * @ Description：
 */
@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private SellerInfoRepository sellerInfoRepository;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoRepository.findByOpenid(openid);
    }
}
