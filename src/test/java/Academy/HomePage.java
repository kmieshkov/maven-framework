package Academy;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;

public class HomePage extends Base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initDriver();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password, String text) {
		String url = properties.getProperty("url");
		driver.get(url);
		LandingPage landingPage = new LandingPage(driver);
		if (landingPage.isCloseButtonPresent()) {
			landingPage.getCloseButton().click();
		}
		landingPage.getLogin().click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(email);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginButton().click();
		System.out.println(text);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];
		data[0][0] = "non.restricted@email.com";
		data[0][1] = "password123";
		data[0][2] = "Non Restricted";
		data[1][0] = "restricted@email.com";
		data[1][1] = "password123";
		data[1][2] = "Restricted";
		return data;
	}

	@AfterTest
	public void teardown() {
		driver.quit();
		driver = null;
	}
}
