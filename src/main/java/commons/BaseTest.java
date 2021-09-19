package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.SignInPage;

public class BaseTest {

	protected WebDriver driver;
	protected SignInPage signInPage;
	protected HomePage homePage;
	protected static String browser = null;

	@BeforeTest
	public void openBrowserAndSignIn() {

		browser = System.getProperty("browser");
		if (browser == null) {
			browser = "chrome";
		}

		switch (browser.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Invalid browser name. Please check again!");
		}

		driver.manage().window().maximize();
		driver.get(Constants.URL);
		driver.manage().timeouts().implicitlyWait(Constants.TIMEOUT, TimeUnit.SECONDS);
		signInPage = new SignInPage(driver);
		homePage = signInPage.signIn(Constants.EMAIL, Constants.PASSWORD);

	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}

}
