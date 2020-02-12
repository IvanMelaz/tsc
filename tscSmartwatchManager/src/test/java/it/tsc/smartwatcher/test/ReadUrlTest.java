package it.tsc.smartwatcher.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.tsc.smartwatch.Application;
import it.tsc.smartwatch.config.DevelopmentConfig;
import it.tsc.smartwatch.domain.CodaEve;
import it.tsc.smartwatch.utils.JsonUtil;
import it.tsc.smartwatch.utils.UrlConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class, DevelopmentConfig.class})
@ActiveProfiles(value = "production")
public class ReadUrlTest {
	private static final Logger log = LoggerFactory
			.getLogger(ReadUrlTest.class);

	@Autowired
	private UrlConfig urlConfig;

	@Test
	public void readUrl() {
		if (urlConfig.readJsonFromUrl().isPresent()) {
			String data = urlConfig.readJsonFromUrl().get();
			log.info("read data:{}", data);
			Gson gson = new GsonBuilder().setDateFormat("mm DD, yyyy")
					.excludeFieldsWithoutExposeAnnotation().create();
			List<CodaEve> codaEves = JsonUtil.getGsonConverter()
					.fromJson(data, new TypeToken<List<CodaEve>>() {
					}.getType());
			for (CodaEve codaEve : codaEves) {
				String telefono = codaEve.getTelefono();
				log.info("insert telefono: {}", telefono);
				if (!StringUtils.isEmpty(telefono)) {
					UUID uuid = UUID.randomUUID();
				}
			}
		} else {
			log.info("data not present: {}",urlConfig.readJsonFromUrl());
		}
	}

	@Test
	public void readFromString() {
		String content = "[{\"id_allarme\":\"20191105181134FEF3EEBB5D9C0249_SMARTWATCH\",\"ab_codi\":\"??????\",\"matricola\":\"\",\"evento\":\"Tel\",\"nominativo\":\"NON ASSOCIATO\",\"data\":\"Nov 5, 2019\",\"ora\":\"06:11:34 PM\",\"user\":\"\",\"telefono\":\"+467191200110053\",\"fileName\":\"42e968a8-a0c1-41b1-84d1-67dae6ecd4c8 .wav\"},{\"id_allarme\":\"20191121145646C62EA31A2E3E6B81_SMARTWATCH\",\"ab_codi\":\"??????\",\"matricola\":\"\",\"evento\":\"Tel\",\"nominativo\":\"NON ASSOCIATO\",\"data\":\"Nov 21, 2019\",\"ora\":\"02:56:46 PM\",\"user\":\"\",\"telefono\":\"+467191200110053\",\"fileName\":\"b2d54aca-6c93-4a70-a23c-09f5c18edf03 .wav\"},{\"id_allarme\":\"20191121150130A58C57D2838E7166_SMARTWATCH\",\"ab_codi\":\"??????\",\"matricola\":\"\",\"evento\":\"Tel\",\"nominativo\":\"NON ASSOCIATO\",\"data\":\"Nov 21, 2019\",\"ora\":\"03:01:30 PM\",\"user\":\"\",\"telefono\":\"+467191200110053\",\"fileName\":\"1ef80c97-aafa-4245-b1c5-86beb4d90b67 .wav\"},{\"id_allarme\":\"20200122185728180F9960AE3F60B6_SMARTWATCH\",\"ab_codi\":\"??????\",\"matricola\":\"\",\"evento\":\"Tel\",\"nominativo\":\"NON ASSOCIATO\",\"data\":\"Jan 22, 2020\",\"ora\":\"06:57:28 PM\",\"user\":\"\",\"telefono\":\"+467191200110053\",\"fileName\":\"548be716-f5e9-48a8-97cd-a423465f1243 .wav\"},{\"id_allarme\":\"20200211145814A0708A86B5DEABE6_SMARTWATCH\",\"ab_codi\":\"??????\",\"matricola\":\"\",\"evento\":\"Tel\",\"nominativo\":\"NON ASSOCIATO\",\"data\":\"Feb 11, 2020\",\"ora\":\"02:58:14 PM\",\"user\":\"\",\"telefono\":\"+41770742031\",\"fileName\":\"dee09410-c527-4755-b193-f366f5e99ce7 .wav\"}]";
		Gson gson = new GsonBuilder().setDateFormat("mm DD, yyyy")
				.excludeFieldsWithoutExposeAnnotation().create();
		List<CodaEve> codaEves = JsonUtil.getGsonConverter()
				.fromJson(content, new TypeToken<List<CodaEve>>() {
				}.getType());
		codaEves.stream().forEach(ce ->log.info("id: {} data: {} ora: {}",ce.getId_allarme(),ce.getData(),ce.getOra()));
	}
}
