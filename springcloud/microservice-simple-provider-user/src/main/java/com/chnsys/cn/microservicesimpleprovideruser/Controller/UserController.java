package com.chnsys.cn.microservicesimpleprovideruser.Controller;

import com.chnsys.cn.microservicesimpleprovideruser.Repository.UserRepository;
import com.chnsys.cn.microservicesimpleprovideruser.pojo.User;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class: UserController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-21 15:48
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/simple/{id}")
    public Optional<User> findById(@PathVariable Long id){
        return this.userRepository.findById(id);
    }
}
