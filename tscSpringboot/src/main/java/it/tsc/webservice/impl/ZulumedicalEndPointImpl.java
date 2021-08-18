package it.tsc.webservice.impl;

import it.tsc.domain.types.Esito;
import it.tsc.service.CodaEveService;
import it.tsc.webservice.BaseWebService;
import it.tsc.webservice.ZulumedicalEndpoint;
import it.tsc.webservice.domain.WsResult;
import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.soap.SOAPException;

public class ZulumedicalEndPointImpl extends BaseWebService implements ZulumedicalEndpoint {

    private static final Logger logger = LoggerFactory
            .getLogger(ZulumedicalEndPointImpl.class);

    @Autowired
    private CodaEveService codaEveService;

    @Value("${zulumedical.userName}")
    private String user;

    @Value("${zulumedical.password}")
    private String pwd;

    private final static String EVENTO = "01";

    private final static String MATRICOLA = "ZM0001";

    private static final String CENTRALE = "MILANO";

    private static final String MUX = "MUX1";

    private static final String RITARDO = "0";

    @Override
    public WsResult allarmeZulumedical(String userName, String password, String progressivoAllarme) throws SOAPException, ServiceException {
        WsResult result = null;
        try {
            if (!userName.equalsIgnoreCase(user) || !password.equalsIgnoreCase(pwd)) {
                throw new SOAPException("Invalid username or password");
            }
            codaEveService.insertAllarmiInCodaEve(MATRICOLA,EVENTO,CENTRALE,MUX,RITARDO);
        } catch (Exception e) {
            logger.error("Zulumedical WebService: Exception: {}", e);
            throw new SOAPException(e);
        }
        result = new WsResult(Esito.OK, "", 0,
                progressivoAllarme);
        return result;
    }
}
