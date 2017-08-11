package com.liutao.common.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.liutao.common.model.response.ResModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

    public ResModel handle(HttpServletRequest request, HttpServletResponse response, Throwable ex, MessageSource messageSource) {
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException cve = (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> constraintViolations = cve.getConstraintViolations();
            ConstraintViolation<?> constraintViolation = constraintViolations.iterator().next();
            String message = constraintViolation.getMessage();
            ResModel error = ResModel.error(Integer.parseInt(message));
            error.setMsg(messageSource.getMessage(error.getCode() + "", null, "不识别的错误码，请联系服务器！", null));
            log.warn(ex.getMessage(), ex);
            return error;
        }
        if (ex instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException manve = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = manve.getBindingResult();
            ObjectError objectError = bindingResult.getAllErrors().get(0);
            String message = objectError.getDefaultMessage();
            ResModel error = ResModel.error(Integer.parseInt(message));
            error.setMsg(messageSource.getMessage(error.getCode() + "", null, "不识别的错误码，请联系服务器！", null));
            log.warn(ex.getMessage(), ex);
            return error;
        }
        ResModel resModel = new ResModel(-99);
        resModel.setMsg(messageSource.getMessage(resModel.getCode() + "", null, "不识别的错误码，请联系服务器！", null));
        return resModel;
    }
}
