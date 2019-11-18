package cn.com.chnsys.rabbitmq.test;

import javax.print.DocFlavor.STRING;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.VoidDescriptor;

/**
 * @Class: MQReceive
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-14 15:00
 */
@Service
public class MQReceive {

    @RabbitListener(queues = MQConfig.QUEUE)
    public void received(String o){
        System.out.println("receive----message:  "+o);
    }

    @RabbitListener(queues=MQConfig.TOPIC_QUEUE1)
		public void receiveTopic1(String message) {
        System.out.println(" topic  queue1 message:"+message);
		}

		@RabbitListener(queues=MQConfig.TOPIC_QUEUE2)
		public void receiveTopic2(String message) {
                System.out.println(" topic  queue2 message:"+message);
		}
}

