/**
 *
 */
package it.tsc.webservice.domain.types;

import it.tsc.webservice.domain.ConvertibleAdapter;

/**
 * @author "astraservice"
 *
 */
public enum TipologiaConsulenza implements ConvertibleAdapter {
  SCRITTA(0), PHONE(1);

  private int numVal;

  TipologiaConsulenza(int numVal) {
    this.numVal = numVal;
  }

  public int getNumVal() {
    return numVal;
  }

  @Override
  public boolean convertibleAs(String convertible) {
    TipologiaConsulenza.valueOf(convertible);
    return false;
  }
}
