package com.liutao.user.controller;

import com.liutao.user.dao.mapper.UsersMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * User: Liu Tao
 * Date: 2017/8/10
 * Time: 下午3:47
 */
@RestController
@Slf4j
public class UsersController {

    @Resource
    private UsersMapper usersMapper;



}
