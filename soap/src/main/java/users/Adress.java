package users;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by alex on 17.4.17.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Adress", propOrder = {
  "city",
  "street",
  "house"
})
public class Adress
{

  private String city;
  private String street;
  private String house;

  public String getCity()
  {
    return city;
  }

  public Adress setCity( String city )
  {
    this.city = city;
    return this;
  }

  public String getStreet()
  {
    return street;
  }

  public Adress setStreet( String street )
  {
    this.street = street;
    return this;
  }

  public String getHouse()
  {
    return house;
  }

  public Adress setHouse( String house )
  {
    this.house = house;
    return this;
  }
}
