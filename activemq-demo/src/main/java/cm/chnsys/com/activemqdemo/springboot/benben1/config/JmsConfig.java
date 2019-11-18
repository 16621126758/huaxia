package cm.chnsys.com.activemqdemo.springboot.benben1.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import javax.jms.ConnectionFactory;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

/**
 * @Class: JmsConfig
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-27 10:19
 */
@Configuration
public class JmsConfig {
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }
    @Bean
    public javax.jms.Queue queue(){
        return new ActiveMQQueue("topic.text3");
    }




}
