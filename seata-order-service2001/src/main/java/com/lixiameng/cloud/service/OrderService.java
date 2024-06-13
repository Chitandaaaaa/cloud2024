package com.lixiameng.cloud.service;

import com.lixiameng.cloud.entities.Order;

public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}
