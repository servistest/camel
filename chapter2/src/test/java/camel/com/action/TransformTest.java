package camel.com.action;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

/**
 * Created by alex on 3.4.17.
 */
public class TransformTest extends CamelTestSupport {

    @EndpointInject(uri = "mock:result")
    MockEndpoint resultEndPoint;

    @EndpointInject(uri = "mock:direct:foo")
    MockEndpoint fooEndPoint;

    @EndpointInject(uri = "mock:log:foo")
    MockEndpoint logFooEndPoint;

    //uri without mock : "mock:"direct:start" -error!!!
    @Produce(uri = "direct:start")
    ProducerTemplate startEndPoint;


    @Override
    public String isMockEndpoints() {
        // override this method and ret
        // urn the pattern for which endpoints to mock.
        // use * to indicate all
        //If you only want to mock all log endpoints you can return "log*" instead
        return "*";
    }

    @Test
    public void TestRoute() throws InterruptedException {
        String body="Hello World";
        String transformBody="Bye World";

        fooEndPoint.expectedBodiesReceived(body);
//        or
//        getMockEndpoint("mock:direct:foo").expectedBodiesReceived("Hello World");
        logFooEndPoint.expectedBodiesReceived(transformBody);
        startEndPoint.sendBody(body);
//        or
//        template.sendBody("direct:start",body);

//        assertMockEndpointsSatisfied();
//        or
        fooEndPoint.assertIsSatisfied();
        logFooEndPoint.assertIsSatisfied();
        resultEndPoint.assertIsSatisfied();
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
