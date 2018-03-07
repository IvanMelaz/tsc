/**
 *
 */
package it.tsc.webservice.domain;

import it.tsc.domain.types.Esito;

/**
 * @author "astraservice"
 *
 */
public class WsResult {
  private Esito esito;
  private String messaggioErrore;
  private int codiceErrore = 0;
  private String progressivoAllarme;

  public WsResult() {
    super();
  }

  public WsResult(Esito esito, String messaggioErrore, int codiceErrore,
      String progressivoAllarme) {
    super();
    this.esito = esito;
    this.messaggioErrore = messaggioErrore;
    this.codiceErrore = codiceErrore;
    this.progressivoAllarme = progressivoAllarme;
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

  public String getProgressivoAllarme() {
    return progressivoAllarme;
  }

  public void setProgressivoAllarme(String progressivoAllarme) {
    this.progressivoAllarme = progressivoAllarme;
  }

}
