package com.etoak.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @ Author     ：刘春龙.
 * @ Date       ：Created in 14:36 2018/12/10
 * @ Description：SellerInfo
 */
@Data
@Entity
public class SellerInfo {

    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;
}
