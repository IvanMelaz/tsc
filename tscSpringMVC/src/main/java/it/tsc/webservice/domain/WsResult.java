/**
 *
 */
package it.tsc.webservice.domain;

/**
 * @author "astraservice"
 *
 */
public class WsResult {
  private String esito;
  private String messaggioErrore;
  private int codiceErrore = 0;

  /**
   *
   */
  public WsResult() {
    // TODO Auto-generated constructor stub
  }

  public String getEsito() {
    return esito;
  }

  public void setEsito(String esito) {
    this.esito = esito;
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

}
