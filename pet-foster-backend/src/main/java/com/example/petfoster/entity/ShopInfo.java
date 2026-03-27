package com.example.petfoster.entity;

import lombok.Data;

/**
 * 店铺信息实体类（对应shop_info表）
 */
@Data
public class ShopInfo {
    private Long id;         // 店铺ID
    private String shopName; // 店铺名称（对应数据库shop_name）
    private String address;  // 店铺地址
    private String phone;    // 联系电话
    private Integer status;  // 营业状态（1-营业中，0-休息）
}