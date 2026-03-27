package com.example.petfoster.mapper;

import com.example.petfoster.entity.OrderInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface OrderInfoMapper {
    // 创建订单
    @Insert("INSERT INTO order_info(user_id, shop_id, pet_type_id, pet_info, foster_days, total_amount, foster_start_time, foster_end_time) " +
            "VALUES(#{userId}, #{shopId}, #{petTypeId}, #{petInfo}, #{fosterDays}, #{totalAmount}, #{fosterStartTime}, #{fosterEndTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertOrder(OrderInfo orderInfo);

    // 按用户ID查所有订单（关联店铺/宠物类型）
    @Select("SELECT o.*, s.shop_name, pt.type_name " +
            "FROM order_info o " +
            "LEFT JOIN shop_info s ON o.shop_id = s.id " +
            "LEFT JOIN pet_type pt ON o.pet_type_id = pt.id " +
            "WHERE o.user_id = #{userId} " +
            "ORDER BY o.create_time DESC")
    List<OrderInfo> selectByUserId(Long userId);

    // 按订单ID查详情
    @Select("SELECT * FROM order_info WHERE id = #{id}")
    OrderInfo selectById(Long id);

    // 更新订单（结束/评分/评论）
    @Update("<script>" +
            "UPDATE order_info SET update_time = NOW(), order_status = #{orderStatus} " +
            "<if test='comment != null'>, comment = #{comment}</if> " +
            "<if test='score != null'>, score = #{score}</if> " +
            "WHERE id = #{id}" +
            "</script>")
    int updateOrder(OrderInfo orderInfo);

    // 删除订单
    @Delete("DELETE FROM order_info WHERE id = #{id} AND user_id = #{userId}")
    int deleteOrder(Long id, Long userId);
}