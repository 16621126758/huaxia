package cn.com.chnsys.controller;

import cn.com.chnsys.pojo.Strudent;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Class: HelloController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-10 10:15
 */
@Controller
public class HelloController {

    @RequestMapping("/ehllo")
    @ResponseBody
    public String hello(){
        return "hello";
    }

    @RequestMapping("jsontest")
    @ResponseBody
    public Strudent jsonTest(){
        Strudent strudent = new Strudent();
        strudent.setBirthday(new Date());
        strudent.setId(1);
        strudent.setName("赵弘志");
        return strudent;
    }
}
