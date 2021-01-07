/**
 *
 */
package it.tsc.util;

import com.google.gson.*;

import java.util.List;

/**
 * @author astraservice (JSON conversion utils)
 */
public class JsonUtil {

	/**
	 *
	 */
	public JsonUtil() {
		
	}

	/**
	 * return array of JSON object
	 *
	 * @param rows
	 * @return
	 */
	public static String returnJson(List<?> rows) {
		JsonArray array = new JsonArray();
		for (Object row : rows) {
			JsonObject json = (JsonObject) new JsonParser()
					.parse(new Gson().toJson(row));
			array.add(json);
		}
		return array.toString();
	}

	/**
	 * return gson converter
	 *
	 * @return
	 */
	public static Gson getGsonConverter() {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
				.create();
		return gson;
	}

	public static Gson getGsonHtmlEscapingConverter() {
		Gson gson = new GsonBuilder().disableHtmlEscaping()
				.excludeFieldsWithoutExposeAnnotation().create();
		return gson;
	}

}
