/**
 *
 */
package it.tsc.boot.test;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author "astraservice"
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@TestPropertySource(locations = "/application.test.properties")
@ImportResource(value = "classpath*:test-configuration.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
//@DatabaseSetup("classpath:data/data.xml")
public class SpringBootTscTest {

	@PersistenceContext
	private EntityManager em;

	/**
	 *
	 */
	public SpringBootTscTest() {

	}

	@Test
	public void testCreateClientSuccessfully() {

	}

}
