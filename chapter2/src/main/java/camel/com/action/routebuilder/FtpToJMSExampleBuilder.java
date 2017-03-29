package camel.com.action.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by alex on 29.3.17.
 */
public class FtpToJMSExampleBuilder extends RouteBuilder {
    public void configure() throws Exception {
        from("ftp://localhost/order?username=alex&password=jabutnm")
                .choice()
                    .when(header("CamelFileName").endsWith(".txt"))
                        .to("jms:txtIncomingOrders")
                    .when(header("CamelFileName").endsWith(".xml"))
                        .to("jms:xmlIncomingOrders")
                    .otherwise()
                        .to("jms:badIncomingOrders");


        from("jms:txtIncomingOrders")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Received txt order  - "+exchange.getIn().getHeader("CamelFileName"));
                    }
                });
        from("jms:xmlIncomingOrders")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Received xml order - "+exchange.getIn().getHeader("CamelFileName"));
                    }
                });
        from("jms:badIncomingOrders")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Received bad order - "+exchange.getIn().getHeader("CamelFileName"));
                    }
                });


    }
}
