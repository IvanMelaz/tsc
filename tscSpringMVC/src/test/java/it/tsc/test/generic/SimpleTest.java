/**
 *
 */
package it.tsc.test.generic;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author ivan.melzani@beta80group.it
 *
 */
public class SimpleTest {

  /**
   *
   */
  public SimpleTest() {
    // TODO Auto-generated constructor stub
  }

  /**
   * @param args
   */
  @Test
  public void test() {
    // TODO Auto-generated method stub
    List<String> list = new ArrayList<String>();
    for (Provenienza prov : Provenienza.values()) {
      if (Provenienza.valueOf(prov.name()) instanceof Provenienza) {
        list.add(prov.name());
      }
    }
    System.out.println(list);
  }

  public enum Provenienza {
    MAGAZZINO, ACQUISTO, ACQUISTO_NON_AMMINISTRATIVO;
  }

}
