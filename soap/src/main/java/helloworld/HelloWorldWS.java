package helloworld;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by alex on 17.4.17.
 */
@WebService
public class HelloWorldWS

{
  HelloWorld helloWorld;

  @WebMethod(operationName = "getHelloWorld")
  public String  getHelloWorld()
  {
    return helloWorld.getHelloWorld();
  }


  @WebMethod(exclude = true)
  public HelloWorldWS setHelloWorld( HelloWorld helloWorld )
  {
    this.helloWorld = helloWorld;
    return this;
  }



}
