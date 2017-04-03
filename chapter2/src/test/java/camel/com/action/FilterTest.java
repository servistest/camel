package camel.com.action;



import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.annotations.AfterMethod;

import static org.junit.Assert.*;

/**
 * Created by alex on 3.4.17.
 */
public class FilterTest extends CamelTestSupport {

    @EndpointInject(uri = "mock:result")
    MockEndpoint resultEndPoint;

    @Produce(uri = "direct:start")
    ProducerTemplate producerTemplate;


    @AfterMethod
    public void cleanUpContext()  throws Exception
    {
        context.stop();
    }

    @Test
    public void TestMatchingMessage()throws Exception{
        String expectBody="<matched/>";
        resultEndPoint.expectedBodiesReceived(expectBody);
        producerTemplate.sendBodyAndHeader(expectBody,"foo","bar");
        resultEndPoint.assertIsSatisfied();
    }

    @Test
    public void TestNotMatchingMessage() throws Exception{
            resultEndPoint.expectedMessageCount(0);
            resultEndPoint.setAssertPeriod(100);
            producerTemplate.sendBodyAndHeader("<matched/>","foo","notBar");
            resultEndPoint.assertIsSatisfied();
    }

    @Test
    public void TestMatchingCountMessage() throws Exception{
        resultEndPoint.setAssertPeriod(5000);
        resultEndPoint.expectedMessageCount(2);
        resultEndPoint.expectedBodiesReceived("message1","message2");

        producerTemplate.sendBody(resultEndPoint,"message1");
        producerTemplate.sendBody(resultEndPoint,"message2");

        resultEndPoint.assertIsSatisfied();
    }




    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start").filter(header("foo").isEqualTo("bar")).to("mock:result");
            }
        };
    }
}