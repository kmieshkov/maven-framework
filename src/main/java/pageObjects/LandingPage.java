package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;
	By login = By.xpath("//span[contains(text(), 'Login')]");
	By closeIframe = By.xpath("//button[contains(text(),'NO THANKS')]");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getCloseIframeButton() {
		return driver.findElement(closeIframe);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}
}
