package com.example.petfoster.mapper;

import com.example.petfoster.entity.UserInfo;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserInfoMapper {
    // 按ID查用户
    @Select("SELECT id, username, email, avatar FROM user_info WHERE id = #{id}")
    UserInfo selectById(Long id);

    // 按用户名查用户（登录用）
    @Select("SELECT * FROM user_info WHERE username = #{username}")
    UserInfo selectByUsername(String username);

    // 更新用户信息（用户名/邮箱/头像）
    @Update("<script>" +
            "UPDATE user_info SET update_time = NOW() " +
            "<if test='username != null'>, username = #{username}</if> " +
            "<if test='email != null'>, email = #{email}</if> " +
            "<if test='avatar != null'>, avatar = #{avatar}</if> " +
            "WHERE id = #{id}" +
            "</script>")
    int updateUserInfo(UserInfo userInfo);

    // 更新密码
    @Update("UPDATE user_info SET password = #{password}, update_time = NOW() WHERE id = #{id}")
    int updatePassword(Long id, String password);
}