package it.tsc.webservice;

import it.tsc.domain.types.ErrorCode;
import it.tsc.domain.types.Esito;
import it.tsc.webservice.domain.WsResult;

public class BaseWebService {

	private WsResult result;

	/**
	 * populate output result with error
	 *
	 * @param esito
	 * @param errorCode
	 * @return
	 */
	protected WsResult populateErrorResult(ErrorCode errorCode) {
		Esito esito = Esito.KO;
		result = new WsResult(esito, errorCode.getDescription(),
				errorCode.getNumVal(), "");
		return result;
	}

	/**
	 * A common method for all enums since they can't have another base class
	 *
	 * @param <T>    Enum type
	 * @param c      enum type. All enums must be all caps.
	 * @param string case insensitive
	 * @return corresponding enum, or null
	 */
	protected <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
		if (c != null && string != null) {
			try {
				return Enum.valueOf(c, string.trim().toUpperCase());
			}
			catch (IllegalArgumentException ex) {
			}
		}
		return null;
	}

}
