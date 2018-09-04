package it.tsc.mvc;
/**
 *
 */

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/startAlarm");
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}

}
