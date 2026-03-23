package com.example.petfoster.mapper;

import com.example.petfoster.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper  // 标记为MyBatis Mapper接口
public interface OrderInfoMapper {
    // 新增订单
    int insertOrder(OrderInfo orderInfo);
    
    // 根据用户ID查订单
    List<OrderInfo> selectByUserId(Long userId);
    
    // 根据ID查订单
    OrderInfo selectById(Long id);
    
    // 更新订单（评分/评论/状态）
    int updateOrder(OrderInfo orderInfo);
    
    // 删除订单
    int deleteById(Long id);
}