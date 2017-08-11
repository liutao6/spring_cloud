package com.liutao.user.feign.hystrix;

import com.liutao.common.model.response.BaseResponse;
import com.liutao.user.feign.HBSysFeignClient;
import org.springframework.stereotype.Component;

/**
 * User: Liu Tao
 * Date: 2017/8/11
 * Time: 下午4:04
 */
@Component
public class HBSysHystrixClient implements HBSysFeignClient {


    public BaseResponse get() {
        return BaseResponse.error(101);
    }
}
