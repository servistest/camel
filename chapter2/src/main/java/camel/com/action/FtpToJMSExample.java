package camel.com.action;

import camel.com.action.routebuilder.FtpToJMSExampleBuilder;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

/**
 * Created by alex on 29.3.17.
 */
public class FtpToJMSExample {
    public static void main(String[] args) throws Exception {

        CamelContext camelContext=new DefaultCamelContext();

        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory("vm://localhost");
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        camelContext.addRoutes(new FtpToJMSExampleBuilder());

        camelContext.start();
        Thread.sleep(5000);
        camelContext.stop();

    }
}
