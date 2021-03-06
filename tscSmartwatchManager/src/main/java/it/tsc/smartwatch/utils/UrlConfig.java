package it.tsc.smartwatch.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

public class UrlConfig {
	private String urlPath;
	private String removeEndPointUrl;
	private static final Logger log = LoggerFactory.getLogger(UrlConfig.class);
	public UrlConfig(String urlPath, String removeEndPointUrl) {
		super();
		this.urlPath = urlPath;
		this.removeEndPointUrl = removeEndPointUrl;
	}

	/**
	 * rean Json Object
	 *
	 * @return Json String data id present
	 */
	public Optional<String> readJsonFromUrl() {
		InputStream is;
		try {
			is = new URL(urlPath).openStream();
			BufferedReader rd = new BufferedReader(
					new InputStreamReader(is, StandardCharsets.UTF_8));
			String jsonText = readAll(rd);
			if (!StringUtils.isEmpty(jsonText)) {
				return Optional.of(jsonText);
			} else {
				return Optional.empty();
			}
		} catch (Exception e) {
			log.error("readJsonFromUrl error: {}",e.getMessage());
		}
		return Optional.empty();
	}

	public void removeAllarm(String idAllarme) {
		InputStream is;
		try {
			is = new URL(getRemoveUrlPath() + "?id_allarme=" + idAllarme)
					.openStream();
			log.info("removeAllAllarm {} path: {}", idAllarme,
					getRemoveUrlPath());
		} catch (Exception e) {
			log.error("readJsonFromUrl error: {}",e.getMessage());
		}
	}

	private String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public String getUrlPath() {
		return urlPath;
	}

	public String getRemoveUrlPath() {
		return removeEndPointUrl;
	}

}
