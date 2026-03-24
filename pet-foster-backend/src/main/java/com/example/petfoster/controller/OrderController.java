package com.example.petfoster.controller;

import com.example.petfoster.common.Result;
import com.example.petfoster.entity.OrderInfo;
import com.example.petfoster.service.OrderInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Min;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Validated
public class OrderController {
    private final OrderInfoService orderInfoService;

    // 1. 创建订单
    @PostMapping("/create")
    public Result<?> createOrder(@RequestBody @Validated OrderInfo orderInfo, Authentication authentication) {
        Long userId = getUserIdFromAuth(authentication);
        orderInfoService.createOrder(orderInfo, userId);
        return Result.success("下单成功");
    }

    // 2. 查询我的所有订单（含剩余天数）
    @GetMapping("/my")
    public Result<List<OrderInfo>> getMyOrder(Authentication authentication) {
        Long userId = getUserIdFromAuth(authentication);
        List<OrderInfo> orderList = orderInfoService.getOrderByUserId(userId);
        return Result.success(orderList);
    }

    // 3. 查询订单对应的宠物状态
    @GetMapping("/pet/status/{orderId}")
    public Result<String> getPetStatus(@PathVariable @Min(1) Long orderId) {
        String status = orderInfoService.getPetStatusByOrderId(orderId);
        return Result.success(status);
    }

    // 4. 结束订单+评分评论
    @PutMapping("/finish/{orderId}")
    public Result<?> finishOrder(
            @PathVariable @Min(1) Long orderId,
            Authentication authentication,
            @RequestParam(required = false) String comment,
            @RequestParam(required = false) @Min(1) Integer score) {
        Long userId = getUserIdFromAuth(authentication);
        orderInfoService.finishOrder(orderId, userId, comment, score);
        return Result.success("订单结束成功");
    }

    // 5. 删除订单
    @DeleteMapping("/{orderId}")
    public Result<?> deleteOrder(@PathVariable @Min(1) Long orderId, Authentication authentication) {
        Long userId = getUserIdFromAuth(authentication);
        orderInfoService.deleteOrder(orderId, userId);
        return Result.success("订单删除成功");
    }

    // 从Security认证中获取用户ID
    private Long getUserIdFromAuth(Authentication authentication) {
        if (authentication == null || !(authentication.getPrincipal() instanceof UserDetails)) {
            throw new IllegalArgumentException("请先登录");
        }
        return Long.parseLong(((UserDetails) authentication.getPrincipal()).getUsername());
    }
}