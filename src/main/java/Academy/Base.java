package Academy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

	public static WebDriver driver;
	public Properties properties = new Properties();

	 public WebDriver initDriver() throws IOException {
		 properties.load(new FileInputStream("src/main/resources/data.properties"));
		 String browserName = properties.getProperty("browser").toLowerCase(Locale.ROOT);
		 switch (browserName) {
			 case "firefox":
				 WebDriverManager.firefoxdriver().setup();
				 driver = new FirefoxDriver();
				 break;
			 case "ie":
				 WebDriverManager.iedriver().setup();
				 driver = new InternetExplorerDriver();
				 break;
			 case "edge":
				 WebDriverManager.edgedriver().setup();
				 driver = new EdgeDriver();
				 break;
			 case "opera":
				 WebDriverManager.operadriver().setup();
				 driver = new OperaDriver();
				 break;
			 case "safari":
				 WebDriverManager.safaridriver().setup();
				 driver = new SafariDriver();
				 break;
			 default:
				 WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				 break;
		 }
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 return driver;
	 }
}
