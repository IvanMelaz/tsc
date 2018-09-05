package it.tsc.mvc;
/**
 *
 */

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import it.tsc.domain.BaseSmartWatcher;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
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
		ResultMatcher ok = MockMvcResultMatchers.status().is2xxSuccessful();
		BaseSmartWatcher baseSmartWatcher = new BaseSmartWatcher();
		baseSmartWatcher.setPhoneNumber("1234");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/startAlarm").contentType(MediaType.APPLICATION_JSON)
				.content(JsonUtil.getGsonConverter().toJson(baseSmartWatcher));
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}

}
