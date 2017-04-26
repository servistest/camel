package edu.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by alex on 26.4.17.
 */
@WebService(endpointInterface = "edu.soap.HelloWorld")
public class HelloWorldNewImpl implements HelloWorld
{
  @WebMethod
  public String getHelloWorldAsString( String name, Integer count )
  {
    return "New implementation" + ' ' + name + ' ' +count;
  }

  @WebMethod
  public Integer getSumAsInteger( Integer a, Integer b )
  {
    return a*b;
  }
}
