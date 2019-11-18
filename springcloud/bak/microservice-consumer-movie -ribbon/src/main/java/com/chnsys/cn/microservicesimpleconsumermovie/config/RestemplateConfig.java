package com.chnsys.cn.microservicesimpleconsumermovie.config;

import java.nio.charset.Charset;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @Class: RestemplateConfig
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-21 17:03
 */
@Configuration
public class RestemplateConfig {

    @Bean    //这个可以用
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(ClientHttpRequestFactory factory){
//        RestTemplate restTemplate= new RestTemplate(factory);
//        // 支持中文编码
//        restTemplate.getMessageConverters().set(1,
//                new StringHttpMessageConverter(Charset.forName("UTF-8")));
//        return restTemplate;
//
//    }
//
//    @Bean
//    public ClientHttpRequestFactory simpleClientHttpRequestFactory(){
//        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
//        factory.setReadTimeout(5000);//单位为ms
//        factory.setConnectTimeout(5000);//单位为ms
//        return factory;
//    }

}
