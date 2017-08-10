package com.liutao.common.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
@Data
public class BaseEntity {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;
    private String remark;
    private Date createTime;
    private Date updateTime;
}
