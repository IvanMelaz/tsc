package it.tsc.mvc;

import it.tsc.domain.BaseSmartWatcher;
import it.tsc.util.JsonUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author astraservice
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@ActiveProfiles("test")
public class MvcStandardTest {
	private static final Logger logger = LoggerFactory
			.getLogger(MvcStandardTest.class);
	@Autowired
	protected WebApplicationContext webApplicationContext;
	@Autowired
	protected FilterChainProxy filterChain;
	protected MockMvc mvc;

	/**
	 *
	 */
	public MvcStandardTest() {

	}

	@Before
	public void setup() throws Exception {
		logger.debug("context {}", webApplicationContext);
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.addFilter(filterChain).build();
	}

	@Test
	public void testHomePage() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/");
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}

	@Ignore
	@Test
	public void testStartAllarm() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isCreated();
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.post("/startAllarm");
		BaseSmartWatcher baseSmartWatcher = new BaseSmartWatcher();
		baseSmartWatcher.setPhoneNumber("+41770123456");
		builder.content(JsonUtil.getGsonConverter().toJson(baseSmartWatcher));
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}

	@Test
	public void testGetAllarms() throws Exception {
		ResultMatcher ok = MockMvcResultMatchers.status().isOk();
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders
				.get("/getAllarms");
		MvcResult result = mvc.perform(builder).andExpect(ok).andReturn();
		String content = result.getResponse().getContentAsString();
		logger.debug("content {}", content);
	}

}
