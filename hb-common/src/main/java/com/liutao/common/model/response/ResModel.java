package com.liutao.common.model.response;

import lombok.Data;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午2:15
 */
@Data
public class ResModel<T> {
    private int    code;
    private String msg;
    private T      data;
    private Boolean hasNext    = false;
    private long    serverTime = System.currentTimeMillis();// 服务器时间

    public ResModel() {
        this.code = 100;
    }

    public ResModel(int code) {
        this.code = code;
    }

    public ResModel(T data) {
        this.code = 100;
        if (data != null) {
            this.data = data;
        }
    }

    public ResModel(T data, Boolean hasNext) {
        if (data != null)
            this.data = data;

        this.hasNext = hasNext;
        this.code = 100;
    }

    public ResModel(int code, T data) {
        if (data != null)
            this.data = data;

        this.code = code;
    }

    public static ResModel ok(Object data) {
        return new ResModel(data);
    }

    public static ResModel ok(Object data, Boolean hasNext) {
        return new ResModel(data, hasNext);
    }

    public static ResModel ok() {
        return new ResModel();
    }

    public static ResModel error(int code) {
        return new ResModel(code);
    }

    public static ResModel error(int code, Object id) {
        return new ResModel(code, id);
    }
}
