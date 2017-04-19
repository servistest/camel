package com.freemark;

/**
 * Created by alex on 12.4.17.
 */
public class Errors
{
  private ErrorTypeCode errors;

  public ErrorTypeCode getErrors()
  {
    return errors;
  }

  public Errors setErrors( ErrorTypeCode errors )
  {
    this.errors = errors;
    return this;
  }
}
