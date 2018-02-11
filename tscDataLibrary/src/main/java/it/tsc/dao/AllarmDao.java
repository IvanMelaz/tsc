package it.tsc.dao;

import java.time.Instant;

public interface AllarmDao {
	/**
	 * Inserisce allarme
	 *
	 * @param data_arrivo
	 * @param evento
	 * @param id_allarme
	 * @param user
	 */
	public void insertAllarme(String ab_codi, Instant data_arrivo, String evento, String id_allarme, String user);

	/**
	 * Inserisce allarme per telefono (BRONDI)
	 *
	 * @param tel
	 * @param data_arrivo
	 * @param evento
	 * @param id_allarme
	 * @param user
	 */
	public void insertAllarmeTel(String tel, String ab_codi, Instant data_arrivo, String evento, String id_allarme,
			String user);

	/**
	 * rimuove allarme
	 *
	 * @param id_allarme
	 */
	public void removeAllarme(String id_allarme);

	/**
	 * update Allarme
	 *
	 * @param id_allarme
	 * @param user
	 */
	public void updateAllarme(String id_allarme, String user);

	/**
	 * get allarms in json format
	 *
	 * @return
	 */
	public String jsonGetAllarms();
}
