package cn.com.chnsys.rabbitmq.test;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Class: MQConfig
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-06-14 14:48
 */
@Configuration
public class MQConfig {

    //第一种，简单的队列

    public static final String QUEUE = "queue";

    public static final String TOPIC_QUEUE1 = "topic.queue1";

    public static final String TOPIC_QUEUE2 = "topic.queue2";

    //exchange
    //public static final String TOPIC_EXCHANGE = "topicExchange";
    //重点来了，不能叫topicExchange,如果写了这个就都能收到
    public static final String TOPIC_EXCHANGE = "topicExchage";




    /*
    * Direct 交换机Exchange
    * */
    @Bean
    public Queue queue(){
        return  new Queue(QUEUE,true);
    }


    /*
    * topic 交换机Exchange
    * */
    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1, true);
    }
    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2, true);
    }
    @Bean
    public TopicExchange topicExchage(){
        return new TopicExchange(TOPIC_EXCHANGE);
    }
    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchage()).with("topic.key1");
    }
    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchage()).with("topic.#");
    }



}
