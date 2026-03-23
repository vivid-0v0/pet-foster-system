package com.example.petfoster.controller;

import com.example.petfoster.entity.OrderInfo;
import com.example.petfoster.service.OrderInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Validated
public class OrderController {
    private final OrderInfoService orderInfoService;

    // 下单
    @PostMapping("/create")
    public String createOrder(@RequestBody @Validated OrderInfo orderInfo, Authentication authentication) {
        // 测试阶段固定用户ID为1，后续替换为真实登录用户ID
        Long userId = 1L;
        orderInfo.setUserId(userId);
        
        int result = orderInfoService.createOrder(orderInfo);
        return result > 0 ? "下单成功" : "下单失败";
    }

    // 查我的订单
    @GetMapping("/my")
    public List<OrderInfo> getMyOrder() {
        Long userId = 1L; // 测试用固定ID
        return orderInfoService.getOrderByUserId(userId);
    }

    // 结束订单+评分
    @PutMapping("/finish/{id}")
    public String finishOrder(
            @PathVariable @Min(1) Long id,
            @RequestParam(required = false) String comment,
            @RequestParam(required = false) Integer score) {
        int result = orderInfoService.finishOrder(id, comment, score);
        return result > 0 ? "订单结束成功" : "订单结束失败";
    }

    // 删除订单
    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable @Min(1) Long id) {
        int result = orderInfoService.deleteOrder(id);
        return result > 0 ? "删除成功" : "删除失败";
    }
}