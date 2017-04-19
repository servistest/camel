package users;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by alex on 17.4.17.
 */
@XmlRootElement

public class TestU
{
  private Long id;
  private String field1;
  private String field2;

  public Long getId()
  {
    return id;
  }

  public TestU setId( Long id )
  {
    this.id = id;
    return this;
  }

  public String getField1()
  {
    return field1;
  }

  public TestU setField1( String field1 )
  {
    this.field1 = field1;
    return this;
  }

  public String getField2()
  {
    return field2;
  }

  public TestU setField2( String field2 )
  {
    this.field2 = field2;
    return this;
  }
}
