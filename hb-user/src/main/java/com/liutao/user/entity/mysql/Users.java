package com.liutao.user.entity.mysql;

import com.liutao.common.entity.BaseEntity;
import com.liutao.common.enums.StatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午3:42
 */
@Data
@Entity
@Table(name = "users")
public class Users extends BaseEntity {
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 密码
     */
    private String password;
    /**
     * 密码盐
     */
    private String sale;
    /**
     * 状态
     */
    private StatusEnum status;

}
