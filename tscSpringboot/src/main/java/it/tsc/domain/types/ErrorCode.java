/**
 *
 */
package it.tsc.domain.types;

/**
 * @author "astraservice"
 *
 */
public enum ErrorCode {
//@formatter:off
  DATE_REQUIRED(1, "La data e ora richiesta devono essere presente , in formato yyyy-MM-ddThh:mm:ss"),
  COGNOME_CLIENTE(2,"Il Cognome cliente deve essere inserito"),
  NUMERO_TELEFONO(3,"Il numero telefono primario deve essere inserito"),
  NUMERO_ORDINE(4,"Il numero ordine (numerico) deve essere inserito"),
  NUMERO_DOSSIER(5,"Il numero dossier deve essere inserito"),
  CODICE_BP(6,"Il codice BP deve essere inserito"),
  TIPOLOGIA_SERVIZIO(7,"La tipologia di servizio  deve essere specificata, valori validi(CONSULENZA,INVIO_MEDICO))"),
  TIPOLOGIA_CONSULENZA(8,"La tipologia di consulenza deve essere specificata, valoti validi (SCRITTA,PHONE)"),
  FASCIA_ORARIA(9," La fascia oraria deve essere espessa in formato (FASCIA1,FASCIA2,FASCIA3)"),
  //Telemedicare
  PROGRESSIVO_ALLARME(10,"Il progressivo allarme deve essere inserito e non maggiore di 50 caratteri") ;
//@formatter:on

	private final int numVal;

	private final String errorDescription;

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
