/**
 *
 */
package it.tsc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.tsc.domain.CodaEve;

/**
 * @author "astraservice"
 *
 */
public interface CodaEveDao extends CrudRepository<CodaEve, String> {

	/**
	 * get allarms in json format
	 *
	 * @param user
	 * @return
	 */
	@Procedure("sp_v_Coda_Eve")
    List<CodaEve> jsonGetAllarms(@Param("p_user") String user);

	/**
	 * remove allarme from CODA_EVE
	 *
	 * @param id_allarme
	 */
	@Procedure("sp_d_CodaEve")
    void removeAllarme(@Param("p_ID_allarme") String id_allarme);

	/**
	 * update allarme from CODA_EVE
	 *
	 * @param id_allarme
	 * @param user
	 */
	@Procedure("sp_u_SetUser_in_CodaEve")
    void updateAllarme(@Param("p_ID_allarme") String id_allarme,
                       @Param("p_user") String user);
	/**
	 * insert Allarm in CodaEve
	 *
	 * @param matricola
	 * @param evento
	 * @param centrale
	 * @param mux
	 * @param ritardo
	 */
	@Procedure("sp_i_InsertAllarmi_in_CodaEve")
    void insertAllarmiInCodaEve(@Param("p_matricola") String matricola,
                                @Param("p_evento") String evento,
                                @Param("p_centrale") String centrale, @Param("p_mux") String mux,
                                @Param("p_ritardo") String ritardo);

	/**
	 * insert Allarm in coda eve using phone number
	 *
	 * @param telefono
	 * @param filename
	 * @param centrale
	 */
	@Procedure("sp_i_InsertAllarmi_in_CodaEve_Brondi")
    void insertAllarmiInCodaEve_Brondi(
            @Param("p_telefono") String telefono,
            @Param("p_filename") String filename,
            @Param("p_centrale") String centrale);

}
