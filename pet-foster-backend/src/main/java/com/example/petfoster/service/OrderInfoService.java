package com.example.petfoster.service;

import com.example.petfoster.entity.OrderInfo;
import com.example.petfoster.mapper.OrderInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service  // 标记为Spring服务类
@RequiredArgsConstructor  // Lombok注解，自动注入依赖
public class OrderInfoService {
    private final OrderInfoMapper orderInfoMapper;

    // 下单（自动计算金额：单日50元）
    public int createOrder(OrderInfo orderInfo) {
        if (orderInfo.getFosterDays() <= 0) {
            throw new IllegalArgumentException("寄养时长不能小于1天");
        }
        BigDecimal amount = new BigDecimal(50).multiply(new BigDecimal(orderInfo.getFosterDays()));
        orderInfo.setTotalAmount(amount);
        orderInfo.setOrderStatus("UNFINISHED");
        return orderInfoMapper.insertOrder(orderInfo);
    }

    // 查用户所有订单
    public List<OrderInfo> getOrderByUserId(Long userId) {
        return orderInfoMapper.selectByUserId(userId);
    }

    // 结束订单+评分评论
    public int finishOrder(Long orderId, String comment, Integer score) {
        OrderInfo order = orderInfoMapper.selectById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("订单不存在");
        }
        if (score != null && (score < 1 || score > 5)) {
            throw new IllegalArgumentException("评分必须是1-5分");
        }
        order.setOrderStatus("FINISHED");
        order.setComment(comment);
        order.setScore(score);
        return orderInfoMapper.updateOrder(order);
    }

    // 删除订单
    public int deleteOrder(Long id) {
        return orderInfoMapper.deleteById(id);
    }
}