package testNG_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LaunchBrowserTest {

	public WebDriver driver;

	@BeforeSuite
	public void beforesuitLevel() {
		System.out.println("@BeforeSuite --- method");
	}

	@BeforeTest
	public void beforetestLevel() {
		System.out.println("@BeforeTest --- method");
	}

	@BeforeClass
	public void classLevel() {
		System.out.println("@BeforeClass --- method");
	}

	@BeforeMethod
	public void launchBrowserTest() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Aishwarya\\eclipse-workspace\\Selenium_basics\\Jars\\geckodriver-v0.26.0-win64\\geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();

		options.addArguments("--test-type");
		options.addArguments("--ignore-certificate-errors");

		driver = new FirefoxDriver(options);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}

	@Test(enabled = false)
	public void getTitle() {
		System.out.println(driver.getTitle());

	}

	@Test
	public void getAttributeValue() {
		System.out.println(driver.findElement(By.linkText("Gmail")).getAttribute("class"));
		int i=9/0;
	}

	@Test(enabled = false)
	public void getElementEnabled() {
		boolean b = driver.findElement(By.linkText("Gail")).isEnabled();
		System.out.println("Gmail link is enable? " + b);

	}

	@AfterMethod
	public void tearDownafterMethodLevel() {
		driver.close();
		System.out.println("@AfterMethod - will execute after every test case");
	}

	@AfterClass
	public void afterClassLevel() {
		System.out.println("@AfterClass - will execute after all the test acses from the class are executed");
	}

	@AfterTest
	public void afterTestLevel() {
		System.out.println("@AfterMethod - will execute after every test case");
	}

	@AfterSuite
	public void afterSuitLevel() {
		System.out.println("@AfterSuite --- method");
	}
}
