package com.wugeek.auth.web.rpc;

import com.wugeek.auth.api.service.*;
import com.wugeek.auth.api.service.basic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pers.rabbitmq.config.RpcConfigBean;
import pers.rabbitmq.spring.ExchangeType;
import pers.rabbitmq.spring.channel.RabbitChannelFactory;
import pers.rabbitmq.spring.remoting.RabbitInvokerProxyFactoryBean;

/**
 * Created by guoshixiong on 2017/2/20.
 */
@Component
public class RpcInvokeBean {

    @Autowired
    ApplicationContext applicationContext;

    private final String QUEUE = "ltc.queue.";
    private final String KEY = "ltc.key.";

    //交换机
    private final String EXCHANGE = "ltc.exchange";

    //user服务
    private final String USER_KEY = KEY + "user";

    //category服务
    private final String USER_CATEGORY_KEY = KEY + "user.category";

    //role服务
    private final String ROLE_KEY = KEY + "role";

    //permission服务
    private final String PERMISSION_KEY = KEY + "permission";

    //api服务
    private final String API_KEY = KEY + "api";

    //permission category服务
    private final String PERMISSION_CATEGORY_KEY = KEY + "permission.category";

    //bind服务
    private final String BIND_KEY = KEY + "bind";

    //login服务
    private final String LOGIN_KEY = KEY + "login";

    //auth服务
    private final String AUTH_KEY = KEY + "auth";

    @Component
    class MyConfig extends RpcConfigBean {
    }

    //============================================= rpc服务注册 ========================================================

    /**
     * user服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean userService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(UserService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(USER_KEY);

        return factoryBean;
    }

    /**
     * user category服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean userCategoryService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(UserCategoryService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(USER_CATEGORY_KEY);

        return factoryBean;
    }

    /**
     * role服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean roleService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(RoleService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(ROLE_KEY);

        return factoryBean;
    }

    /**
     * permission服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean permissionService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(PermissionService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(PERMISSION_KEY);

        return factoryBean;
    }

    /**
     * api服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean apiService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(ApiService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(API_KEY);

        return factoryBean;
    }

    /**
     * bind服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean bindService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(BindService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(BIND_KEY);

        return factoryBean;
    }

    /**
     * permission category服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean permissionCategoryService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(PermissionCategoryService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(PERMISSION_CATEGORY_KEY);

        return factoryBean;
    }

    /**
     * login服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean loginService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(LoginService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(LOGIN_KEY);

        return factoryBean;
    }

    /**
     * login服务
     *
     * @return
     */
    @Bean
    public RabbitInvokerProxyFactoryBean authService() {
        RabbitInvokerProxyFactoryBean factoryBean = new RabbitInvokerProxyFactoryBean();
        factoryBean.setChannelFactory(applicationContext.getBean(RabbitChannelFactory.class));
        factoryBean.setServiceInterface(AuthService.class);
        factoryBean.setMandatory(true);
        factoryBean.setImmediate(false);
        factoryBean.setTimeoutMs(3000);
        factoryBean.setPoolSize(10);
        factoryBean.setExchangeType(ExchangeType.DIRECT);
        factoryBean.setExchange(EXCHANGE);
        factoryBean.setRoutingKey(AUTH_KEY);

        return factoryBean;
    }
}
