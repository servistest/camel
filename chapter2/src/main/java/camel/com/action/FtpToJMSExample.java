package camel.com.action;

import camel.com.action.routebuilder.FtpToJMSExampleBuilder;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.LoggingLevel;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.processor.interceptor.Tracer;

import javax.jms.ConnectionFactory;

/**
 * Created by alex on 29.3.17.
 */
public class FtpToJMSExample {
    public static void main(String[] args) throws Exception {

        CamelContext camelContext=new DefaultCamelContext();

        Tracer tracer = new Tracer();
// set the level to FATAL so we can easily spot it
        tracer.setLogLevel( LoggingLevel.DEBUG);
// and only trace if the body contains London as text
//        tracer.setTraceFilter(body().contains(constant("London")));
        camelContext.setTracing(true);



        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("vm://localhost");
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        camelContext.addRoutes(new FtpToJMSExampleBuilder());

        camelContext.start();
        Thread.sleep(5000);
        camelContext.stop();

    }
}
