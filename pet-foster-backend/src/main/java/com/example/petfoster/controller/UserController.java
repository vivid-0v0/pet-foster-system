package com.example.petfoster.controller;

import com.example.petfoster.common.Result;
import com.example.petfoster.entity.UserInfo;
import com.example.petfoster.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserInfoService userInfoService;

    // 1. 获取个人信息（用户名/邮箱/头像）
    @GetMapping("/info")
    public Result<UserInfo> getUserInfo(Authentication authentication) {
        Long userId = getUserIdFromAuth(authentication);
        UserInfo userInfo = userInfoService.getUserInfo(userId);
        return Result.success(userInfo);
    }

    // 2. 修改个人信息（用户名/邮箱/头像）
    @PutMapping("/info")
    public Result<?> updateUserInfo(@RequestBody UserInfo userInfo, Authentication authentication) {
        Long userId = getUserIdFromAuth(authentication);
        userInfo.setId(userId); // 强制用登录用户ID，防止篡改
        userInfoService.updateUserInfo(userInfo);
        return Result.success("个人信息修改成功");
    }

    // 3. 修改密码
    @PutMapping("/password")
    public Result<?> updatePassword(
            @RequestParam String oldPassword,
            @RequestParam String newPassword,
            Authentication authentication) {
        Long userId = getUserIdFromAuth(authentication);
        userInfoService.updatePassword(userId, oldPassword, newPassword);
        return Result.success("密码修改成功");
    }

    // 从认证信息中提取用户ID
    private Long getUserIdFromAuth(Authentication authentication) {
        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetails)) {
            throw new IllegalArgumentException("请先登录");
        }
        return Long.parseLong(((UserDetails) authentication.getPrincipal()).getUsername());
    }
}