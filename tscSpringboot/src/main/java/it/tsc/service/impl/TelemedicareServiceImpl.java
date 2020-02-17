package it.tsc.service.impl;

import it.tsc.domain.AllarmiTelemedicare;
import it.tsc.repository.TelemedicareDao;
import it.tsc.service.TelemedicareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "telemedicareService")
public class TelemedicareServiceImpl implements TelemedicareService {

	@Autowired
	private TelemedicareDao telemedicareDao;

	@Override
	public void saveAllarm(AllarmiTelemedicare allarmiTelemedicare) {
		telemedicareDao.saveAllarm(allarmiTelemedicare);
	}

	@Override
	public String listJsonAllarmiOpen() {
		return telemedicareDao.listJsonAllarmiOpen();
	}

	@Override
	public void dropAllarm(String progressivoAllarme) {

	}
}
