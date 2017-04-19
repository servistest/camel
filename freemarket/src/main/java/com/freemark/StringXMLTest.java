package com.freemark;

/**
 * Created by alex on 12.4.17.
 */


  import java.io.IOException;
  import java.io.OutputStreamWriter;
  import java.util.HashMap;
  import java.util.Map;

  import freemarker.template.Configuration;
  import freemarker.template.Template;
  import freemarker.template.TemplateException;

public class StringXMLTest {


  public static void main(String[] args) throws IOException, TemplateException  {


    Configuration cfg = new Configuration();
    cfg.setClassForTemplateLoading(StringXMLTest.class, "/");
    Template template = cfg.getTemplate("xml.ftl");

    //Prepare data model

    Map<String, Object> dataModel = new HashMap<String, Object>();

    Errors errors=new Errors();

    Body body=new Body();
    Failure failure=new Failure();

    body.setFailure( failure);


//    dataModel.put( "body.failure.errors","errors=00000" );
//    dataModel.put( "body",new Body().setFailure( "ere" ) );
    dataModel.put( "msg","Start Sell Date in ABR must be <= Stay Period Start Dat");
    dataModel.put( "errType","Start Sell Date in ABR must be <= Stay Period Start Dat");
//    dataModel.put("msg",
//      "<html><body>" +
//        "'One', 'two', \"Three & Four\"" +
//        "</body></html>");

    //Merge template and data
    OutputStreamWriter output = new OutputStreamWriter(System.out);
    template.process(dataModel, output);

  }

}