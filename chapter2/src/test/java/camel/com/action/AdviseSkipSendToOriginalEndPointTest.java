package camel.com.action;


import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

/**
 * Created by alex on 3.4.17.
 */
public  class AdviseSkipSendToOriginalEndPointTest extends CamelTestSupport{

    @Test
    public void AdviceTesting() throws Exception {
        context.getRouteDefinitions().get(0).adviceWith(context, new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                interceptSendToEndpoint("mock:result")
                        .skipSendToOriginalEndpoint()
                        .to("log:foo")
                        .to("mock:log:foo")
                        .to("mock:advice");

            }
        });

        getMockEndpoint("mock:result").expectedMessageCount(0);
        getMockEndpoint("mock:advice").expectedMessageCount(1);
        getMockEndpoint("mock:log:foo").expectedMessageCount(1);

        template.sendBody("direct:start","Hello");
        assertMockEndpointsSatisfied();
    }

    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start").to("direct:foo").to("log:foo").to("mock:result");
                from("direct:foo").transform(constant("Bye World"));
            }
        } ;
    }
}
