package Academy;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;
import java.util.Locale;

public class ValidateNavbar extends Base {

	@Test
	public void basePageNavigation() throws IOException {
		driver = initDriver();
		String url = properties.getProperty("url");
		driver.get(url);
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getCloseIframeButton().click();
		Assert.assertTrue(landingPage.getNavbar().isDisplayed());
		driver.quit();
	}
}
