package com.lixiameng.cloud.service;

import com.lixiameng.cloud.entities.Pay;

import java.util.List;

/**
 * @program: cloud2024
 * @description:
 * @author: lixiameng
 * @create: 2024-03-02 18:01
 */
public interface PayService {
    public int add(Pay pay);

    public int delete(Integer id);

    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}
