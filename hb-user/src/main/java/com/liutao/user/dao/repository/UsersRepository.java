package com.liutao.user.dao.repository;

import com.liutao.user.entity.mysql.Users;
import org.springframework.data.repository.CrudRepository;

/**
 * User: Liu Tao
 * Date: 2017/8/11
 * Time: 上午9:39
 */
public interface UsersRepository extends CrudRepository<Users, Long> {
}
