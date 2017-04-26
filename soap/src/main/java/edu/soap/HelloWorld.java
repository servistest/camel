package edu.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by ALex on 23.04.2017.
 */
@WebService
public interface HelloWorld {

    @WebMethod
    public String getHelloWorldAsString(String name, Integer count);

    @WebMethod
    public Integer getSumAsInteger(Integer a,Integer b);
}
