package com.example.petfoster.entity;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 宠物类型实体类（对应pet_type表）
 */
@Data
public class PetType {
    private Long id;                // 类型ID
    private String typeName;        // 宠物类型名称（猫/狗等）
    private String typeDesc;        // 类型描述
    private BigDecimal pricePerDay; // 单日寄养价格（对应数据库price_per_day）
}