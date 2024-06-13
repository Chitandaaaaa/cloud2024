package com.lixiameng.cloud.apis;

import com.lixiameng.cloud.entities.PayDTO;
import com.lixiameng.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient("cloud-payment-service")
@FeignClient("cloud-gateway")
public interface PayFeignApi {

    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    @DeleteMapping("/pay/del/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id);

    @PutMapping("/pay/update")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO);

//    @GetMapping("/pay/get/{id}")
//    public ResultData<PayDTO> getById(@PathVariable("id") Integer id);


    @GetMapping("/pay/getAll")
    public ResultData<List<PayDTO>> getByAll();

    @GetMapping("/pay/getInfo")
    public ResultData<String> getInfo() ;


    /**
     * @Description: resilience4j circuitBreaker 的用例。
     * @param:
     * @return:
     * @throws
     */
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);

    /**
     * Resilience4j Bulkhead 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id);

    /**
     * Resilience4j Ratelimit 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id);

    /**
     * Micrometer(Sleuth)进行链路监控的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例01
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo();
}
