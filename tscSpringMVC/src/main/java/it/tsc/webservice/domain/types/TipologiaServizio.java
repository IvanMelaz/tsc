/**
 *
 */
package it.tsc.webservice.domain.types;

import it.tsc.webservice.domain.ConvertibleAdapter;

/**
 * @author "astraservice"
 *
 */
public enum TipologiaServizio implements ConvertibleAdapter {
  CONSULENZA(0), INVIO_MEDICO(1);

  private int numVal;

  TipologiaServizio(int numVal) {
    this.numVal = numVal;
  }

  public int getNumVal() {
    return numVal;
  }

  @Override
  public boolean convertibleAs(String convertible) {
    return false;
  }
}
