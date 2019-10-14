package com.etoak.sell.form;


import lombok.Data;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 18:57 2018/12/6
 * @ Description：前端入参
 */
@Data
public class CategoryForm {

    /** 类目id. */
    private Integer categoryId;

    /** 类目名称. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
