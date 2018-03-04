/**
 *
 */
package it.tsc.webservice.domain;

/**
 * @author "astraservice"
 *
 */
public enum TipologiaServizio {
  CONSULENZA(0), INVIO_MEDICO(1);

  private int numVal;

  TipologiaServizio(int numVal) {
    this.numVal = numVal;
  }

  public int getNumVal() {
    return numVal;
  }
}
