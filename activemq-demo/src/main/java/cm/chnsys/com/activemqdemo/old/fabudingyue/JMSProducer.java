package cm.chnsys.com.activemqdemo.old.fabudingyue;

import ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import sun.security.util.Password;

/**
 * @Class: JMSProducer
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-24 18:04
 */
public class JMSProducer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 10;

    public static void main(String[] args) {

        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageProducer messageProducer;

        //创建连接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);
        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("FirstTopic1");
             messageProducer =  session.createProducer(destination);
             sendMessage(session,messageProducer);
             session.commit();

        } catch (JMSException e) {
            e.printStackTrace();
        }

    }

    public static void sendMessage(Session session,MessageProducer messageProducer)
            throws JMSException {
        for (int i = 0;i<=SENDNUM;i++){
            TextMessage textMessage = session.createTextMessage("ActiveMQ 发送的消息："+i);
            System.out.println("发送消息："+"ActiveMQ 发送的消息"+i);
            messageProducer.send(textMessage);
            System.out.println("sdfds f");
        }
    }

}
