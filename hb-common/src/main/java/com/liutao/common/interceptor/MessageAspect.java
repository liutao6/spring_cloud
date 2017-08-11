package com.liutao.common.interceptor;

import com.liutao.common.model.response.BaseResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.MessageSource;
import org.springframework.core.annotation.Order;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * User: Liu Tao
 * Date: 2017/8/11
 * Time: 上午9:55
 */
@Aspect
@Order(5)
public class MessageAspect {

    @Resource
    private MessageSource messageSource;

    @Around("execution(* com.liutao.*.controller..*.*(..))")
    public Object addMsg(ProceedingJoinPoint pjp) throws Throwable {
        Object obj = pjp.proceed();
        if (obj instanceof BaseResponse) {
            BaseResponse baseResponse = (BaseResponse) obj;
            baseResponse.setMsg(messageSource.getMessage(baseResponse.getCode() + "", null, "不识别的错误码，请联系服务器！", Locale.SIMPLIFIED_CHINESE));
            return baseResponse;
        }
        return obj;
    }
}
