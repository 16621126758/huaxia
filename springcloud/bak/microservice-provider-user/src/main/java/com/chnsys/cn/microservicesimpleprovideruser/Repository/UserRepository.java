package com.chnsys.cn.microservicesimpleprovideruser.Repository;

import com.chnsys.cn.microservicesimpleprovideruser.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

/**
 * @Class: UserRepository
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-21 15:46
 */
public interface UserRepository extends CrudRepository<User,Long> {

}
