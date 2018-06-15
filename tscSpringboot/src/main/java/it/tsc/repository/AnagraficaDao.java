/**
 *
 */
package it.tsc.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.tsc.domain.Anagrafica;

/**
 * @author "astraservice"
 *
 */
public interface AnagraficaDao extends CrudRepository<Anagrafica, String> {

	@Procedure("sp_v_Anagrafica")
	public Anagrafica getAnagrafica(@Param("p_ab_codi") String ab_codi);

	@SuppressWarnings("unchecked")
	@Override
	public Anagrafica save(Anagrafica anagrafica);

}
