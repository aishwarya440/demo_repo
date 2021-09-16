package testNG_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersTest {
	WebDriver driver;  

	@Parameters({"driverValue", "url"})
	@BeforeMethod
	public void launchBrowserTest(String driverValue, String urlApp) {

		switch (driverValue) {

		case "chrome":

			driver = new ChromeDriver();

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			driver.get(urlApp);

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\Aishwarya\\eclipse-workspace\\Selenium_basics\\Jars\\geckodriver-v0.26.0-win64\\geckodriver.exe");

			FirefoxOptions options = new FirefoxOptions();

			options.addArguments("--test-type");
			options.addArguments("--ignore-certificate-errors");

			driver = new FirefoxDriver(options);

			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(urlApp);
		}
	}

	// (invocationCount=5) ------------number of times TestNg should run this test
	@Test(invocationCount = 2)
	public void getTitle() {
		System.out.println(driver.getTitle());

	}

	
	//expectedExceptions=ArithmeticException.class---- if any exception is expected
	
	@Test(expectedExceptions=ArithmeticException.class)
	public void getAttributeValue() {
		System.out.println(driver.findElement(By.linkText("Gmail")).getAttribute("class"));
		int i=9/0;
	}

	@Test(enabled=false) //-------------to stop execution og this test
	public void getElementEnabled() {
		boolean b = driver.findElement(By.linkText("Gail")).isEnabled();
		System.out.println("Gmail link is enable? " + b);

	}

	@Test
	public void tearDownafterMethodLevel() {
		driver.close();
		System.out.println("@AfterMethod - will execute after every test case");
	}
}