package com.lixiameng.cloud.controller;

import com.lixiameng.cloud.entities.Pay;
import com.lixiameng.cloud.entities.PayDTO;
import com.lixiameng.cloud.resp.ResultData;
import com.lixiameng.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: cloud2024
 * @description:
 * @author: lixiameng
 * @create: 2024-03-02 18:06
 */
@Tag(name = "支付服务", description = "支付CRUD")
@RestController
public class PayController {

    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增", description = "新增支付流水")
    public ResultData<String> addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping("/pay/del/{id}")
    @Operation(summary = "删除", description = "删除支付流水")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id) {
        return ResultData.success(payService.delete(id));
    }


    @PutMapping("/pay/update")
    @Operation(summary = "更新", description = "更新支付流水")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping("/pay/get/{id}")
    @Operation(summary = "查询单个", description = "查询单个支付流水")
    public ResultData<Pay> getById(@PathVariable("id") Integer id) {
        return ResultData.success(payService.getById(id));
    }


    @GetMapping("/pay/getAll")
    @Operation(summary = "查询所有", description = "查询所有支付流水")
    public ResultData<List<Pay>> getByAll() {
        return ResultData.success(payService.getAll());
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/getInfo")
    @Operation(summary = "查询consul配置中心文件", description = "查询consul配置中心文件")
    public ResultData<String> getInfo(@Value("${lixiameng.info}") String info) {
        return ResultData.success("获取consul配置中心lixiameng.info：" + info + ",获取端口：" + port);
    }
}
