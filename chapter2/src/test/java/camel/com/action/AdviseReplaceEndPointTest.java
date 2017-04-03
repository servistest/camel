package camel.com.action;


import org.apache.camel.EndpointInject;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by alex on 3.4.17.
 */
public class AdviseReplaceEndPointTest extends CamelTestSupport {

    @EndpointInject(uri = "mock:direct:foo")
    MockEndpoint directFooEndPoint;

    @EndpointInject(uri = "mock:log:foo")
    MockEndpoint logFooEndPoint;
    @Test
    public void AdviceTesting() throws Exception {

        context.getRouteDefinitions().get(0).adviceWith(context, new AdviceWithRouteBuilder() {
            @Override
            public void configure() throws Exception {
                weaveById("foo")
                        .before()
                        .to(directFooEndPoint)
                        .transform(constant("Transform"))
                        .to(logFooEndPoint);

            }
        });
        directFooEndPoint.expectedMessageCount(1);
        logFooEndPoint.expectedMessageCount(1);
        logFooEndPoint.expectedBodiesReceived("Transform");
//        getMockEndpoint("mock:log:foo").expectedMessageCount(1);
        template.sendBody("direct:start","Hello");
        assertMockEndpointsSatisfied();
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .to("direct:foo").id("foo")
                        .to("log:foo")
                        .to("mock:result");
                from("direct:foo").transform(constant("Bye World"));
            }
        } ;
    }
}
