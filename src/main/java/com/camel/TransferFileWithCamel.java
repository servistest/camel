package com.camel;


import com.camel.routebuilder.LogMessageOnTimer;
import com.camel.routebuilder.TransferFilesWithCamel;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by alex on 28.3.17.
 */
public class TransferFileWithCamel {
    public static void main(String[] args) throws Exception {
        Logger log = LoggerFactory.getLogger(TransferFileWithCamel.class);

        CamelContext camelContext=new DefaultCamelContext();
        camelContext.addRoutes(new TransferFilesWithCamel());
        camelContext.addRoutes(new LogMessageOnTimer());
        camelContext.start();
        Thread.sleep(5000);
        camelContext.stop();
    }
}
