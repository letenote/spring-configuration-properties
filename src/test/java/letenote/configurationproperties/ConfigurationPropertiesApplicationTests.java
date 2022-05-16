package letenote.configurationproperties;

import letenote.configurationproperties.properties.ApplicationProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigurationPropertiesApplicationTests {
	@Autowired
	private ApplicationProperties applicationProperties;

	@Test
	void contextLoads() {
	}

	@Test
	void configurationPropertiesTest(){
		String applicationNameExpected = "spring-configuration-properties";
		Integer applicationVersionExpected = 1;
		boolean applicationProductionModeExpected = false;

		Assertions.assertEquals(applicationNameExpected,applicationProperties.getName());
		Assertions.assertEquals(applicationVersionExpected,applicationProperties.getVersion());
		Assertions.assertEquals(applicationProductionModeExpected,applicationProperties.isProductionMode());
	}

	@Test
	void complexConfigurationPropertiesTest(){
		String applicationDatabaseUsernameExpected = "database-username";
		String applicationDatabasePasswordExpected = "secret";
		String applicationDatabaseUrlExpected = "https://mongodb.com/bla/bla/bla";

		Assertions.assertEquals(applicationDatabaseUrlExpected,applicationProperties.getDatabase().getUrl());
		Assertions.assertEquals(applicationDatabaseUsernameExpected,applicationProperties.getDatabase().getUsername());
		Assertions.assertEquals(applicationDatabasePasswordExpected,applicationProperties.getDatabase().getPassword());
	}
}
