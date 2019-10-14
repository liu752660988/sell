package com.etoak.sell.util;

import com.etoak.sell.enums.CodeEnum;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 15:00 2018/12/5
 * @ Description：通过一个code值过得此枚举类型
 */
public class EnumUtil {

    public static <T extends CodeEnum>T getByCode(Integer code, Class<T> enumClass){

        for (T each: enumClass.getEnumConstants()){
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }
}
