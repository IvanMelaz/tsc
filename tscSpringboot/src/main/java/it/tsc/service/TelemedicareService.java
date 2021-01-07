package it.tsc.service;

import it.tsc.domain.AllarmiTelemedicare;

public interface TelemedicareService {

	/**
	 * save allarm coming from WS
	 *
	 * @param allarmiTelemedicare
	 */
    void saveAllarm(AllarmiTelemedicare allarmiTelemedicare);

	/**
	 * retrieve List (size == 20) od persisted Allarms
	 *
	 * @return
	 */
    String listJsonAllarmiOpen();

	/**
	 * drop registered allarm
	 *
	 * @param progressivoAllarme
	 */
    void dropAllarm(String progressivoAllarme);
}
