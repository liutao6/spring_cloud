package com.liutao.sys.controller;

import com.liutao.common.model.response.BaseResponse;
import com.liutao.sys.entity.mysql.City;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: Liu Tao
 * Date: 2017/8/11
 * Time: 下午3:57
 */
@Slf4j
@RestController
@RequestMapping("city")
@Api(description = "城市接口")
public class CityController {


    @GetMapping(value = "get")
    @ApiOperation(value = "获取城市")
    public BaseResponse get() throws InterruptedException {
        Thread.sleep(10000);
        City city = new City();
        city.setCityName("淮北");
        return BaseResponse.ok(city);
    }
}
