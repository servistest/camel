package com.soapws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 18.4.17.
 */
@WebService
public class ProductCatalog
{
  @WebMethod
  public List<String> getProducts(){
      List<String> listProducts=new ArrayList<>(  );
      listProducts.add( "Testo" );
      listProducts.add( "Butter" );
      listProducts.add( "Cheees" );
      return listProducts;
  }
}
