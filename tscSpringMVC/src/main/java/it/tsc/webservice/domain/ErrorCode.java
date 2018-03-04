/**
 *
 */
package it.tsc.webservice.domain;

/**
 * @author "astraservice"
 *
 */
public enum ErrorCode {
//@formatter:off
  DATE_REQUIRED(0, "La data e ora richiesta devono essere forniti"),
  COGNOME_CLIENTE(1,"Il nominativo cliente deve essere inserito"),
  NUMERO_TELEFONO(2,"Il numero telefono primario deve essere inserito"),
  NUMERO_ORDINE(3,"Il numero ordine deve essere inserito"),
  NUMERO_DOSSIER(4,"Il numero dossier deve essere inserito"),
  CODICE_BP(5,"Il codice BP deve essere inserito"),
  TIPOLOGIA_SERVIZIO(6,"La tipologia di servizio  deve essere specificata"),
  TIPOLOGIA_CONSULENZA(7,"La tipologia di consulenza deve essere specificata");
//@formatter:on

  private int numVal;
  private String errorDescription;

  ErrorCode(int numVal, String errorDescription) {
    this.numVal = numVal;
    this.errorDescription = errorDescription;
  }

  public int getNumVal() {
    return numVal;
  }

  public String getDescription() {
    return errorDescription;
  }

}
