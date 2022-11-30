package qa.luma.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import qa.luma.Utils.readConfig;

import org.apache.logging.log4j.*;

public class TestBase {

	public static WebDriver driver;

	public static Logger log;

	readConfig readconfig = new readConfig();

	@Parameters("browsername")
	@BeforeMethod
	public void setUp(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("Google chrome")
				|| browser.equalsIgnoreCase("GC")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromeDriverPath());
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox") || browser.equalsIgnoreCase("FF")
				|| browser.equalsIgnoreCase("Mizila Firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxDriverPath());
			driver = new FirefoxDriver();
			System.out.println("Firefox Started " + Thread.currentThread().getId());
		} else {
			log.info("Check Your Browser Name..");
		}
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();

		log = LogManager.getLogger(TestBase.class);
		log.info("Browser Opend Successfully.");
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
		log.info("Browser Closed.");
	}

}
