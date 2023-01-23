/**
 *
 */
package it.tsc.service;

/**
 * @author "astraservice" Service for allarm on coda_eve
 */
public interface CodaEveService {

	/**
	 * get allarms in json format
	 *
	 * @param user
	 * @return
	 */
    String jsonQueueGetAllarms(String user);

	/**
	 * remove allarme from CODA_EVE
	 *
	 * @param id_allarme
	 */
    void removeAllarme(String id_allarme);

	/**
	 * update allarme from CODA_EVE
	 *
	 * @param id_allarme
	 * @param user
	 */
    void updateAllarme(String id_allarme, String user);

	/**
	 * insert Allarm in CodaEve
	 * 
	 * @param matricola
	 * @param evento
	 * @param centrale
	 * @param mux
	 * @param ritardo
	 */
    void insertAllarmiInCodaEve(String matricola, String evento,
                                String centrale, String mux, String ritardo);

	/**
	 * 	Insert Allarm in CodaEve Brondi , using phone number
	 * @param telefono
	 * @param filename
	 * @param centrale
	 */
	void insertAllarmiInCodaEve_Brondi(String telefono, String filename, String centrale);

}
