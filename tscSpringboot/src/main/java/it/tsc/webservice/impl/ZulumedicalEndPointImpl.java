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

    @Value("${zulumedical.phone}")
    private String phone;

    @Value("${zulumedical.centrale}")
    private String centrale;

    @Override
    public WsResult allarmeZulumedical(String userName, String password, String progressivoAllarme) throws SOAPException, ServiceException {
        WsResult result = null;
        logger.info("calling access userName: {} password: {}",userName,password);
        try {
            if (!userName.equalsIgnoreCase(user) || !password.equalsIgnoreCase(pwd)) {
                throw new SOAPException("Invalid username or password");
            }
            logger.info("succesfully call insert phone: {}",phone);
            codaEveService.insertAllarmiInCodaEve_Brondi(phone,null,centrale);
        } catch (Exception e) {
            logger.error("Zulumedical WebService: Exception: {}", e);
            throw new SOAPException(e);
        }
        result = new WsResult(Esito.OK, "", 0,
                progressivoAllarme);
        return result;
    }
}
