package com.example.petfoster.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Date;

@Data
public class UserInfo {
    private Long id;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @Email(message = "邮箱格式不正确")
    private String email;

    private String password; // 前端传明文，后端加密存储
    private String avatar;
    private Date createTime;
    private Date updateTime;
}