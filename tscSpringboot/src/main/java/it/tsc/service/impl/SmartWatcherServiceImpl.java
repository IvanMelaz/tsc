/**
 *
 */
package it.tsc.service.impl;

import it.tsc.service.SmartWatcherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author "astraservice"
 *
 */
@Service("smartWatcherService")
public class SmartWatcherServiceImpl implements SmartWatcherService {
	private static final String REGISTERED_NUMBER = "+41770123456";
	private static final Logger log = LoggerFactory
			.getLogger(SmartWatcherServiceImpl.class);

	/**
	 *
	 */
	public SmartWatcherServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.SmartWatcherService#checkRegisteredDevice(java.lang.
	 * String)
	 */
	@Override
	public boolean checkRegisteredDevice(String phoneNumber) {
        return phoneNumber.equals(REGISTERED_NUMBER);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.SmartWatcherService#registerDevice(java.lang.String)
	 */
	@Override
	public boolean registerDevice(String phoneNumber) {
        return phoneNumber.equals(REGISTERED_NUMBER);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * it.tsc.service.SmartWatcherService#unregisterDevice(java.lang.String)
	 */
	@Override
	public boolean unregisterDevice(String phoneNumber) {
        return phoneNumber.equals(REGISTERED_NUMBER);
	}

	@Override
	public boolean registerAllarm(String phoneNumber) {
		log.debug("registerAllarm for: {}", phoneNumber);
        return phoneNumber.equals(REGISTERED_NUMBER);
	}

}
