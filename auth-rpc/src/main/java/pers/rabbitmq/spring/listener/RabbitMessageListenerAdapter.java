package pers.rabbitmq.spring.listener;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.MethodInvoker;
import org.springframework.util.ObjectUtils;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import pers.rabbitmq.spring.ExchangeType;
import pers.rabbitmq.spring.channel.RabbitChannelFactory;

public class RabbitMessageListenerAdapter implements Consumer, InitializingBean {

    public static final String DEFAULT_LISTENER_METHOD = "handleMessage";
    public static final int DEFAULT_POOL_SIZE = 1;
    public static final String DEFAULT_ROUTING_KEY = "#";
    public static final ExchangeType DEFAULT_EXCHANGE_TYPE = ExchangeType.DIRECT;

    private final Log log = LogFactory.getLog(RabbitMessageListenerAdapter.class);

    private Object delegate;

    private RabbitChannelFactory channelFactory;
    private String exchange;
    private ExchangeType exchangeType = DEFAULT_EXCHANGE_TYPE;
    private String queueName;
    private String routingKey = DEFAULT_ROUTING_KEY;
    private String listenerMethod = DEFAULT_LISTENER_METHOD;
    private int poolsize = DEFAULT_POOL_SIZE;

    private Channel channel;

    public void afterPropertiesSet() throws Exception {

        exchangeType.validateRoutingKey(routingKey);

        startConsumer();
    }

    private void startConsumer() {
        if (channel == null || !channel.isOpen()) {
            try {
                channel = channelFactory.createChannel();
                String internalQueueName;
                if (queueName == null) {
                    // declare anonymous queue and get name for binding and consuming
                    internalQueueName = channel.queueDeclare().getQueue();
                } else {
                	//自动删除非持久队列
                    internalQueueName = channel.queueDeclare(queueName, false,false, true, null).getQueue();
                }
                channel.exchangeDeclare(exchange, exchangeType.toString());
                channel.queueBind(internalQueueName, exchange, routingKey);

                for (int i=1; i<=poolsize; i++) {
                    channel.basicConsume(internalQueueName, this);
                    log.info(String.format("Started consumer %d on exchange [%s(%s)] - queue [%s] - routingKey [%s]"
                            , i, exchange, exchangeType, queueName, routingKey));
                }
            } catch (IOException e) {
                log.warn("Unable start consumer", e);
            }
        }
    }

    public void setExchangeType(ExchangeType exchangeType) {
        this.exchangeType = exchangeType;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    @Required
    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @Required
    public void setChannelFactory(RabbitChannelFactory channelFactory) {
        this.channelFactory = channelFactory;
    }

    public void handleConsumeOk(String consumerTag) {
        if (log.isTraceEnabled()) {
            log.trace(String.format("handleConsumeOk [%s]", consumerTag));
        }
    }

    public void handleCancelOk(String consumerTag) {
        if (log.isTraceEnabled()) {
            log.trace(String.format("handleCancelOk [%s]", consumerTag));
        }
    }
    

	public void handleCancel(String consumerTag) throws IOException {
		 if (log.isTraceEnabled()) {
	            log.trace(String.format("handleCancel [%s]", consumerTag));
	        }
	}

	public void handleRecoverOk(String consumerTag) {
		 if (log.isTraceEnabled()) {
	            log.trace(String.format("handleRecoverOk [%s]", consumerTag));
	        }
	}
    
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException cause) {
        if (log.isInfoEnabled()) {
            log.info(String.format("Channel connection lost for reason [%s]", cause.getReason()));
            log.info(String.format("Reference [%s]", cause.getReference()));
        }

        if (cause.isInitiatedByApplication()) {
            if (log.isInfoEnabled()) {
                log.info("Sutdown initiated by application");
            }
        } else if (cause.isHardError()) {
            log.error("Shutdown is a hard error, trying to restart consumer(s)...");
            startConsumer();
        }
    }

    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {

        if (log.isDebugEnabled()) {
            log.debug(String.format("Handling message with tag [%s] on [%s]", consumerTag, envelope.getRoutingKey()));
        }
        try {

            Object message = SerializationUtils.deserialize(body);
            // Invoke the handler method with appropriate arguments.
            Object result = invokeListenerMethod(listenerMethod, new Object[]{message});

            if (result != null && result instanceof Serializable) {
                handleResult((Serializable) result, envelope, properties);
            } else {
                log.trace("No message object given - no message to handle");
            }
        } finally{
            channel.basicAck(envelope.getDeliveryTag(), false);
        }

    }

    private void handleResult(Serializable result, Envelope envelope, AMQP.BasicProperties properties) throws IOException {
        if (properties.getReplyTo() != null) {
            channel.basicPublish(envelope.getExchange(), properties.getReplyTo(), null, SerializationUtils.serialize(result));
        }
    }

    protected Object invokeListenerMethod(String methodName, Object[] arguments) {
        try {
            MethodInvoker methodInvoker = new MethodInvoker();
            methodInvoker.setTargetObject(getDelegate());
            methodInvoker.setTargetMethod(methodName);
            methodInvoker.setArguments(arguments);
            methodInvoker.prepare();
            return methodInvoker.invoke();
        }
        catch (InvocationTargetException ex) {
            Throwable targetEx = ex.getTargetException();
            throw new ListenerExecutionFailedException(
                    "Listener method '" + methodName + "' threw exception", targetEx);
        }
        catch (Throwable ex) {
            throw new ListenerExecutionFailedException("Failed to invoke target method '" + methodName +
                    "' with arguments " + ObjectUtils.nullSafeToString(arguments), ex);
        }
    }

    @Required
    public void setDelegate(Object delegate) {
        this.delegate = delegate;
    }

    public Object getDelegate() {
        return delegate;
    }

    public void setRoutingKey(String routingKey) {
        this.routingKey = routingKey;
    }

    public void setListenerMethod(String listenerMethod) {
        this.listenerMethod = listenerMethod;
    }

    public void setPoolsize(int poolsize) {
        this.poolsize = poolsize;
    }

    private static class ListenerExecutionFailedException extends RuntimeException {
		private static final long serialVersionUID = 1L;

		public ListenerExecutionFailedException(String s, Throwable targetEx) {
            super(s, targetEx);
        }
    }
}
