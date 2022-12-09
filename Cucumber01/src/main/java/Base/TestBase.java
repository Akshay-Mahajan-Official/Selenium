package Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import Contants.AppConstant;
import Utility.PropertiesReader;

public class TestBase {
	public static WebDriver driver;

	private org.slf4j.Logger logger = LoggerFactory.getLogger(TestBase.class);

	@BeforeMethod
	public WebDriver initalizeDriver() throws InterruptedException, IOException {

		String browsername = PropertiesReader.getValue("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", AppConstant.getChromePath());
			driver = new ChromeDriver();
		}

		else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		logger.info("Initializing " + browsername + " driver");
		int implicitTime = Integer.parseInt(PropertiesReader.getValue("ImplicitWait"));
		int pageloadTime = Integer.parseInt(PropertiesReader.getValue("PageLoadTime"));
		driver.manage().timeouts().pageLoadTimeout(pageloadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PropertiesReader.getValue("application.url"));
		return driver;
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
		logger.info("Closing driver");
	}

}