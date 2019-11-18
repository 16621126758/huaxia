package cn.com.chnsys.controller;


import cn.com.chnsys.dao.LocaldMapper;
import cn.com.chnsys.pojo.Local123;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Class: HelloController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-07 11:32
 */
@Controller
public class HelloController {


    @Autowired
    private LocaldMapper locald;
    @RequestMapping("/hello")
    @ResponseBody
    public int hello(){

        Local123 local123 = new Local123();
        local123.setLocalDate1(LocalDate.now());
        local123.setLocalTime1(LocalTime.now());
        local123.setLocalDateTime1(LocalDateTime.now());

        int i = locald.insertLocal(local123);

        return i;

    }
}
