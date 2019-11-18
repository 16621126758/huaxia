package com.chnsys.cn.microservicesimpleconsumermovie.Controller;

import com.chnsys.cn.microservicesimpleconsumermovie.pojo.User;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    LoadBalancerClient loadBalancerClient;


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        System.out.println(userServicePath);
        return restTemplate.getForObject(userServicePath+id,User.class);
    }


    @GetMapping("/movies/{id}")
    public String dc(@PathVariable Long id) {
//        先通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例，
// 这个服务实例的基本信息存储在ServiceInstance中，
// 然后通过这些对象中的信息拼接出访问/dc接口的详细地址，最后再利用RestTemplate对象实现对服务提供者接口的调用。
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "simple/"+id+"";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }

}
