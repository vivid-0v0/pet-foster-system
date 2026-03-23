package com.example.petfoster.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data  // Lombok注解，自动生成get/set/toString
public class OrderInfo {
    private Long id;
    private Long userId;
    private Long shopId;
    private Long petTypeId;
    private String petInfo;
    private Integer fosterDays;
    private BigDecimal totalAmount;
    private String orderStatus; // UNFINISHED/FINISHED
    private String comment;
    private Integer score;
    private Date createTime;
    private Date updateTime;
    
    // 关联字段（用于查询）
    private String shopName;
    private String petTypeName;
    private String username;
}