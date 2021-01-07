package it.tsc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.tsc.domain.Allarmi;

@Repository("allarmDao")
public interface AllarmDao extends CrudRepository<Allarmi, String> {
	/**
	 * Inserisce allarme
	 * @param ab_codi
	 * @param matricola
	 * @param mux
	 * @param evento
	 * @param centrale
	 */
	@Procedure("sp_i_GeneraAllarme")
	void insertAllarme(@Param("ab_codi") String ab_codi,
					   @Param("p_matricola") String matricola, @Param("p_mux") String mux,
					   @Param("p_evento") String evento,
					   @Param("p_centrale") String centrale);

	/**
	 * Inserisce allarme per telefono (BRONDI)
	 * @param ab_codi
	 * @param evento
	 * @param id_allarme
	 * @param user
	 */
	@Procedure("sp_i_GeneraAllarme")
	void insertAllarme(@Param("ab_codi") String ab_codi,
					   @Param("p_evento") String evento,
					   @Param("id_allarme") String id_allarme,
					   @Param("p_user") String user);

	/**
	 * rimuove allarme
	 *
	 * @param id_allarme
	 */
	@Query("delete Allarmi a where a.id_allarme=:id_allarme ")
	void removeAllarme(@Param("id_allarme") String id_allarme);

	/**
	 * update Allarme
	 *
	 * @param id_allarme
	 * @param user
	 */
	@Query("update Allarmi a set a.user =:user where a.id_allarme=:id_allarme")
	void updateAllarme(@Param("id_allarme") String id_allarme,
					   @Param("user") String user);

	/**
	 * get allarms in json format
	 *
	 * @return
	 */
	@Query("select a from Allarmi a")
	List<Allarmi> jsonGetAllarms();
}
