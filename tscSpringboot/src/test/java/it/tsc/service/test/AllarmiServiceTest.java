/**
 *
 */
package it.tsc.service.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import it.tsc.service.AllarmService;

/**
 * @author "astraservice"
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
