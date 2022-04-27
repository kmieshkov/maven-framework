package Academy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 return driver;
	 }

	 public void getScreenshot(String fileName) throws IOException {
		 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date(System.currentTimeMillis());
		 String timestamp = formatter.format(date);

		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(src, new File("./screenshots/" + fileName + " " + timestamp + ".png"));
	 }
}
