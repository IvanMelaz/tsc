/**
 *
 */
package it.tsc.domain.test;

import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import it.tsc.data.config.ServiceConfig;
import it.tsc.domain.Role;
import it.tsc.domain.User;
import it.tsc.domain.key.UserKey;

/**
 * @author astraservice
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ServiceConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserDomainSpringTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDomainSpringTest.class);
	@Autowired
	private EntityManager entityManager;

	@Test
	public void baseTest() {
		assertNotNull(entityManager);
	}

	@Test
	public void testUsers() {
		UserKey key1 = new UserKey("matteo", Role.ROLE_ADMIN);
		User users1 = new User(key1, true);

		UserKey key2 = new UserKey("matteo", Role.ROLE_USER);
		User users2 = new User(key2, true);

		// Group group1 = new Group(key1, "MILANO");
		// Group group2 = new Group(key1, "NAPOLI");
		// Group group3 = new Group(key2, "NAPOLI");

		// entityManager.persist(group1);
		// entityManager.persist(group2);
		// entityManager.persist(group3);
		entityManager.persist(users1);
		entityManager.persist(users2);
		logger.debug("groups: {}", entityManager.isOpen());
		// for (Group group : users1.getGroups(entityManager)) {
		// logger.debug(JsonUtil.getGsonConverter().toJson(group));
		// }

	}

}
