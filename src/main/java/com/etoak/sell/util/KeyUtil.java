package com.etoak.sell.util;

import java.util.Random;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 13:22 2018/12/4
 * @ Description：KeyUtil
 */
public class KeyUtil {

    /*
    * 生产唯一的主键
    * 格式：时间+随机数
    * */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
