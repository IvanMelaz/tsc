/**
 *
 */
package it.tsc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.tsc.repository.CodaEveDao;
import it.tsc.service.CodaEveService;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@Service("codaEveService")
public class CodaEveServiceImpl implements CodaEveService {

	@Autowired
	private CodaEveDao codaEveDao;

	/**
	 *
	 */
	public CodaEveServiceImpl() {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.QueueService#jsonQueueGetAllarms()
	 */
	@Override
	public String jsonQueueGetAllarms(String user) {
		String result = JsonUtil.getGsonConverter()
				.toJson(codaEveDao.findAll());
		return result;
	}

	@Override
	public void removeAllarme(String id_allarme) {
		codaEveDao.removeAllarme(id_allarme);
	}

	@Override
	public void updateAllarme(String id_allarme, String user) {
		codaEveDao.updateAllarme(id_allarme, user);
	}

	@Override
	public void insertAllarmiInCodaEve(String matricola, String evento,
			String centrale, String mux, String ritardo) {
		codaEveDao.insertAllarmiInCodaEve(matricola, evento, centrale, mux,
				ritardo);
	}

}
