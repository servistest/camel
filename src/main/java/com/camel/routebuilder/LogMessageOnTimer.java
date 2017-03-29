package com.camel.routebuilder;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by alex on 29.3.17.
 */
public class LogMessageOnTimer extends RouteBuilder {
    public void configure() throws Exception {
        from("timer:logMessageTimer?period=1s")
                .log("Event triggered ${property.CamelTimerName}" +
                        " timer period = ${property.CamelTimerPeriod}" +
                    "at ${header.CamelTimerFiredTime}")
        .to("bean:inBean");
    }
}
