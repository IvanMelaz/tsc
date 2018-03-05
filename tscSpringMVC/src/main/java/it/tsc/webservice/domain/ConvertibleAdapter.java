/**
 *
 */
package it.tsc.webservice.domain;

/**
 * @author "astraservice"
 *
 */
public interface ConvertibleAdapter {

  /**
   * determin if object is convertible as Type
   *
   * @param convertibleObject
   * @return
   */
  public boolean convertibleAs(String convertible);

}
