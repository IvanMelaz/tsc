/**
 * 
 */
package it.tsc.service;

import java.time.Instant;
import java.util.Date;

/**
 * @author astraservice Manage Allarm in TSC
 */
public interface AllarmService {
	/**
	 * Inserisce allarme per matricola (ITALTEL)
	 * 
	 * @param matricola
	 * @param data_arrivo
	 * @param evento
	 * @param id_allarme
	 * @param user
	 */
	public void insertAllarmeMatricola(String matricola, String ab_codi, Instant data_arrivo, String evento,
			String id_allarme, String user);

	/**
	 * Inserisce allarme per telefono (BRONDI)
	 * 
	 * @param tel
	 * @param data_arrivo
	 * @param evento
	 * @param id_allarme
	 * @param user
	 */
	public void insertAllarmeTel(String tel, String ab_codi, Date data_arrivo, String evento, String id_allarme,
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
