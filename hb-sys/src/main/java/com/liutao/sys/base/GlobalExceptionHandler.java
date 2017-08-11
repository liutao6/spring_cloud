package com.liutao.sys.base;

import com.liutao.common.exception.CommonGlobalExceptionHandler;
import com.liutao.common.model.response.BaseResponse;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Liu Tao
 * Date: 2017/8/11
 * Time: 上午9:50
 */
@ControllerAdvice
public class GlobalExceptionHandler extends CommonGlobalExceptionHandler {

    @Resource
    private MessageSource messageSource;

    @ExceptionHandler
    @ResponseBody
    public BaseResponse handle(HttpServletRequest request, HttpServletResponse response, Throwable ex) {
        return super.handle(request,response,ex, messageSource);
    }
}
