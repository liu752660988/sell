package com.etoak.sell.dataobject.dao;

import com.etoak.sell.dataobject.mapper.ProductCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 10:04 2019/4/10
 * @ Description：为什么要加这个Dao层。其实是为了再做一层封装，
 */
public class ProductCategoryDao {

    @Autowired
    private ProductCategoryMapper mapper;

    //这个方法名，可以提现为功能名，跟功能相关
    public int insertByMap(Map<String, Object> map){
        // 这里可以再做操作，进行再次封装
        return mapper.insertByMap(map);
    }

}
