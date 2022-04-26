package Academy;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateTitle extends Base {

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
		System.out.println(landingPage.getTitle().getText());
		System.out.println(landingPage.getNavbar().isDisplayed());
		Assert.assertTrue(landingPage.getTitle().getText().equalsIgnoreCase("Featured Courses"));
		Assert.assertTrue(landingPage.getNavbar().isDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
