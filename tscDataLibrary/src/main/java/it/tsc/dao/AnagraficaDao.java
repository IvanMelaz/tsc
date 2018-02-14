/**
 *
 */
package it.tsc.dao;

import it.tsc.domain.Anagrafica;

/**
 * @author "astraservice"
 *
 */
public interface AnagraficaDao {

	public Anagrafica getAnagrafica(String ab_codi);

	public void insertAnagrafica(Anagrafica anagrafica);

}
