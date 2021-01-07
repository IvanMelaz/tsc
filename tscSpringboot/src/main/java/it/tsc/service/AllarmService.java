/**
 *
 */
package it.tsc.service;

import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Date;

/**
 * @author astraservice Manage Allarmi in TSC
 */
public interface AllarmService {
	/**
	 * Inserisce allarme
	 * @param ab_codi
	 * @param data_arrivo
	 * @param evento
	 * @param id_allarme
	 * @param user
	 */
	@Transactional
	void insertAllarme(String ab_codi, Instant data_arrivo,
					   String evento, String id_allarme, String user);

	/**
	 * Inserisce allarme per telefono (BRONDI)
	 *
	 * @param tel
	 * @param data_arrivo
	 * @param evento
	 * @param id_allarme
	 * @param user
	 */
	@Transactional
	void insertAllarmeTel(String tel, String ab_codi, Date data_arrivo,
						  String evento, String id_allarme, String user);

	/**
	 * rimuove allarme
	 *
	 * @param id_allarme
	 */
	@Transactional
	void removeAllarme(String id_allarme);

	/**
	 * update Allarme
	 *
	 * @param id_allarme
	 * @param user
	 */
	@Transactional
	void updateAllarme(String id_allarme, String user);

}
