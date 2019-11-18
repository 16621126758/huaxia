package com.chnsys.cn.microservicesimpleconsumermovie.Controller;

import com.chnsys.cn.microservicesimpleconsumermovie.pojo.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import javax.jnlp.UnavailableServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Class: MovieController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-21 16:51
 */
@RestController
public class MovieController {

    @Value("${user.userServicePath}")
    private String userServicePath;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        System.out.println(userServicePath);
        return restTemplate.getForObject(userServicePath+id,User.class);
    }

}
