/**
 *
 */
package it.tsc.webservice.domain;

/**
 * @author "astraservice"
 *
 */
public enum TipologiaConsulenza {
  SCRITTA(0), PHONE(1);

  private int numVal;

  TipologiaConsulenza(int numVal) {
    this.numVal = numVal;
  }

  public int getNumVal() {
    return numVal;
  }
}
