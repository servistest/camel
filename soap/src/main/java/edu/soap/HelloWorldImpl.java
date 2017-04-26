package edu.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by ALex on 23.04.2017.
 */
@WebService  (endpointInterface = "edu.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld{


    @WebMethod
    public String getHelloWorldAsString(String name,Integer count) {
        return "hello world" + ' ' + name + ' ' +count;
    }

    @WebMethod
    public Integer getSumAsInteger( Integer a, Integer b )
    {
        return a+b;
    }
}
