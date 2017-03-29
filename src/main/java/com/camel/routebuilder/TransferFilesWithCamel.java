package com.camel.routebuilder;

import org.apache.camel.Route;
import org.apache.camel.builder.RouteBuilder;

/**
 * Created by alex on 29.3.17.
 */
public class TransferFilesWithCamel extends RouteBuilder {
    public void configure() throws Exception {
        from("file:data/inbox?noop=true?delete=true")
                .to("file:data/outbox");
    }
}
