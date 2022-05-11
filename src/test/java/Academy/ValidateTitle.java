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
	LandingPage landingPage;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initDriver();
		Log.info("Driver is initialized");
		String url = properties.getProperty("url");
		driver.get(url);
		Log.info("Navigated to the Home Page");
		landingPage = new LandingPage(driver);
		landingPage.getCloseButton().click();
	}

	@Test
	public void validateAppTitle() {
		Assert.assertTrue(landingPage.getTitle().getText().equalsIgnoreCase("Featured Courses"));
		Log.info("Successfully validated Title text message");
	}

	@Test
	public void validateAppHeader() {
		Assert.assertTrue(landingPage.getHeader().getText().equalsIgnoreCase("AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING"));
		Log.info("Successfully validated Header text message");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
