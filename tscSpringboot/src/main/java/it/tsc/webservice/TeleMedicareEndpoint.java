package it.tsc.webservice;

import it.tsc.webservice.domain.WsResult;
import org.hibernate.service.spi.ServiceException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.soap.SOAPException;

@WebService(serviceName = "TelemedicareService", portName = "TelemedicarePort",
		targetNamespace = "http://it.tsc.webservice/",
		endpointInterface = "it.tsc.webservice.TeleMedicareEndpoint")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public interface TeleMedicareEndpoint {
	@WebMethod(action = "urn:allarmeTelemedicare")
	WsResult allarmeTelemedicare(
			@WebParam(name = "progressivoAllarme",
					mode = WebParam.Mode.IN) String progressivoAllarme)
			throws SOAPException, ServiceException;

	@WebMethod(action = "urn:eliminaAllarmeTelemedicare")
	WsResult eliminaAllarmeTelemedicare(
			@WebParam(name = "progressivoAllarme",
					mode = WebParam.Mode.IN) String progressivoAllarme)
			throws SOAPException, ServiceException;
}
