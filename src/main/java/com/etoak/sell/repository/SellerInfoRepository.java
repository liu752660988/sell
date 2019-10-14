package com.etoak.sell.repository;

import com.etoak.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:39 2018/12/10
 * @ Description：
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {

    SellerInfo findByOpenid(String openid);
}
