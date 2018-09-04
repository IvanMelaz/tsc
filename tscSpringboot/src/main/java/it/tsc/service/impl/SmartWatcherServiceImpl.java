/**
 *
 */
package it.tsc.service.impl;

import org.springframework.stereotype.Service;

import it.tsc.service.SmartWatcherService;

/**
 * @author "astraservice"
 *
 */
@Service("smartWatcherService")
public class SmartWatcherServiceImpl implements SmartWatcherService {
	private static String REGISTERED_NUMBER = "";
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
		if (phoneNumber.equals(REGISTERED_NUMBER)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see it.tsc.service.SmartWatcherService#registerDevice(java.lang.String)
	 */
	@Override
	public boolean registerDevice(String phoneNumber) {
		if (phoneNumber.equals(REGISTERED_NUMBER)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * it.tsc.service.SmartWatcherService#unregisterDevice(java.lang.String)
	 */
	@Override
	public boolean unregisterDevice(String phoneNumber) {
		if (phoneNumber.equals(REGISTERED_NUMBER)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean registerAllarm(String phoneNumber) {
		if (phoneNumber.equals(REGISTERED_NUMBER)) {
			return true;
		} else {
			return false;
		}
	}

}
