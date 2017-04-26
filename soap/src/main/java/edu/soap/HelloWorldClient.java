package edu.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ALex on 23.04.2017.
 */
public class HelloWorldClient
{
  public static void main( String[] args )
    throws MalformedURLException
  {

    URL url = new URL( "http://localhost:9999/ws/hello?wsdl" );
//        HelloWorldImplService - is ServiceName in the wsdl
    QName qname = new QName( "http://soap.edu/", "HelloWorldImplService" );

    Service service = Service.create( url, qname );

    HelloWorld hello = service.getPort( HelloWorld.class );

    System.out.println( hello.getHelloWorldAsString( "Alex", 10 ) );
    System.out.println( hello.getSumAsInteger( 10, 15 ) );



    URL url2 = new URL( "http://localhost:9999/ws/hellonew?wsdl" );
    QName qName2 = new QName( "http://soap.edu/", "HelloWorldNewImplService" );

    Service service1 = Service.create( url2, qName2 );
    HelloWorld helloWorld2 = service1.getPort( HelloWorld.class );

    System.out.println(helloWorld2.getHelloWorldAsString( "Serg",10 ));
    System.out.println(helloWorld2.getSumAsInteger( 40,50 ));


  }
}
