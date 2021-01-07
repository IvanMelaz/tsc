/**
 *
 */
package it.tsc.domain.types;

/**
 * @author "astraservice"
 *
 */
public enum TipologiaConsulenza {
  SCRITTA(0), PHONE(1);

  private final int numVal;

  TipologiaConsulenza(int numVal) {
    this.numVal = numVal;
  }

  public int getNumVal() {
    return numVal;
  }

}
