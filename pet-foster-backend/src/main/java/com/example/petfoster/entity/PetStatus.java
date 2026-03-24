package com.example.petfoster.entity;

import lombok.Data;
import java.util.Date;

@Data
public class PetStatus {
    private Long id;
    private Long orderId;
    private String statusDesc; // 宠物活跃状态（如“进食正常/玩耍中”）
    private Date updateTime;
}