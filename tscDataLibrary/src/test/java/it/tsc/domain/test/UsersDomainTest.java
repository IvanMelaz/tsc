/**
 *
 */
package it.tsc.domain.test;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;

import it.tsc.domain.Group;
import it.tsc.domain.Users;
import it.tsc.util.JsonUtil;

/**
 * @author astraservice
 *
 */
@RunWith(ConcurrentTestRunner.class)
public class UsersDomainTest extends BaseDomainTest {

	@Test
	public void testJsonScript1() throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT groupname from tsc_group", Group.class);
		logger.debug("query: {}",
				JsonUtil.getGsonConverter().toJson(query.getResultList()));
	}

	@Test
	public void testJsonScript2() throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT groupName from tsc_group", Group.class);
		// query.setParameter("role", users1.getKey().getRole());
		logger.debug("query: {}",
				JsonUtil.getGsonConverter().toJson(query.getResultList()));
	}

	@Test
	public void testJsonScript3() throws NoSuchMethodException,
			IllegalAccessException, InvocationTargetException {
		TypedQuery<Users> query = getEntityManager()
				.createNamedQuery(Users.SELECT_ALL_USERS, Users.class);
		List<Users> u = query.getResultList();
	}

}
