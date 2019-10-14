package com.etoak.sell.service.impl;

import com.etoak.sell.dataobject.ProductCategory;
import com.etoak.sell.repository.ProductCategoryRepository;
import com.etoak.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:16 2018/12/3
 * @ Description： 商品类 service
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;



    @Override
    public ProductCategory findOne(Integer categoryId) {
        Optional<ProductCategory> result = repository.findById(categoryId);
        return result.get();
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return repository.save(productCategory);
    }
}
