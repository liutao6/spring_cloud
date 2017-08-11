package com.liutao.common.model.response;

import lombok.Data;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午2:15
 */
@Data
public class BaseResponse<T> {
    private int    code;
    private String msg;
    private T      data;
    private Boolean hasNext    = false;
    private long    serverTime = System.currentTimeMillis();// 服务器时间

    public BaseResponse() {
        this.code = 100;
    }

    public BaseResponse(int code) {
        this.code = code;
    }

    public BaseResponse(T data) {
        this.code = 100;
        if (data != null) {
            this.data = data;
        }
    }

    public BaseResponse(T data, Boolean hasNext) {
        if (data != null)
            this.data = data;

        this.hasNext = hasNext;
        this.code = 100;
    }

    public BaseResponse(int code, T data) {
        if (data != null)
            this.data = data;

        this.code = code;
    }

    public static BaseResponse ok(Object data) {
        return new BaseResponse(data);
    }

    public static BaseResponse ok(Object data, Boolean hasNext) {
        return new BaseResponse(data, hasNext);
    }

    public static BaseResponse ok() {
        return new BaseResponse();
    }

    public static BaseResponse error(int code) {
        return new BaseResponse(code);
    }

    public static BaseResponse error(int code, Object id) {
        return new BaseResponse(code, id);
    }
}
