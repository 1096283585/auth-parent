package pers.rabbitmq.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pers.rabbitmq.spring.channel.RabbitChannelFactory;
import pers.rabbitmq.spring.connection.RabbitConnectionFactory;

/**
 * Created by guoshixiong on 2017/2/20.
 */
@Component
public class RpcConfigBean {

    @Value("${rabbit.hosts}")
    public String[] hosts;
    @Value("${rabbit.username}")
    public String user;
    @Value("${rabbit.password}")
    public String password;
    @Value("${rabbit.virtualHost}")
    public String virtualHost;

    //#################################################远程调用基本配置##################################################
    @Bean
    ConnectionFactory connectionFactory() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setUsername(user);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(virtualHost);

        return connectionFactory;
    }

    @Bean
    RabbitConnectionFactory myRabbitConnectionFactory() {
        RabbitConnectionFactory factory = new RabbitConnectionFactory();
        factory.setConnectionFactory(connectionFactory());
        factory.setHosts(hosts);

        return factory;
    }

    @Bean
    public RabbitChannelFactory rabbitChannelFactory() {
        RabbitChannelFactory factory = new RabbitChannelFactory();
        factory.setConnectionFactory(myRabbitConnectionFactory());

        return factory;
    }
}
