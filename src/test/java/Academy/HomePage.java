package Academy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

import java.io.IOException;
import java.util.Iterator;

public class HomePage extends Base {

	@Test(dataProvider = "getData")
	public void basePageNavigation(String email, String password, String text) throws IOException {
		driver = initDriver();
		driver.get("https://qaclickacademy.com");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.getCloseIframeButton().click();
		landingPage.getLogin().click();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.getEmail().sendKeys(email);
		loginPage.getPassword().sendKeys(password);
		loginPage.getLoginButton().click();
		System.out.println(text);
		driver.quit();
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
}
