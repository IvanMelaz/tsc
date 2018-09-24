/**
 *
 */
package it.tsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tsc.domain.Anagrafica;
import it.tsc.repository.AnagraficaDao;
import it.tsc.service.AnagraficaService;

/**
 * @author "astraservice"
 *
 */
@Service("anagraficaService")
public class AnagraficaServiceImpl implements AnagraficaService {

	@Autowired
	private AnagraficaDao anagraficaDao;

	/**
	 *
	 */
	public AnagraficaServiceImpl() {
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.AnagraficaService#getAnagrafica(java.lang.String)
	 */
	@Override
	public Anagrafica getAnagrafica(String ab_codi) {
		return anagraficaDao.getAnagrafica(ab_codi);
	}

	@Override
	public Anagrafica insertAnagrafica(Anagrafica anagrafica) {
		return anagraficaDao.save(anagrafica);
	}

}
