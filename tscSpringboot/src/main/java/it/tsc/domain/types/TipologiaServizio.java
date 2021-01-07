/**
 *
 */
package it.tsc.domain.types;

/**
 * @author "astraservice"
 *
 */
public enum TipologiaServizio {
  CONSULENZA(0), INVIO_MEDICO(1);

  private final int numVal;

  TipologiaServizio(int numVal) {
    this.numVal = numVal;
  }

  public int getNumVal() {
    return numVal;
  }

}
