package Academy;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateTitle extends Base {

	@Test
	public void basePageNavigation() throws IOException {
		driver = initDriver();
		String url = properties.getProperty("url");
		driver.get(url);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getCloseIframeButton().click();
		Assert.assertTrue(landingPage.getTitle().getText().equalsIgnoreCase("Featured Courses"));
		Assert.assertTrue(landingPage.getNavbar().isDisplayed());
		driver.quit();
	}
}
