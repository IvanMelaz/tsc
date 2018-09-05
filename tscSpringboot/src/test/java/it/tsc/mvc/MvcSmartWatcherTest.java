package it.tsc.mvc;
/**
 *
 */

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
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@Configuration
public class MvcSmartWatcherTest extends MvcStandardTest {
	private static Logger logger = LoggerFactory
			.getLogger(MvcSmartWatcherTest.class);

	/**
	 *
	 */
	public MvcSmartWatcherTest() {
		// TODO Auto-generated constructor stub
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

}
