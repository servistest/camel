import com.sun.xml.internal.org.jvnet.mimepull.MIMEConfig;

import javax.xml.soap.*;
import java.io.IOException;

/**
 * Created by alex on 19.4.17.
 */
public class ClentSoap
{
  public static void main( String[] args )
    throws SOAPException, IOException
  {
    SOAPConnectionFactory soapConnectionFactory=SOAPConnectionFactory.newInstance();
    SOAPConnection soapConnection=soapConnectionFactory.createConnection();

    String url="http://ws.cdyne.com/emailverify/Emailvernotestemail.asmx";

    SOAPMessage soapResponse= soapConnection.call( createSoapRequest(),url );

    // print SOAP response
    System.out.print("Response SOAP Message:");
    soapResponse.writeTo( System.out );

    soapConnection.close();

  }

  public static SOAPMessage createSoapRequest()
    throws SOAPException, IOException
  {
    MessageFactory messageFactory=MessageFactory.newInstance();
    SOAPMessage soapMessage=messageFactory.createMessage();

    SOAPPart soapPart=soapMessage.getSOAPPart();

    String serverUri="http://ws.cdyne.com/";

    //SOAP Envelope

    SOAPEnvelope soapEnvelope=soapPart.getEnvelope();
    soapEnvelope.addNamespaceDeclaration( "example",serverUri );

     /*
        Constructed SOAP Request Message:
        <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/" xmlns:example="http://ws.cdyne.com/">
            <SOAP-ENV:Header/>
            <SOAP-ENV:Body>
                <example:VerifyEmail>
                    <example:email>mutantninja@gmail.com</example:email>
                    <example:LicenseKey>123</example:LicenseKey>
                </example:VerifyEmail>
            </SOAP-ENV:Body>
        </SOAP-ENV:Envelope>
         */


     // SOAP Body
    SOAPBody soapBody = soapEnvelope.getBody();
    SOAPElement soapBodyElem1 = soapBody.addChildElement("VerifyEmail", "example");
    SOAPElement soapBodyElem2 = soapBodyElem1.addChildElement("email", "example");
    soapBodyElem2.addTextNode("mutantninja@gmail.com");
    SOAPElement soapBodyElem3 = soapBodyElem1.addChildElement("LicenseKey", "example");
    soapBodyElem3.addTextNode("123");

    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", serverUri  + "VerifyEmail");

    soapMessage.saveChanges();



    soapMessage.saveChanges();

    //print Request

    System.out.println("Request SOAP Message");
    soapMessage.writeTo( System.out );
    System.out.println(  );

    return soapMessage;




  }
}
