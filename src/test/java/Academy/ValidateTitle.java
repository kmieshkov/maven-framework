package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateTitle extends Base {

	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initDriver();
		Log.info("Driver is initialized");
		String url = properties.getProperty("url");
		driver.get(url);
		Log.info("Navigated to the Home Page");
	}

	@Test
	public void basePageNavigation() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getCloseButton().click();
		Assert.assertTrue(landingPage.getTitle().getText().equalsIgnoreCase("Featured Courses123"));
		Log.info("Successfully validated Title text message");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
