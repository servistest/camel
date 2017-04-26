package edu.soap;

import javax.xml.ws.Endpoint;

/**
 * Created by ALex on 23.04.2017.
 */
public class HelloWorldPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello",new HelloWorldImpl());
        Endpoint.publish("http://localhost:9999/ws/hellonew",new HelloWorldNewImpl());
    }
}
