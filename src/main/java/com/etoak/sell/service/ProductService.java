package com.etoak.sell.service;

import com.etoak.sell.dataobject.ProductInfo;
import com.etoak.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:57 2018/12/3
 * @ Description：商品
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /*
    *    查询所有上架商品
    * */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

    //上架
    ProductInfo onSale(String productId);

    //下架
    ProductInfo offSale(String productId);
}
