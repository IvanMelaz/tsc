/**
 *
 */
package it.tsc.service.test;

import it.tsc.service.AllarmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author "astraservice"
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@ActiveProfiles("test")
public class AllarmiServiceTest {

	@Autowired
	AllarmService allarmService;
	/**
	 *
	 */
	@Test
	public void allarmiServiceTest() {
		assertNotNull(allarmService);
	}

}
