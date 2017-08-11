package com.liutao.sys.entity.mysql;

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
@Table(name = "city")
public class City extends BaseEntity {
    /**
     * 邮箱
     */
    private String cityName;
    /**
     * 状态
     */
    private StatusEnum status;

}
