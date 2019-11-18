package cm.chnsys.com.activemqdemo.springboot.benben1;

import cm.chnsys.com.activemqdemo.Qwe;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import javax.jms.Destination;
import javax.jms.Topic;
import org.apache.activemq.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class: ProducerController
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-27 09:34
 */
@RestController
public class ProducerController {
    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private javax.jms.Queue queue;

    @RequestMapping("/queue")
    public void sendMessage(){
        Qwe qwe = new Qwe();
        qwe.setId(1);
        qwe.setName("赵洪志");
        qwe.setSex("男");

        jmsTemplate.convertAndSend("queue.test",qwe);
    }

    @RequestMapping("/topic")
    public void sendMessage2(){
        Qwe qwe = new Qwe();
        qwe.setId(1);
        qwe.setName("赵洪志");
        qwe.setSex("男");
        System.out.println("fabuxiaoxi");
        jmsTemplate.convertAndSend(queue,qwe);
        System.out.println("-----------------");
    }


    @RequestMapping("/map")
    public void senMessage1(){
        Qwe qwe = new Qwe();
        qwe.setId(1);
        qwe.setName("赵洪志");
        qwe.setSex("男");
        Map<String,Object> map = new HashMap<>();
        map.put("qwe","zhaohongzhi");
        map.put("rty",123);
        jmsTemplate.convertAndSend("map",map);
    }

}
