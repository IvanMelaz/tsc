package it.tsc.webservice;

import it.tsc.webservice.domain.WsResult;
import org.hibernate.service.spi.ServiceException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.soap.SOAPException;

@WebService(serviceName = "ZulumedicalService", portName = "ZulumedicalPort",
        targetNamespace = "http://it.tsc.webservice/",
        endpointInterface = "it.tsc.webservice.ZulumedicalEndpoint")
@SOAPBinding(style = SOAPBinding.Style.RPC, use = SOAPBinding.Use.LITERAL)
public interface ZulumedicalEndpoint {
    @WebMethod(action = "urn:allarmeZulumedical")
    WsResult allarmeZulumedical(@WebParam(name = "userName",
                                        mode = WebParam.Mode.IN) String userName,
                                @WebParam(name = "password",
                                        mode = WebParam.Mode.IN) String password,
                                @WebParam(name = "progressivoAllarme",
                                        mode = WebParam.Mode.IN) String progressivoAllarme)
            throws SOAPException, ServiceException;
}
