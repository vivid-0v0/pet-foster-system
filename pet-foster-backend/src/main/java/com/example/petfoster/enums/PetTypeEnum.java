package com.example.petfoster.enums;

import lombok.Getter;

/**
 * 宠物类型枚举（六大类）
 */
@Getter
public enum PetTypeEnum {
    CAT(1L, "猫", 50.00),
    DOG(2L, "狗", 60.00),
    HAMSTER(3L, "仓鼠", 10.00),
    RABBIT(4L, "兔子", 15.00),
    BIRD(5L, "鸟类", 20.00),
    REPTILE(6L, "爬宠", 30.00);

    private final Long id;
    private final String typeName;
    private final Double pricePerDay;

    PetTypeEnum(Long id, String typeName, Double pricePerDay) {
        this.id = id;
        this.typeName = typeName;
        this.pricePerDay = pricePerDay;
    }

    // 根据ID获取枚举
    public static PetTypeEnum getById(Long id) {
        for (PetTypeEnum type : values()) {
            if (type.getId().equals(id)) {
                return type;
            }
        }
        throw new IllegalArgumentException("无效的宠物类型ID：" + id);
    }
}