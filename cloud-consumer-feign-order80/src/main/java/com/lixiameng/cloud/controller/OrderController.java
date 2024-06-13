package com.lixiameng.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.lixiameng.cloud.apis.PayFeignApi;
import com.lixiameng.cloud.entities.PayDTO;
import com.lixiameng.cloud.resp.ResultData;
import com.lixiameng.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2024
 * @description:
 * @author: lixiameng
 * @create: 2024-03-02 22:34
 */
@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/feign/pay/add")
    public ResultData addOrder(PayDTO payDTO) {
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping("/feign/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id) {
        return payFeignApi.getById(id);
    }

    @GetMapping("/feign/pay/getAll")
    public ResultData getAll() {

        try {
            System.out.println("开始调用："+DateUtil.now());
            return payFeignApi.getByAll();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("结束调用："+DateUtil.now());
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(),e.getMessage());
        }
    }

    @GetMapping("/feign/pay/update")
    public ResultData updateOrder(PayDTO payDTO) {
        return payFeignApi.updatePay(payDTO);
    }

    @DeleteMapping("/feign/pay/del/{id}")
    public ResultData<Integer> deleteOrder(@PathVariable("id") Integer id) {
        return payFeignApi.deletePay(id);
    }

    @GetMapping("/feign/pay/getInfo")
    public ResultData getInfo() {
        return payFeignApi.getInfo();
    }

}
