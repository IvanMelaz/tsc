package it.tsc.repository;

import it.tsc.domain.AllarmiTelemedicare;

public interface TelemedicareDao {

	/**
	 * save allarm coming from WS
	 *
	 * @param allarmiTelemedicare
	 */
	public void saveAllarm(AllarmiTelemedicare allarmiTelemedicare);

	/**
	 * retrieve List (size == 20) od persisted Allarms
	 *
	 * @return
	 */
	public String listJsonAllarmiOpen();

	/**
	 * drop registered allarm
	 *
	 * @param progressivoAllarme
	 */
	public void dropAllarm(String progressivoAllarme);
}
