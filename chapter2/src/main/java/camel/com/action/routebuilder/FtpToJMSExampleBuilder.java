package camel.com.action.routebuilder;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.dataformat.XmlJsonDataFormat;

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
//                        .to("jms:xmlIncomingOrders")
                          .to("direct:marshal")
                    .otherwise()
                        .to("jms:badIncomingOrders");


        from("jms:txtIncomingOrders")
                .setBody(body().append("add STRING"))
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Received txt order  - "+exchange.getIn().getHeader("CamelFileName"));
                    }
                })
                .to("file:orderout");


        XmlJsonDataFormat xmlJsonFormat = new XmlJsonDataFormat();
        from("direct:marshal")
//                .marshal()
//                .xmljson()
//                .marshal().json(JsonLibrary.Jackson)
//                .marshal(xmlJsonFormat)
//                .process(new Processor() {
//                    public void process(Exchange exchange) throws Exception {
//                        System.out.println("Received xml order - "+exchange.getIn().getHeader("CamelFileName"));
//                    }
//                })
                .to("file://orderout");


        from("jms:badIncomingOrders")
                .process(new Processor() {
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("Received bad order - "+exchange.getIn().getHeader("CamelFileName"));
                    }
                });


    }
}
