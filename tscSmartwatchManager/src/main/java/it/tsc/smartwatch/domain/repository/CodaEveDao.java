/**
 *
 */
package it.tsc.smartwatch.domain.repository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.tsc.smartwatch.domain.CodaEve;

/**
 * @author "astraservice"
 *
 */
@Repository("codaEveDao")
public interface CodaEveDao extends CrudRepository<CodaEve, String> {

	/**
	 * insert Allarm in coda eve using phone number
	 *
	 * @param telefono
	 * @param filename
	 * @param centrale
	 */
	@Procedure("sp_i_InsertAllarmi_in_CodaEve_Brondi")
	public void insertAllarmiInCodaEve_Brondi(
			@Param("p_telefono") String telefono,
			@Param("p_filename") String filename,
			@Param("p_centrale") String centrale);

	/**
	 * remove allarme from CODA_EVE
	 *
	 * @param id_allarme
	 */
	@Procedure("sp_d_CodaEve")
	public void removeAllarme(@Param("p_ID_allarme") String id_allarme);

}
