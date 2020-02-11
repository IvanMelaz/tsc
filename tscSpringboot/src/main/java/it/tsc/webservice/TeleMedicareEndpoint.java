package it.tsc.webservice;

import it.tsc.webservice.domain.WsResult;
import org.hibernate.service.spi.ServiceException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.soap.SOAPException;

@WebService(targetNamespace = "http://it.tsc.webservice/", name = "TeleMedicare")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public interface TeleMedicareEndpoint {
	@WebMethod(action = "urn:allarmeTelemedicare")
	WsResult allarmeTelemedicare(
			@WebParam(name = "progressivoAllarme",
					mode = WebParam.Mode.IN) String progressivoAllarme)
			throws SOAPException, ServiceException;

	WsResult eliminaAllarmeTelemedicare(
			@WebParam(name = "progressivoAllarme",
					mode = WebParam.Mode.IN) String progressivoAllarme)
			throws SOAPException, ServiceException;
}
