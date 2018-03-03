/**
 *
 */
package it.tsc.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;

import it.tsc.domain.Allarmi;
import it.tsc.domain.User;

/**
 * @author astraservice
 *
 */
@RunWith(ConcurrentTestRunner.class)
public class DomainTest extends BaseDomainTest {

	@Test
	public void allarmsTest() {
		TypedQuery<String> findQuery = getEntityManager()
				.createNamedQuery(Allarmi.ALLARM_FIND_QUERY, String.class);
		List<String> allAllarms = findQuery.getResultList();
		assertEquals(0L, allAllarms.size());
		assertNotNull(getEntityManager());
	}

	@Test
	public void userTest() {
		TypedQuery<User> findQuery = getEntityManager().createQuery(
				"Select u from Users u where u.key.username = :username",
				User.class);
		findQuery.setParameter("username", "admin");
		List<User> allUsers = findQuery.getResultList();
		assertNotNull(getEntityManager());
	}

	@Test
	public void userTestAndRole() {
		TypedQuery<User> findQuery = getEntityManager().createQuery(
				"Select u from Users u where u.key.username = :username and u.key.role = :role",
				User.class);
		findQuery.setParameter("username", "admin");
		findQuery.setParameter("role", "ROLE_SADMIN");
		List<User> allUsers = findQuery.getResultList();
		assertNotNull(getEntityManager());
	}

}
