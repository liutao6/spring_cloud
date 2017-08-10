package com.liutao.common.exception;

import com.liutao.common.model.response.ResModel;
import org.springframework.context.MessageSource;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午2:19
 */
public abstract class CommonGlobalExceptionHandler {

    public ResModel handle(HttpServletRequest request, HttpServletResponse response, Throwable ex, MessageSource messageSource) {
        ResModel resModel = new ResModel(-99);
        resModel.setMsg("服务器异常");
        return resModel;
    }
}
