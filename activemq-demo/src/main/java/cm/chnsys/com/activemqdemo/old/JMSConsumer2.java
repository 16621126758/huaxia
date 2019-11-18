package cm.chnsys.com.activemqdemo.old;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.catalina.User;

/**
 * @Class: JMSConsumer2
 * @description: 监听的形式
 * @Author: hongzhi.zhao
 * @Date: 2019-06-24 17:12
 */
public class JMSConsumer2 {

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
            messageConsumer.setMessageListener(new Listener());
            } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
