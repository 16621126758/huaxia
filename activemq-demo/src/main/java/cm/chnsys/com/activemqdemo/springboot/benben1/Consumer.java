package cm.chnsys.com.activemqdemo.springboot.benben1;

import cm.chnsys.com.activemqdemo.Qwe;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Class: Consumer
 * @description:  还有巩固才能的问题
 * @Author: hongzhi.zhao
 * @Date: 2019-06-27 09:40
 */
@Component
public class Consumer {

    //@JmsListener(destination = "qwe1")  如果配置文件中启动了topic，那么这个就是topic  如果没有这个就是queue
   @JmsListener(destination = "topic.test1")
    //@JmsListener(destination = "queue.test")
    public void receiveMsg(Qwe qwe){
        System.out.println("收到了消息");
        System.out.println("订阅者1接收到的id"+qwe.getId());
        System.out.println("订阅者1接收到的name"+qwe.getName());
        System.out.println("订阅者1接收到的sex"+qwe.getSex());
    }

    @JmsListener(destination = "topic.text3")
    //@JmsListener(destination = "queue.test")
    public void receiveMsg123(Qwe qwe){
        System.out.println("收到了消息");
        System.out.println("订阅者2接收到的id"+qwe.getId());
        System.out.println("订阅者2接收到的name"+qwe.getName());
        System.out.println("订阅者2接收到的sex"+qwe.getSex());
    }

    @JmsListener(destination = "topic.text3")
    //@JmsListener(destination = "queue.test")
    public void receiveMsg1234(Qwe qwe){
        System.out.println("收到了消息");
        System.out.println("订阅者3接收到的id"+qwe.getId());
        System.out.println("订阅者3接收到的name"+qwe.getName());
        System.out.println("订阅者3接收到的sex"+qwe.getSex());
    }
    //@JmsListener(destination = "topic.test")
    public void receiveMsg2(Qwe qwe){
        System.out.println("quwuw2接收到的id"+qwe.getId());
        System.out.println("queue2接收到的name"+qwe.getName());
        System.out.println("queue2接收到的sex"+qwe.getSex());
    }

    @JmsListener(destination = "map")
    public void receiveMsg(Map map){
        map.forEach((k,v)->{
            System.out.println("map的键为"+k+"map的值为"+v);
        });
    }


//    @JmsListener(destination = "qwe1")
//    public void receiveMsg3(Qwe qwe){
//        System.out.println("订阅者3接收到的id"+qwe.getId());
//        System.out.println("接收到3的name"+qwe.getName());
//        System.out.println("接收到3的sex"+qwe.getSex());
//    }
//    @JmsListener(destination = "qwe1")
//    public void receiveMsg4(Qwe qwe){
//        System.out.println("订阅者4接收到的id"+qwe.getId());
//        System.out.println("订阅者4接收到的name"+qwe.getName());
//        System.out.println("订阅者4接收到的sex"+qwe.getSex());
//    }

}
