/**
 *
 */
package it.tsc.webservice.domain;

import it.tsc.webservice.domain.types.Esito;

/**
 * @author "astraservice"
 *
 */
public class WsResult {
  private Esito esito;
  private String messaggioErrore;
  private int codiceErrore = 0;

  public WsResult() {
    super();
  }

  public WsResult(Esito esito, String messaggioErrore, int codiceErrore) {
    super();
    this.esito = esito;
    this.messaggioErrore = messaggioErrore;
    this.codiceErrore = codiceErrore;
  }

  public String getMessaggioErrore() {
    return messaggioErrore;
  }

  public void setMessaggioErrore(String messaggioErrore) {
    this.messaggioErrore = messaggioErrore;
  }

  public int getCodiceErrore() {
    return codiceErrore;
  }

  public void setCodiceErrore(int codiceErrore) {
    this.codiceErrore = codiceErrore;
  }

  public Esito getEsito() {
    return esito;
  }

  public void setEsito(Esito esito) {
    this.esito = esito;
  }

}
