package com.etoak.sell.service;

import com.etoak.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:13 2018/12/3
 * @ Description：
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
}
