package com.liutao.common.enums;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午4:03
 */
public enum StatusEnum {
    normal("正常"),//存到数据库是索引 '0'
    delete("删除");//存到数据库是索引 '1'

    StatusEnum(String comment) {
        this.comment = comment;
    }

    private String comment;

    public String getComment() {
        return this.comment;
    }
}
