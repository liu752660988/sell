package com.etoak.sell.dataobject.BO;

import lombok.Data;

import java.io.Serializable;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 16:18 2019/6/5
 * @ Description：
 */
@Data
public class ImageParseBO implements Serializable {


    private static final long serialVersionUID = 8593919255753441939L;
    private String base64;
    private Integer w;
    private Integer h;
    private Integer channel;
    private Integer type;

}
