package edu.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ALex on 23.04.2017.
 */
public class HelloWorldClient {
    public static void main(String[] args) throws MalformedURLException {
//        URL url=new URL("http://localhost:9999/ws/hello?wsdl");
//        QName qName=new QName("http://soap.edu/","HelloWorldImplService");
//
//        Service service =Service.create(url,qName);
//
//        HelloWorld helloWorld=service.getPort(qName,HelloWorld.class);
//
//        System.out.println(helloWorld.getHelloWorldAsString("Alex"));
        URL url = new URL("http://localhost:9999/ws/hello?wsdl");
        QName qname = new QName("http://soap.edu/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        System.out.println(hello.getHelloWorldAsString("mkyong"));



    }
}
