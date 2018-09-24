/**
 *
 */
package it.tsc.smartwatcher.test;

import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import it.tsc.smartwatch.Application;
import it.tsc.smartwatch.config.H2JpaConfig;
import it.tsc.smartwatch.domain.repository.CodaEveDao;

/**
 * @author "astraservice"
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, H2JpaConfig.class})
@ActiveProfiles(value = "production")
public class ApplicationTest {
	private static final Logger log = LoggerFactory
			.getLogger(ApplicationTest.class);
	@Autowired
	private CodaEveDao codaEveDao;

	/**
	 *
	 */
	public ApplicationTest() {

	}

	@Test
	public void testDatasource() {
		assertNotNull("codaEveRepository cannot be null", codaEveDao);
	}

	@Test
	public void insertAllarme() {
		assertNotNull("codaEveRepository cannot be null", codaEveDao);
		String telefono = "0233402195";
		UUID uuid = UUID.randomUUID();
		codaEveDao.insertAllarmiInCodaEve_Brondi(telefono, uuid.toString(),
				"SMARTWATCH");
	}

	@Test
	public void removeAllarm() {
		assertNotNull("codaEveRepository cannot be null", codaEveDao);
		String allarm = "201809232217157D110DF163825EA5_MILANO";
		log.info("allarm: {}", allarm);
		codaEveDao.removeAllarme(allarm);
	}

}
