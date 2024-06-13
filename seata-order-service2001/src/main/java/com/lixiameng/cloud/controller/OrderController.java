package com.lixiameng.cloud.controller;

import com.lixiameng.cloud.entities.Order;
import com.lixiameng.cloud.resp.ResultData;
import com.lixiameng.cloud.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2024
 * @description:
 * @author: lixiameng
 * @create: 2024-03-17 10:15
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/order/create")
    public ResultData create(Order order)
    {
        orderService.create(order);
        return ResultData.success(order);
    }
}
