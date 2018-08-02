package com.cloud.service.B.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    /**
     *
     * Hello队列
     * @return
     */
    @Bean
    public Queue HelloQueue () {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("x-dead-letter-exchange", "dead_letter_exchange");//设置死信交换机
        map.put("x-dead-letter-routing-key", "hello_queue_fail");//设置死信routingKey
        return new Queue("hello-queue",true, false, false, map);
    }

    /**
     * 队列处理交换机
     * @return
     */

    @Bean
    public DirectExchange docExchange() {
        return new DirectExchange("helloExchange", true, false);
    }


    /**
     * 队列绑定业务处理交换机
     * @return
     */
    @Bean
    public Binding mailBinding() {
        return BindingBuilder.bind(HelloQueue()).to(docExchange())
                .with("hello_queue_fail");
    }


    /**
     * 死信队列
     * @return
     */
    @Bean
    public Queue deadQueue(){
        return new Queue("dead-queue", true);
    }


    /**
     * 死信交换机
     * @return
     */
    @Bean
    public DirectExchange deadExchange() {
        return new DirectExchange("dead_letter_exchange", true, false);
    }


    @Bean
    public Binding deadLetterBindding(){
        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("hello_queue_fail");
    }

}
