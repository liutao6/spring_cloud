package com.liutao.common.exception;

import com.liutao.common.model.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午2:19
 */
@Slf4j
public abstract class CommonGlobalExceptionHandler {

    public BaseResponse handle(HttpServletRequest request, HttpServletResponse response, Throwable ex, MessageSource messageSource) {
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException cve = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> constraintViolations = cve.getConstraintViolations();
            ConstraintViolation<?> constraintViolation = constraintViolations.iterator().next();
            String message = constraintViolation.getMessage();
            BaseResponse error = BaseResponse.error(Integer.parseInt(message));
            error.setMsg(messageSource.getMessage(error.getCode() + "", null, "不识别的错误码，请联系服务器！", null));
            log.error(ex.getMessage(), ex);
            return error;
        }
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException manve = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = manve.getBindingResult();
            ObjectError objectError = bindingResult.getAllErrors().get(0);
            String message = objectError.getDefaultMessage();
            BaseResponse error = BaseResponse.error(Integer.parseInt(message));
            error.setMsg(messageSource.getMessage(error.getCode() + "", null, "不识别的错误码，请联系服务器！", null));
            log.error(ex.getMessage(), ex);
            return error;
        }
        log.error(ex.getMessage(), ex);
        BaseResponse baseResponse = new BaseResponse(-99);
        baseResponse.setMsg(messageSource.getMessage(baseResponse.getCode() + "", null, "不识别的错误码，请联系服务器！", null));
        return baseResponse;
    }
}
