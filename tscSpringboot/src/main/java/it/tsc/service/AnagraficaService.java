/**
 *
 */
package it.tsc.service;

import it.tsc.domain.Anagrafica;

/**
 * @author "astraservice" Anagrafica Service
 */
public interface AnagraficaService {
	/**
	 * get Anagrafica by code
	 *
	 * @param ab_codi
	 * @return
	 */
    Anagrafica getAnagrafica(String ab_codi);

	/**
	 * insert Record in Anagrafica
	 *
	 * @param anagrafica
	 */
    Anagrafica insertAnagrafica(Anagrafica anagrafica);

}
