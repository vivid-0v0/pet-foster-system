package com.example.petfoster.service;

import com.example.petfoster.entity.UserInfo;
import com.example.petfoster.mapper.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoMapper userInfoMapper;
    private final PasswordEncoder passwordEncoder;

    // 1. 查询用户基本信息（个人中心）
    public UserInfo getUserInfo(Long userId) {
        UserInfo user = userInfoMapper.selectById(userId);
        if (user == null) {
            throw new IllegalArgumentException("用户不存在");
        }
        user.setPassword(null); // 隐藏密码
        return user;
    }

    // 2. 修改用户基本信息（用户名/邮箱/头像）
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(UserInfo userInfo) {
        if (userInfo.getId() == null || userInfo.getId() <= 0) {
            throw new IllegalArgumentException("用户ID无效");
        }
        int result = userInfoMapper.updateUserInfo(userInfo);
        if (result <= 0) {
            throw new IllegalArgumentException("用户信息修改失败");
        }
        log.info("用户{}修改基本信息成功", userInfo.getId());
    }

    // 3. 修改密码
    @Transactional(rollbackFor = Exception.class)
    public void updatePassword(Long userId, String oldPassword, String newPassword) {
        // 校验旧密码
        UserInfo user = userInfoMapper.selectById(userId);
        if (user == null || !passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("旧密码错误");
        }
        // 加密新密码并更新
        String encodedNewPwd = passwordEncoder.encode(newPassword);
        int result = userInfoMapper.updatePassword(userId, encodedNewPwd);
        if (result <= 0) {
            throw new IllegalArgumentException("密码修改失败");
        }
        log.info("用户{}修改密码成功", userId);
    }

    // 4. 登录校验（Security用）
    public UserInfo login(String username, String password) {
        UserInfo user = userInfoMapper.selectByUsername(username);
        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("用户名或密码错误");
        }
        return user;
    }
}