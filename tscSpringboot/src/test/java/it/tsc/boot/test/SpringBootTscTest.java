/**
 *
 */
package it.tsc.boot.test;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.tsc.domain.User;

/**
 * @author "astraservice"
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTscTest {

	@PersistenceContext
	private EntityManager em;

	/**
	 *
	 */
	public SpringBootTscTest() {
		
	}

	@Test
	public void testCreateClientSuccessfully() throws Exception {

	}

	@Test
	public void userTest() {
		TypedQuery<User> findQuery = em
				.createNamedQuery(User.SELECT_BY_USERNAME, User.class);
		findQuery.setParameter("username", "testUser");
		List<User> allUsers = findQuery.getResultList();
		assertNotNull(em);
	}

}
