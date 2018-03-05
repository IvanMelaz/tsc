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
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.tsc.data.config.ServiceConfig;
import it.tsc.service.AllarmService;
import it.tsc.webservice.domain.WsResult;
import it.tsc.webservice.domain.types.ErrorCode;
import it.tsc.webservice.domain.types.Esito;
import it.tsc.webservice.domain.types.FasciaOraria;
import it.tsc.webservice.domain.types.SpecializzazioneMedico;
import it.tsc.webservice.domain.types.TipologiaConsulenza;
import it.tsc.webservice.domain.types.TipologiaServizio;

/**
 * @author astraservice
 *
 */
@WebService(name = "allarmeEuropeAssistance", targetNamespace = "www.mycare24.org")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class EuropeAssistanceWebService {
  private static Logger logger = LoggerFactory.getLogger(EuropeAssistanceWebService.class);
  private static String DATE_FORMAT = "yyyy-MM-ddThh:mm:ss";
  private AllarmService allarmService;
  private ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);

  @Resource
  private WebServiceContext wsContext;

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
      mode=Mode.IN)int numeroOrdine,

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
    if (StringUtils.isEmpty(String.valueOf(numeroOrdine).trim())) {
      return populateErrorResult(ErrorCode.NUMERO_ORDINE);
    }
    if (StringUtils.isEmpty(numeroDossier.trim())) {
      return populateErrorResult(ErrorCode.NUMERO_DOSSIER);
    }
    if (StringUtils.isEmpty(codiceBP.trim())) {
      return populateErrorResult(ErrorCode.CODICE_BP);
    }
    if (StringUtils.isEmpty(tipologiaServizio.toString().trim())) {
      return populateErrorResult(ErrorCode.TIPOLOGIA_SERVIZIO);
    }
    if (StringUtils.isEmpty(tipologiaConsulenza.toString().trim())) {
      return populateErrorResult(ErrorCode.TIPOLOGIA_SERVIZIO);
    }

    /**
     * Check campi mandatori
     */
    Validate.notNull(context, "context cannot be null");
    Validate.notNull(allarmService, "allarmService cannot be null");
    WsResult result = new WsResult(Esito.OK, "", 0);
    try {
      allarmService = context.getBean("allarmService", AllarmService.class);
      // allarmService.insertAllarme(ab_codi, TimeUtil.getCurrentInstantDate(), evento,
      // PortalUtil.generateUUID(), "");
      logger.debug("EuropeAssistanceWebService: sussess inserting allarm");
    } catch (Exception e) {
      logger.error("EuropeAssistanceWebService: Exception: {}", e);
      throw new SOAPException(e);
    }

    return result;
  }

  /**
   * populate output result with error
   *
   * @param esito
   * @param errorCode
   * @return
   */
  private WsResult populateErrorResult(ErrorCode errorCode) {
    Esito esito = Esito.KO;
    WsResult result = new WsResult(esito, errorCode.getDescription(), errorCode.getNumVal());
    return result;
  }

}
