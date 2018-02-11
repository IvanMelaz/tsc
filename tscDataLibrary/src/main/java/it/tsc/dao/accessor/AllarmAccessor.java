/**
 *
 */
package it.tsc.dao.accessor;

import java.time.Instant;

import com.datastax.driver.mapping.annotations.Accessor;
import com.datastax.driver.mapping.annotations.Param;
import com.datastax.driver.mapping.annotations.Query;

/**
 * @author astraservice Accessor for Allarmi
 */
@Accessor
public interface AllarmAccessor {
	@Query("INSERT INTO ks_tsc.tb_allarms (ab_codi,data_arrivo,evento,id_allarme,user) VALUES (:ab_codi,:data_arrivo,:evento,:id_allarme,:user) IF NOT EXISTS;")
	public void insertAllarme(@Param("ab_codi") String ab_codi, @Param("data_arrivo") Instant data_arrivo,
			@Param("evento") String evento, @Param("id_allarme") String id_allarme, @Param("user") String user);

	@Query("DELETE FROM ks_tsc.tb_allarms WHERE id_allarme = :id_allarme;")
	public void removeAllarme(@Param("id_allarme") String id_allarme);

	@Query("UPDATE ks_tsc.tb_allarms SET user=:user WHERE id_allarme = :id_allarme IF EXISTS;")
	public void updateAllarme(@Param("id_allarme") String id_allarme, @Param("user") String user);
}
