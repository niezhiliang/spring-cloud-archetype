package com.cloud.service.B.queueshander;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Random;

@Component
public class HelloHandler {
    private Logger logger = LoggerFactory.getLogger(HelloHandler.class);

    @RabbitListener(queues = "hello-queue")
    public void receiveMessage(Message message, Channel channel) throws Exception {
        logger.info(new String(message.getBody()));

        try {

            if (new Random().nextInt(1000)%2 == 0) {
                logger.error("即将放入死信队列");
                int i = 1/0;
            } else {
                logger.info("Receive from Hello Queue :"+new String(message.getBody()));
            }

        } catch (Exception e) {
            //如果队列处理异常 则手动返回 防止队列一直循环处理
            try {
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false);
            } catch (IOException ee) {
                ee.printStackTrace();
            }
        }
    }
}
