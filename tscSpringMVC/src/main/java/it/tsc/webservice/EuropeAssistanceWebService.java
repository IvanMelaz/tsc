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
import javax.xml.rpc.ServiceException;
import javax.xml.soap.SOAPException;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import it.tsc.data.config.ServiceConfig;
import it.tsc.service.AllarmService;
import it.tsc.service.UserService;
import it.tsc.webservice.domain.FasciaOraria;
import it.tsc.webservice.domain.SpecializzazioneMedico;
import it.tsc.webservice.domain.TipologiaConsulenza;
import it.tsc.webservice.domain.TipologiaServizio;
import it.tsc.webservice.domain.WsResult;

/**
 * @author astraservice
 *
 */
@WebService
public class EuropeAssistanceWebService {
  private static Logger logger = LoggerFactory.getLogger(EuropeAssistanceWebService.class);
  private BCryptPasswordEncoder bcryptEncoder;
  private UserService userService;
  private AllarmService allarmService;
  private ApplicationContext context = new AnnotationConfigApplicationContext(ServiceConfig.class);

  @Resource
  private WebServiceContext wsContext;

  @WebMethod(operationName = "insertAllarmEuropeAssistance")
//@formatter:off
  public WsResult allarmeEuropeAssistance(
      @WebParam(targetNamespace="http://mycare24.org/types",
      name="dataRichiesta",
      mode=Mode.IN)Date dataRichiesta,

      @WebParam(targetNamespace="http://mycare24.org/types",
      name="nomeCliente",
      mode=Mode.IN)String nomeCliente,

      @WebParam(targetNamespace="http://mycare24.org/types",
      name="cognomeCliente",
      mode=Mode.IN)String cognomeCliente,

      String numeroTelefono1,
      String numeroTelefono2,
      String email,
      String indirizzo,
      int numeroOrdine,
      String numeroDossier,
      String codiceBP,
      TipologiaServizio tipologiaServizio,
      TipologiaConsulenza tipologiaConsulenza,
      SpecializzazioneMedico specializzazioneMedico,
      String quesitoMedico,
      FasciaOraria fasciaOraria,
      String linkMyClinic,
      boolean test)
      throws SOAPException, ServiceException {
 //@formatter:on
    WsResult result = new WsResult();

    Validate.notNull(context, "context cannot be null");

    allarmService = context.getBean("allarmService", AllarmService.class);
    Validate.notNull(allarmService, "allarmService cannot be null");

    /**
     * Check campi mandatori
     */

    logger.debug("sussess inserting allarm");
    // allarmService.insertAllarme(ab_codi, TimeUtil.getCurrentInstantDate(), evento,
    // PortalUtil.generateUUID(), "");

    return result;
  }

}
