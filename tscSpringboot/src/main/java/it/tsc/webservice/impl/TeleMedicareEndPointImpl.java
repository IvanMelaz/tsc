package it.tsc.webservice.impl;

import it.tsc.domain.AllarmiTelemedicare;
import it.tsc.domain.types.ErrorCode;
import it.tsc.domain.types.Esito;
import it.tsc.service.TelemedicareService;
import it.tsc.webservice.BaseWebService;
import it.tsc.webservice.TeleMedicareEndpoint;
import it.tsc.webservice.domain.WsResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.xml.soap.SOAPException;

public class TeleMedicareEndPointImpl extends BaseWebService implements TeleMedicareEndpoint {
	private static final Logger logger = LoggerFactory
			.getLogger(TeleMedicareEndPointImpl.class);

	private static final int MAX_PROGRESSIVO_LENGHT = 50;

	private static final String codiceAllarme = "TMC0000";

	@Autowired
	private TelemedicareService telemedicareService;

	@Autowired
	private ApplicationContext context;

	@Override
	public WsResult allarmeTelemedicare(String progressivoAllarme) throws SOAPException, ServiceException {
		WsResult result = null;
		/**
		 * Check campi mandatori
		 */
		Validate.notNull(context, "context cannot be null");
		Validate.notNull(telemedicareService,
				"telemedicareService cannot be null");
		try {
			AllarmiTelemedicare allarmiTelemedicare = new AllarmiTelemedicare();

			if (StringUtils.isEmpty(progressivoAllarme.trim()) || progressivoAllarme.trim().length() > MAX_PROGRESSIVO_LENGHT) {
				return populateErrorResult(ErrorCode.PROGRESSIVO_ALLARME);
			}
			allarmiTelemedicare.setAb_codi(codiceAllarme);
			allarmiTelemedicare.setProgressivoAllarme(progressivoAllarme);
			/**
			 * Call to DaoService
			 */
			logger.debug("allarmeTelemedicare codiceAllarme: {} progressivoAllarme: {}", codiceAllarme, progressivoAllarme);
			telemedicareService.saveAllarm(allarmiTelemedicare);
			result = new WsResult(Esito.OK, "", 0,
					allarmiTelemedicare.getId_allarme());
		}
		catch (Exception e) {
			logger.error("TelemedicareWebService: Exception: {}", e);
			throw new SOAPException(e);
		}
		return result;
	}

	@Override
	public WsResult eliminaAllarmeTelemedicare(String progressivoAllarme) throws SOAPException, ServiceException {
		WsResult result = null;

		try {
			if (StringUtils.isEmpty(progressivoAllarme.trim()) || progressivoAllarme.trim().length() > MAX_PROGRESSIVO_LENGHT) {
				return populateErrorResult(ErrorCode.PROGRESSIVO_ALLARME);
			}
			/**
			 * Call to DaoService
			 */
			logger.debug("eliminaAllarmeTelemedicare progressivoAllarme: {}", progressivoAllarme);
			telemedicareService.dropAllarm(progressivoAllarme);
			result = new WsResult(Esito.OK, "", 0,
					progressivoAllarme);
		}
		catch (Exception e) {
			logger.error("TelemedicareWebService: Exception: {}", e);
			throw new SOAPException(e);
		}
		return result;
	}

}
