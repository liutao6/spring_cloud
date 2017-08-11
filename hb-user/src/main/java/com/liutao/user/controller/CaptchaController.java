package com.liutao.user.controller;

import com.liutao.common.model.response.BaseResponse;
import com.liutao.user.feign.HBSysFeignClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午3:47
 */
@Slf4j
@RestController
@RequestMapping("captcha")
@Api(description = "验证码相关接口")
public class CaptchaController {

    @Resource
    private HBSysFeignClient hbSysFeignClient;

    @PostMapping(value = "apply")
    @ApiOperation(value = "申请 手机/邮箱 验证码")
    public BaseResponse applyCaptcha(){
        return hbSysFeignClient.get();

    }
}
