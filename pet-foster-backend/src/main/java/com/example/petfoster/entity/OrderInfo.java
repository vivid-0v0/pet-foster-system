package com.example.petfoster.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderInfo {
    private Long id;

    @NotNull(message = "用户ID不能为空")
    private Long userId;

    @NotNull(message = "店铺ID不能为空")
    private Long shopId;

    @NotNull(message = "宠物类型ID不能为空")
    private Long petTypeId;

    private String petInfo; // 宠物具体信息（品种、年龄等）

    @NotNull(message = "寄养天数不能为空")
    @Min(value = 1, message = "寄养天数不能小于1天")
    private Integer fosterDays;

    private BigDecimal totalAmount;
    private String orderStatus; // UNFINISHED/FINISHED
    private String comment;
    private Integer score;
    private Date fosterStartTime;
    private Date fosterEndTime;
    private Date createTime;
    private Date updateTime;

    // 关联查询字段
    private String shopName;
    private String petTypeName;
    private Long remainingDays; // 距离寄养结束剩余天数
}