/**
 *
 */
package it.tsc.test.generic;

import org.junit.Test;

import it.tsc.webservice.domain.types.TipologiaServizio;

/**
 * @author "astraservice"
 *
 */
public class EnumTest {

  /**
   *
   */
  public EnumTest() {
    // TODO Auto-generated constructor stub
  }

  @Test
  public void testEnum() {
    TipologiaServizio.valueOf("pippo");
  }

}
