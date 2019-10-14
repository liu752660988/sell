package com.etoak.sell.util;

import com.etoak.sell.VO.ResultVO;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 19:55 2018/12/3
 * @ Description：返回数据处理类
 */
public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功了");
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return  resultVO;
    }
}
