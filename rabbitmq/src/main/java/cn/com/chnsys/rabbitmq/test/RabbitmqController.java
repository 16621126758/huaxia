package cn.com.chnsys.rabbitmq.test;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Class: RabbitmqController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-14 16:59
 */
@Controller
public class RabbitmqController {

    @Autowired
    private MQSender mqSender;

    @Autowired
    private MQReceive mqReceive;

    @RequestMapping("/test")
    @ResponseBody
    public String say(){
        System.out.println("--------controller-----------");

        Student student = new Student();
        student.setId(1);
        student.setSex("男");
        student.setName("赵弘之");
        for (int i = 0;i<400;i++){
            mqSender.Send("hrllo");

        }

        System.out.println("--------------end");
        return "syccess";
    }

    @RequestMapping("/topic")
    @ResponseBody
    public String receivetopic(){
        mqSender.sendTopic();
        return "success";
    }


}
