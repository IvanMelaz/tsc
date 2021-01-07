/**
 *
 */
package it.tsc.webservice;

import java.util.Date;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.xml.soap.SOAPException;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.tsc.config.ServiceConfig;
import it.tsc.domain.AllarmiEuropeAssistance;
import it.tsc.domain.types.ErrorCode;
import it.tsc.domain.types.Esito;
import it.tsc.domain.types.FasciaOraria;
import it.tsc.domain.types.SpecializzazioneMedico;
import it.tsc.domain.types.TipologiaConsulenza;
import it.tsc.domain.types.TipologiaServizio;
import it.tsc.service.EuropeAssistanceService;
import it.tsc.webservice.domain.WsResult;

/**
 * @author astraservice
 *
 */
@WebService(name = "allarmeEuropeAssistance", targetNamespace = "www.mycare24.org")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
@SuppressWarnings("unused")
public class EuropeAssistanceWebService extends BaseWebService {
	private static final Logger logger = LoggerFactory
			.getLogger(EuropeAssistanceWebService.class);
	private static final String DATE_FORMAT = "yyyy-MM-ddThh:mm:ss";
	private static final String EU001 = "EU001";
	private EuropeAssistanceService europeAssistanceService;
	private final ApplicationContext context = new AnnotationConfigApplicationContext(
			ServiceConfig.class);

	@Resource
	private WebServiceContext wsContext;

	public EuropeAssistanceWebService() {
		super();
	}

	@WebMethod(operationName = "insertAllarmEuropeAssistance")
//@formatter:off
  public WsResult allarmeEuropeAssistance(
      @WebParam(name="dataRichiesta",
      mode=Mode.IN)Date dataRichiesta,

      @WebParam(name="nomeCliente",
      mode=Mode.IN)String nomeCliente,

      @WebParam(name="cognomeCliente",
      mode=Mode.IN)String cognomeCliente,

      @WebParam(name="numeroTelefono1",
      mode=Mode.IN)String numeroTelefono1,

      @WebParam(name="numeroTelefono2",
      mode=Mode.IN)String numeroTelefono2,

      @WebParam(name="email",
      mode=Mode.IN)String email,

      @WebParam(name="indirizzo",
      mode=Mode.IN)String indirizzo,

      @WebParam(name="numeroOrdine",
      mode=Mode.IN)String numeroOrdine,

      @WebParam(name="numeroDossier",
      mode=Mode.IN)String numeroDossier,

      @WebParam(name="codiceBP",
      mode=Mode.IN)String codiceBP,

      @WebParam(name="tipologiaServizio",
      mode=Mode.IN)TipologiaServizio tipologiaServizio,

      @WebParam(name="tipologiaConsulenza",
      mode=Mode.IN)TipologiaConsulenza tipologiaConsulenza,

      @WebParam(name="specializzazioneMedico",
      mode=Mode.IN)SpecializzazioneMedico specializzazioneMedico,

      @WebParam(name="quesitoMedico",
      mode=Mode.IN)String quesitoMedico,

      @WebParam(name="fasciaOraria",
      mode=Mode.IN)FasciaOraria fasciaOraria,

      @WebParam(name="linkMyClinic",
      mode=Mode.IN)String linkMyClinic,

      @WebParam(name="test",
      mode=Mode.IN)boolean test)
      throws SOAPException, ServiceException {
 //@formatter:on

		/**
		 * check errori
		 */
		// Data formato 2001-10-26T21:32:52
		if (StringUtils.isEmpty(dataRichiesta.toString().trim())) {
			return populateErrorResult(ErrorCode.DATE_REQUIRED);
		}
		if (StringUtils.isEmpty(cognomeCliente.trim())) {
			return populateErrorResult(ErrorCode.COGNOME_CLIENTE);
		}
		if (StringUtils.isEmpty(numeroTelefono1.trim())) {
			return populateErrorResult(ErrorCode.NUMERO_TELEFONO);
		}
		if (StringUtils.isEmpty(numeroOrdine)) {
			return populateErrorResult(ErrorCode.NUMERO_ORDINE);
		}
		if (StringUtils.isEmpty(numeroDossier.trim())) {
			return populateErrorResult(ErrorCode.NUMERO_DOSSIER);
		}
		if (StringUtils.isEmpty(codiceBP.trim())) {
			return populateErrorResult(ErrorCode.CODICE_BP);
		}
		if (tipologiaServizio == null
				|| (StringUtils.isEmpty(tipologiaServizio.toString().trim())
						|| this.getEnumFromString(TipologiaServizio.class,
								tipologiaServizio.toString().trim()) == null)) {
			return populateErrorResult(ErrorCode.TIPOLOGIA_SERVIZIO);
		}
		if (tipologiaConsulenza == null || (StringUtils
				.isEmpty(tipologiaConsulenza.toString().trim())
				|| this.getEnumFromString(TipologiaConsulenza.class,
						tipologiaConsulenza.toString().trim()) == null)) {
			return populateErrorResult(ErrorCode.TIPOLOGIA_CONSULENZA);
		}
		if (fasciaOraria == null
				|| (!StringUtils.isEmpty(fasciaOraria.toString().trim())
						&& this.getEnumFromString(FasciaOraria.class,
								fasciaOraria.toString().trim()) == null)) {
			return populateErrorResult(ErrorCode.FASCIA_ORARIA);
		}

		/**
		 * Check campi mandatori
		 */
		Validate.notNull(context, "context cannot be null");
		europeAssistanceService = context.getBean("europeAssistanceService",
				EuropeAssistanceService.class);
		Validate.notNull(europeAssistanceService,
				"europeAssistanceService cannot be null");
		WsResult result = null;
		try {
			/**
			 * insert allarm EuropAssistance
			 */
			AllarmiEuropeAssistance allarmiEuropeAssistance = new AllarmiEuropeAssistance();
			allarmiEuropeAssistance.setAb_codi(EU001);
			allarmiEuropeAssistance.setDataRichiesta(dataRichiesta);
			allarmiEuropeAssistance.setNomeCliente(nomeCliente);
			allarmiEuropeAssistance.setCognomeCliente(cognomeCliente);
			allarmiEuropeAssistance.setNumeroTelefono1(numeroTelefono1);
			allarmiEuropeAssistance.setNumeroTelefono2(numeroTelefono2);
			allarmiEuropeAssistance.setEmail(email);
			allarmiEuropeAssistance.setIndirizzo(indirizzo);
			allarmiEuropeAssistance.setNumeroOrdine(numeroOrdine);
			allarmiEuropeAssistance.setNumeroDossier(numeroDossier);
			allarmiEuropeAssistance.setCodiceBP(codiceBP);
			allarmiEuropeAssistance.setTipologiaServizio(tipologiaServizio);
			allarmiEuropeAssistance.setTipologiaConsulenza(tipologiaConsulenza);
			allarmiEuropeAssistance
					.setSpecializzazioneMedico(specializzazioneMedico);
			allarmiEuropeAssistance.setQuesitoMedico(quesitoMedico);
			allarmiEuropeAssistance.setFasciaOraria(fasciaOraria);
			allarmiEuropeAssistance.setLinkMyClinic(linkMyClinic);
			allarmiEuropeAssistance.setTest(test);
			europeAssistanceService.saveAllarm(allarmiEuropeAssistance);
			result = new WsResult(Esito.OK, "", 0,
					allarmiEuropeAssistance.getId_allarme());
			logger.debug(
					"EuropeAssistanceWebService: sussess inserting allarm");
		} catch (Exception e) {
			logger.error("EuropeAssistanceWebService: Exception: {}", e);
			throw new SOAPException(e);
		}

		return result;
	}

}
