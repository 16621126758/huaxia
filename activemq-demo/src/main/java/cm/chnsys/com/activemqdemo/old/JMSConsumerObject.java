package cm.chnsys.com.activemqdemo.old;

import cm.chnsys.com.activemqdemo.old.ListenerObject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Class: JMSConsumerObject
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-27 10:34
 */
public class JMSConsumerObject {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection = null;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;

        //创建连接工厂
        try {
            connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);
            ((ActiveMQConnectionFactory) connectionFactory).setTrustAllPackages(true);
            //创建连接
            connection = connectionFactory.createConnection();
            connection.start();
            //创建会话
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            //创建目的地
            destination = session.createQueue("FirstQueue1");
            //创建消费者
            messageConsumer = session.createConsumer(destination);
            //采用监听的方式来接收  注册消息舰艇
            System.out.println("开始接受");
            messageConsumer.setMessageListener(new ListenerObject());
            System.out.println("end--------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
