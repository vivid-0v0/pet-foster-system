package com.example.petfoster.service;

import com.example.petfoster.entity.OrderInfo;
import com.example.petfoster.entity.PetStatus;
import com.example.petfoster.enums.PetTypeEnum;
import com.example.petfoster.mapper.OrderInfoMapper;
import com.example.petfoster.mapper.PetStatusMapper;
import com.example.petfoster.mapper.ShopInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderInfoService {
    private final OrderInfoMapper orderInfoMapper;
    private final ShopInfoMapper shopInfoMapper;
    private final PetStatusMapper petStatusMapper;

    // 1. 创建订单（匹配流程图：选店铺→选宠物类型→填信息→选时长→支付）
    @Transactional(rollbackFor = Exception.class)
    public void createOrder(OrderInfo orderInfo, Long userId) {
        // 校验参数
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("用户ID无效");
        }
        // 校验店铺是否营业
        if (shopInfoMapper.selectById(orderInfo.getShopId()) == null) {
            throw new IllegalArgumentException("店铺不存在");
        }
        // 校验宠物类型（六大类）
        PetTypeEnum petType = PetTypeEnum.getById(orderInfo.getPetTypeId());

        // 计算金额和时间
        BigDecimal dailyPrice = new BigDecimal(petType.getPricePerDay());
        BigDecimal totalAmount = dailyPrice.multiply(new BigDecimal(orderInfo.getFosterDays()));
        Date now = new Date();
        Date fosterStartTime = now;
        Date fosterEndTime = new Date(now.getTime() + TimeUnit.DAYS.toMillis(orderInfo.getFosterDays()));

        // 填充订单信息
        orderInfo.setUserId(userId);
        orderInfo.setTotalAmount(totalAmount);
        orderInfo.setFosterStartTime(fosterStartTime);
        orderInfo.setFosterEndTime(fosterEndTime);
        orderInfo.setOrderStatus("UNFINISHED");

        // 插入订单
        int result = orderInfoMapper.insertOrder(orderInfo);
        if (result <= 0) {
            throw new IllegalArgumentException("订单创建失败");
        }
        log.info("用户{}创建订单成功，订单ID：{}，总金额：{}", userId, orderInfo.getId(), totalAmount);

        // 初始化宠物状态（默认“待寄养”）
        PetStatus petStatus = new PetStatus();
        petStatus.setOrderId(orderInfo.getId());
        petStatus.setStatusDesc("待寄养，状态正常");
        petStatusMapper.insertPetStatus(petStatus);
    }

    // 2. 查询用户所有订单（计算剩余天数）
    public List<OrderInfo> getOrderByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("用户ID无效");
        }
        List<OrderInfo> orderList = orderInfoMapper.selectByUserId(userId);
        // 计算每个订单剩余天数
        Date now = new Date();
        for (OrderInfo order : orderList) {
            if ("UNFINISHED".equals(order.getOrderStatus()) && order.getFosterEndTime() != null) {
                long remainingMs = order.getFosterEndTime().getTime() - now.getTime();
                long remainingDays = TimeUnit.MILLISECONDS.toDays(remainingMs);
                order.setRemainingDays(Math.max(0, remainingDays)); // 剩余天数≥0
            } else {
                order.setRemainingDays(0L);
            }
        }
        log.info("用户{}查询到{}条订单", userId, orderList.size());
        return orderList;
    }

    // 3. 获取订单对应的宠物实时状态
    public String getPetStatusByOrderId(Long orderId) {
        PetStatus petStatus = petStatusMapper.selectLatestByOrderId(orderId);
        return petStatus != null ? petStatus.getStatusDesc() : "暂无宠物状态信息";
    }

    // 4. 结束订单+评分评论
    @Transactional(rollbackFor = Exception.class)
    public void finishOrder(Long orderId, Long userId, String comment, Integer score) {
        // 校验订单
        OrderInfo order = orderInfoMapper.selectById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("订单不存在");
        }
        // 校验订单归属
        if (!order.getUserId().equals(userId)) {
            throw new IllegalArgumentException("无权操作该订单");
        }
        // 校验订单状态
        if ("FINISHED".equals(order.getOrderStatus())) {
            throw new IllegalArgumentException("订单已结束，无需重复操作");
        }
        // 校验评分
        if (score != null && (score < 1 || score > 5)) {
            throw new IllegalArgumentException("评分必须为1-5分");
        }

        // 更新订单
        order.setOrderStatus("FINISHED");
        order.setComment(comment);
        order.setScore(score);
        int result = orderInfoMapper.updateOrder(order);
        if (result <= 0) {
            throw new IllegalArgumentException("订单结束失败");
        }
        log.info("用户{}结束订单{}，评分：{}，评论：{}", userId, orderId, score, comment);
    }

    // 5. 删除订单（仅未完成订单可删）
    @Transactional(rollbackFor = Exception.class)
    public void deleteOrder(Long orderId, Long userId) {
        OrderInfo order = orderInfoMapper.selectById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("订单不存在");
        }
        if (!order.getUserId().equals(userId)) {
            throw new IllegalArgumentException("无权删除该订单");
        }
        if ("FINISHED".equals(order.getOrderStatus())) {
            throw new IllegalArgumentException("已完成订单不允许删除");
        }

        int result = orderInfoMapper.deleteOrder(orderId, userId);
        if (result <= 0) {
            throw new IllegalArgumentException("订单删除失败");
        }
        log.info("用户{}删除订单{}成功", userId, orderId);
    }
}