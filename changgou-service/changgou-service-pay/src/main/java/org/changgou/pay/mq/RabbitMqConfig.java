package org.changgou.pay.mq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * 功能描述:
 * 项目名称:changgou-parent
 * 创建日期:2020/5/4
 *
 * @author Lenovo
 */
@Configuration
public class RabbitMqConfig {
    /**
     * 定义环境变量
     */
    @Resource
    private Environment environment;

    /**
     * 创建队列
     */
    @Bean
    public Queue queue() {
        return new Queue(environment.getProperty("mq.pay.queue.order"));
    }

    /**
     * 创建交换机
     */
    @Bean
    public Exchange exchange() {
        return new DirectExchange(environment.getProperty("mq.pay.exchange.order"), true, false);
    }

    /**
     * 队列绑定
     */
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(environment.getProperty("mq.pay.routing.key")).noargs();
    }
}
