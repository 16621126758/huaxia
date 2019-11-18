package cn.com.chnsys.rabbitmq.test;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Class: MQSender
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-14 14:52
 */
@Service
public class MQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    String msg = "hello,mworld";
    String msg1 = "hello 赵弘之";
    public void Send(String o ){
        System.out.println("begin send ---------");
       // amqpTemplate.convertAndSend(MQConfig.QUEUE,o);
        amqpTemplate.convertAndSend(MQConfig.QUEUE,o);
        System.out.println("end   send ------------");
    }

//    public void SendTopic(){
//        System.out.println("send topicfMessage"+msg1);
//        amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE,"topic.key1",msg1+1+"");
//        amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE,"topic.key2",msg1+2+"key2的消息");
//    }

    	public void sendTopic() {
          System.out.println("send topic message:"+msg);
		amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key1", msg+"1");
		amqpTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE, "topic.key2", msg+"2");
	}


}
