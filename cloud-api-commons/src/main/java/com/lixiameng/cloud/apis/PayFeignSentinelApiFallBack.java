package com.lixiameng.cloud.apis;

import com.lixiameng.cloud.resp.ResultData;
import com.lixiameng.cloud.resp.ReturnCodeEnum;
import org.springframework.stereotype.Component;

/**
 * @program: cloud2024
 * @description:
 * @author: lixiameng
 * @create: 2024-03-14 23:33
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi
{
    @Override
    public ResultData getPayByOrderNo(String orderNo)
    {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
