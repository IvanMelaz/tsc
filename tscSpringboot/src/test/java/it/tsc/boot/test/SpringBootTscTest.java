/**
 *
 */
package it.tsc.boot.test;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import it.tsc.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.assertNotNull;

/**
 * @author "astraservice"
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "/application.test.properties")
@ImportResource(value = "classpath*:test-configuration.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
		DbUnitTestExecutionListener.class })
@DatabaseSetup("classpath:data/data.xml")
public class SpringBootTscTest {

	@PersistenceContext
	private EntityManager em;

	/**
	 *
	 */
	public SpringBootTscTest() {

	}

	@Test
	public void userTest() {
		TypedQuery<User> findQuery = em
				.createNamedQuery(User.SELECT_BY_USERNAME, User.class);
		findQuery.setParameter("username", "testUser");
		List<User> allUsers = findQuery.getResultList();
		assertNotNull(em);
	}

	@Test
	public void testCreateClientSuccessfully() {

	}

}
