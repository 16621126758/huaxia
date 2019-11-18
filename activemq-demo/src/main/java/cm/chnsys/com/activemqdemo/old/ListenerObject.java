package cm.chnsys.com.activemqdemo.old;

import cm.chnsys.com.activemqdemo.Qwe;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 * @Class: ListenerObject
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-27 10:30
 */
public class ListenerObject implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("收到了消息");

           // System.out.println(((ObjectMessage)message).getObject());
            Qwe qwe = (Qwe)((ObjectMessage)message).getObject();
            System.out.println("收到了消息"+qwe);
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
