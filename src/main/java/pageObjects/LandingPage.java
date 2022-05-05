package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;
	private final By login = By.xpath("//span[contains(text(), 'Login')]");
	private final By closeButton = By.xpath("//button[contains(text(),'NO THANKS')]");
	private final By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private final By navbar = By.cssSelector(".navbar-collapse.collapse");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}

	public WebElement getCloseButton() {
		return driver.findElement(closeButton);
	}

	public boolean isCloseButtonPresent() {
		return driver.findElements(closeButton).size() > 0;
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getNavbar() {
		return driver.findElement(navbar);
	}
}
