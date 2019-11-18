package cm.chnsys.com.activemqdemo.old;

import cm.chnsys.com.activemqdemo.Qwe;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @Class: JmsProducer
 * @description: 消息生产者
 * @Author: hongzhi.zhao
 * @Date: 2019-06-24 15:37
 */
public class JmsProducer {

    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;   //默认的链接用户名
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;   //链接密码
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;   //默认的链接地址
    private static final int SENDNUM = 10;  //发送的消息数量


    public static void main(String[] args) {
        ConnectionFactory connectionFactory;  //链接工厂，生产connection
        Connection connection = null;  //链接
        Session session;  //会话  接收或者发送消息的线程（有事务）
        Destination destination; //消息的目的地
        MessageProducer messageProducer; //消息的发送者
        //实例化链接工厂
        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);

        //
        try {
            connection = connectionFactory.createConnection();  //通过链接 工程获取链接
            connection.start();     //启动链接
            //参数 第一个参数是否事务   第二个参数
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE); //创建Session
            //队列名称
           destination =  session.createQueue("FirstQueue1");
           //创建消息生产者   参数是目的地
           messageProducer = session.createProducer(destination);

           sendMessage(session,messageProducer);   //发送消息

            session.commit();  //因为有了事务，所以需要提交一下
        } catch (JMSException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
        for (int i = 0;i<=SENDNUM;i++){
           TextMessage textMessage = session.createTextMessage("ActiveMQ 发送的消息："+i);
            Qwe qwe = new Qwe();
            qwe.setId(1);
            qwe.setName("赵洪志");
            qwe.setSex("男");
           // ObjectMessage objectMessage = session.createObjectMessage(qwe);
            ObjectMessage objectMessage = session.createObjectMessage(qwe);
            System.out.println("发送消息："+"ActiveMQ 发送的消息"+qwe);
            //messageProducer.send(textMessage);
            messageProducer.send(objectMessage);
        }
    }
}
