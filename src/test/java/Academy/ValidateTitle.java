package Academy;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateTitle extends Base {

	@Test
	public void basePageNavigation() throws IOException {
		driver = initDriver();
		driver.get("https://qaclickacademy.com");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getCloseIframeButton().click();
		Assert.assertTrue(landingPage.getTitle().getText().equalsIgnoreCase("Featured Courses"));
		driver.quit();
	}
}
