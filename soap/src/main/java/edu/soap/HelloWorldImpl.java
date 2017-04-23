package edu.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by ALex on 23.04.2017.
 */
@WebService
//        (endpointInterface = "edu.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld{


    @WebMethod
    public String getHelloWorldAsString(String name) {
        return "hello world" + name;
    }
}
