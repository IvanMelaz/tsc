/**
 *
 */
package it.tsc.mvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import it.tsc.controller.rest.RestSmartWatcherController;
import it.tsc.domain.BaseSmartWatcher;
import it.tsc.domain.DeviceSmartWatcher;
import it.tsc.repository.CodaEveDao;
import it.tsc.util.JsonUtil;

/**
 * @author "astraservice"
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class MockMvcTest {
	private static final Logger log = LoggerFactory
			.getLogger(MockMvcTest.class);

	private MockMvc mockMvc;
	private BaseSmartWatcher baseSmartWatcher = new BaseSmartWatcher();
	private DeviceSmartWatcher deviceSmartWatcher = new DeviceSmartWatcher();

	@InjectMocks
	private RestSmartWatcherController restSmartWatcherController;

	@Spy
	@Autowired
	private CodaEveDao codaEveDao;

	/**
	 *
	 */
	public MockMvcTest() {

	}

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(restSmartWatcherController)
				.build();
		ReflectionTestUtils.setField(restSmartWatcherController, "codaEveDao",
				codaEveDao);
	}

	@Ignore
	@Test
	public void testStartAlarm() throws Exception {
		baseSmartWatcher.setPhoneNumber("+41770123456");
		log.debug("baseSmartWatcher {}",
				JsonUtil.getGsonConverter().toJson(baseSmartWatcher));
		mockMvc.perform(post("/startAlarm")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN,
						MediaType.ALL)
				.content(JsonUtil.getGsonConverter().toJson(baseSmartWatcher)))
				.andExpect(status().isCreated());
	}

	@Ignore
	@Test
	public void testRegister() throws Exception {
		deviceSmartWatcher.setPhoneNumber("+41770123456");
		deviceSmartWatcher.setDisplayName("test");
		mockMvc.perform(post("/register")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN,
						MediaType.ALL)
				.content(
						JsonUtil.getGsonConverter().toJson(deviceSmartWatcher)))
				.andExpect(status().isCreated());
	}

}
