package com.wugeek.auth.service.rpc;

import com.wugeek.auth.api.service.AuthService;
import com.wugeek.auth.api.service.BindService;
import com.wugeek.auth.api.service.LoginService;
import com.wugeek.auth.api.service.basic.*;
import com.wugeek.auth.service.service.impl.AuthServiceImpl;
import com.wugeek.auth.service.service.impl.BindServiceImpl;
import com.wugeek.auth.service.service.impl.LoginServiceImpl;
import com.wugeek.auth.service.service.impl.basic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pers.rabbitmq.config.RpcConfigBean;
import pers.rabbitmq.spring.ExchangeType;
import pers.rabbitmq.spring.channel.RabbitChannelFactory;
import pers.rabbitmq.spring.remoting.RabbitInvokerServiceExporter;

/**
 * Created by guoshixiong on 2017/2/16.
 */
@Component
public class RpcServiceBean {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${project}")
    public String project;

    private String QUEUE;
    private String KEY;

    //交换机
    private String EXCHANGE;

    //user服务
    private String USER_QUEUE;
    private String USER_KEY;

    //category服务
    private String USER_CATEGORY_QUEUE;
    private String USER_CATEGORY_KEY;

    //role服务
    private String ROLE_QUEUE;
    private String ROLE_KEY;

    //permission服务
    private String PERMISSION_QUEUE;
    private String PERMISSION_KEY;

    //api服务
    private String API_QUEUE;
    private String API_KEY;

    //permission category服务
    private String PERMISSION_CATEGORY_QUEUE;
    private String PERMISSION_CATEGORY_KEY;

    //bind服务
    private String BIND_QUEUE;
    private String BIND_KEY;

    //login服务
    private String LOGIN_QUEUE;
    private String LOGIN_KEY;

    //auth服务
    private String AUTH_QUEUE;
    private String AUTH_KEY;

    private void init() {
        QUEUE = project + ".queue.";
        KEY = project + ".key.";
        EXCHANGE = project + ".exchange";

        USER_QUEUE = QUEUE + "user";
        USER_KEY = KEY + "user";

        USER_CATEGORY_QUEUE = QUEUE + "user.category";
        USER_CATEGORY_KEY = KEY + "user.category";

        ROLE_QUEUE = QUEUE + "role";
        ROLE_KEY = KEY + "role";

        PERMISSION_QUEUE = QUEUE + "permission";
        PERMISSION_KEY = KEY + "permission";

        API_QUEUE = QUEUE + "api";
        API_KEY = KEY + "api";

        PERMISSION_CATEGORY_QUEUE = QUEUE + "permission.category";
        PERMISSION_CATEGORY_KEY = KEY + "permission.category";

        BIND_QUEUE = QUEUE + "bind";
        BIND_KEY = KEY + "bind";

        LOGIN_QUEUE = QUEUE + "login";
        LOGIN_KEY = KEY + "login";

        AUTH_QUEUE = QUEUE + "auth";
        AUTH_KEY = KEY + "auth";
    }

    @Component
    class MyConfig extends RpcConfigBean {
    }

    //==============================================远程调用服务配置==============================================

    /**
     * user服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter userServiceExport() {
        init();

        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(UserService.class);
        exporter.setService(applicationContext.getBean(UserServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(USER_QUEUE);
        exporter.setRoutingKey(USER_KEY);

        return exporter;
    }

    /**
     * user category服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter userCategoryServiceExport() {
        init();

        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(UserCategoryService.class);
        exporter.setService(applicationContext.getBean(UserCategoryServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(USER_CATEGORY_QUEUE);
        exporter.setRoutingKey(USER_CATEGORY_KEY);

        return exporter;
    }

    /**
     * role服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter roleServiceExport() {
        init();

        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(RoleService.class);
        exporter.setService(applicationContext.getBean(RoleServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(ROLE_QUEUE);
        exporter.setRoutingKey(ROLE_KEY);

        return exporter;
    }

    /**
     * permission服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter permissionServiceExport() {
        init();

        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(PermissionService.class);
        exporter.setService(applicationContext.getBean(PermissionServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(PERMISSION_QUEUE);
        exporter.setRoutingKey(PERMISSION_KEY);

        return exporter;
    }

    /**
     * api服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter apiServiceExport() {
        init();

        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(ApiService.class);
        exporter.setService(applicationContext.getBean(ApiServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(API_QUEUE);
        exporter.setRoutingKey(API_KEY);

        return exporter;
    }

    /**
     * bind服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter bindServiceExport() {
        init();

        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(BindService.class);
        exporter.setService(applicationContext.getBean(BindServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(BIND_QUEUE);
        exporter.setRoutingKey(BIND_KEY);

        return exporter;
    }

    /**
     * permission category服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter permissionCategoryServiceExport() {
        init();

        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(PermissionCategoryService.class);
        exporter.setService(applicationContext.getBean(PermissionCategoryServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(PERMISSION_CATEGORY_QUEUE);
        exporter.setRoutingKey(PERMISSION_CATEGORY_KEY);

        return exporter;
    }

    /**
     * login服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter loginServiceExport() {

        init();
        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(LoginService.class);
        exporter.setService(applicationContext.getBean(LoginServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(LOGIN_QUEUE);
        exporter.setRoutingKey(LOGIN_KEY);

        return exporter;
    }

    /**
     * auth服务
     *
     * @return RabbitInvokerServiceExporter
     */
    @Bean
    RabbitInvokerServiceExporter authServiceExport() {
        init();

        RabbitInvokerServiceExporter exporter = new RabbitInvokerServiceExporter();
        exporter.setServiceInterface(AuthService.class);
        exporter.setService(applicationContext.getBean(AuthServiceImpl.class));
        exporter.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        exporter.setPoolsize(5);
        exporter.setExchangeType(ExchangeType.DIRECT);
        exporter.setExchange(EXCHANGE);
        exporter.setQueueName(AUTH_QUEUE);
        exporter.setRoutingKey(AUTH_KEY);

        return exporter;
    }
}
