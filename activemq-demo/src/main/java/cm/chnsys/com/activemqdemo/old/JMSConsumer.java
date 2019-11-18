package cm.chnsys.com.activemqdemo.old;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Class: JMSConsumer
 * @description:消息消费者
 * @Author: hongzhi.zhao
 * @Date: 2019-06-24 16:47
 */
public class JMSConsumer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;   //默认的链接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;   //链接密码
    //private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;   //默认的链接地址
    private static final String BROKEURL =  "tcp://127.0.0.1:61616";

    public static void main(String[] args) {
        //连接工厂
        ConnectionFactory connectionFactory;
        //连接
        Connection connection = null;
        //会话 接收或者发送消息的线程
        Session session;
        //消息的目的地
        Destination destination;
        //消息消费者
        MessageConsumer messageConsumer;

        //实例化连接工程
        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);

        //或者连接
        try {

            //通过连接工厂获取连接
            connection = connectionFactory.createConnection();
            connection.start();
            //跟生产者不同的是消费者不需要事务
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);   //创建session
            //收到发过来的firstQueue
            destination = session.createQueue("whzyHistory");
            messageConsumer  = session.createConsumer(destination);//创建消息消费者
            System.out.println("123");
            //receiver方法
            while (true){
                System.out.println(messageConsumer.receive());
                System.out.println("456");

                TextMessage textMessage = (TextMessage)messageConsumer.receive();
                System.out.println("789");
                if (null!=textMessage){
                    System.out.println("收到的消息："+textMessage.getText());
                }else {
                    System.out.println("没收到");
                    break;
                }
            }


        } catch (JMSException e) {
            e.printStackTrace();
        }


    }

}
