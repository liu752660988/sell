package com.etoak.sell.repository;

import com.etoak.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:41 2018/12/3
 * @ Description：
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
