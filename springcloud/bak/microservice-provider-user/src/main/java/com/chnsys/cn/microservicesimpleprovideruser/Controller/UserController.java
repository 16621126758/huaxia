package com.chnsys.cn.microservicesimpleprovideruser.Controller;

import com.chnsys.cn.microservicesimpleprovideruser.Repository.UserRepository;
import com.chnsys.cn.microservicesimpleprovideruser.pojo.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import java.util.List;
import javax.print.DocFlavor.STRING;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return this.userRepository.findOne(id);
    }

    @RequestMapping("/eureka-instance")
    public String serviceUrl(){
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER",false);
        return instance.getHomePageUrl();
    }

    @RequestMapping("/instance-info")
    public ServiceInstance showInfo(){
        ServiceInstance serviceInstance  = discoveryClient.getLocalServiceInstance();
        return serviceInstance;
    }

    @RequestMapping("/getService")
    public List<String> getServices(){
        List<String> serviceInstance = discoveryClient.getServices();
        return serviceInstance;
    }
}
