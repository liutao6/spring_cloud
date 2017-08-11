package com.liutao.user.feign;

import com.liutao.common.model.response.BaseResponse;
import com.liutao.user.feign.hystrix.HBSysHystrixClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * User: Liu Tao
 * Date: 2017/8/11
 * Time: 下午4:03
 */
@FeignClient(name = "hb-sys", fallback = HBSysHystrixClient.class, path = "/hb-sys")
public interface HBSysFeignClient {

    @RequestMapping(value = "/city/get", method = RequestMethod.GET)
    BaseResponse get();

}
