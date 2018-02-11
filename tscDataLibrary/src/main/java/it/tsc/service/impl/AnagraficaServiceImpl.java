/**
 *
 */
package it.tsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tsc.dao.AnagraficaDao;
import it.tsc.domain.Anagrafica;
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
		// TODO Auto-generated constructor stub
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

}
