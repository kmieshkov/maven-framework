package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateNavbar extends Base {

	public static Logger Log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initDriver();
		String url = properties.getProperty("url");
		Log.info("Driver is initialized");
		driver.get(url);
		Log.info("Navigated to the Home Page");
	}

	@Test
	public void basePageNavigation() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getCloseButton().click();
		Assert.assertTrue(landingPage.getNavbar().isDisplayed());
		Log.info("Navigation Bard is displayed");
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}
}
