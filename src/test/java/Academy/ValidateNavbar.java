package Academy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateNavbar extends Base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initDriver();
		String url = properties.getProperty("url");
		driver.get(url);
	}

	@Test
	public void basePageNavigation() {
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getCloseButton().click();
		Assert.assertTrue(landingPage.getNavbar().isDisplayed());

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
