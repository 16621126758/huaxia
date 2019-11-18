package cm.chnsys.com.activemqdemo.old.fabudingyue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * @Class: Listener
 * @description: 消息监听
 * @Author: hongzhi.zhao
 * @Date: 2019-06-24 17:23
 */
public class Listener2 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("订阅者2收到的消息"+((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
