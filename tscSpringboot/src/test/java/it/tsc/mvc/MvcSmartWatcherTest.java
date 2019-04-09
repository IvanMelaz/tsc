package it.tsc.mvc;
/**
 *
 */

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import it.tsc.domain.BaseSmartWatcher;
import it.tsc.domain.DeviceSmartWatcher;
import it.tsc.domain.PositionSmartWatcher;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@Configuration
public class MvcSmartWatcherTest extends MvcStandardTest {
	private static Logger logger = LoggerFactory
			.getLogger(MvcSmartWatcherTest.class);
	
	private final String USER_AGENT = "Mozilla/5.0";

	/**
	 *
	 */
	public MvcSmartWatcherTest() {

	}

	@Test
	public void testStartAllarm() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isCreated();
		BaseSmartWatcher baseSmartWatcher = new BaseSmartWatcher();
		baseSmartWatcher.setPhoneNumber("+41770123456");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/startAlarm").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.getGsonConverter().toJson(baseSmartWatcher));
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}
	
	@Test
	public void testStartAllarmExternalService() throws Exception {
		sendPost();
	}
	
	// HTTP POST request
	private void sendPost() throws Exception {
		String url = "http://www.mycare24.org:8080/startAlarm";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		
		BaseSmartWatcher baseSmartWatcher = new BaseSmartWatcher();
		baseSmartWatcher.setPhoneNumber("333255255");

		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		con.setRequestProperty("Content-type", "application/json");
		

		String urlParameters = JsonUtil.getGsonConverter().toJson(baseSmartWatcher);
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		//print result
		System.out.println(response.toString());

	}

	@Ignore
	@Test
	public void testRegister() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isCreated();
		DeviceSmartWatcher deviceSmartWatcher = new DeviceSmartWatcher();
		deviceSmartWatcher.setPhoneNumber("+41770123456");
		deviceSmartWatcher.setDisplayName("test");

		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/register").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.getGsonHtmlEscapingConverter()
						.toJson(deviceSmartWatcher));
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}

	@Ignore
	@Test
	public void testDeRegister() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isCreated();
		BaseSmartWatcher baseSmartWatcher = new BaseSmartWatcher();
		baseSmartWatcher.setPhoneNumber("+41770123456");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/deregister").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.getGsonConverter().toJson(baseSmartWatcher));
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}

	@Ignore
	@Test
	public void testPositionUpdate() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isCreated();
		PositionSmartWatcher positionSmartWatcher = new PositionSmartWatcher();
		positionSmartWatcher.setPhoneNumber("+41770123456");
		positionSmartWatcher.setLatitude(6.512145d);
		positionSmartWatcher.setLongitude(45.156456d);
		positionSmartWatcher.setAccuracy(15d);
		positionSmartWatcher.setTimestamp("2017-12-23 21:00:00");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/positionUpdate​")
				.contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.getGsonHtmlEscapingConverter()
						.toJson(positionSmartWatcher));
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}

}
