package com.freemark;

/**
 * Created by alex on 12.4.17.
 */
public class Failure
{
  private Errors errors;

  public Errors getErrors()
  {
    return errors;
  }

  public Failure setErrors( Errors errors )
  {
    this.errors = errors;
    return this;
  }
}
