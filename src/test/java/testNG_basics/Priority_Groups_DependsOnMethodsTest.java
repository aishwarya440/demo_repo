package testNG_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Priority_Groups_DependsOnMethodsTest {

	

	static WebDriver driver;

	@BeforeMethod
	public void launchBrowserTest() {
		System.setProperty("webdriver.gecko.driver",
				"C:\\Users\\Aishwarya\\eclipse-workspace\\Selenium_basics\\Jars\\geckodriver-v0.26.0-win64\\geckodriver.exe");

		FirefoxOptions options = new FirefoxOptions();

		options.addArguments("--test-type");
		options.addArguments("--ignore-certificate-errors");

		driver = new FirefoxDriver(options);

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
	}

	@Test(priority = 1, groups = "Smoke")
	public void getTitle1() {
		System.out.println(driver.getTitle());

	}

	@Test(priority = 2, groups = "Smoke",dependsOnMethods={"getTitle1","refresh"})
	public void click() {
		driver.findElement(By.xpath("//button[text()='✕']")).click();

	}

	@Test(priority = 3, groups = "Regression")
	public void refresh() {
		driver.navigate().refresh();

	}
	
	
	@Test(priority = 4, groups = "Regression",dependsOnMethods="getTitle1")
	public void search() {
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("Mobile Phone");

	}
	
	@Test
	public void getElementEnabled() {
	boolean b=	driver.findElement(By.xpath("//a[text()='Login']")).isEnabled();
		System.out.println("Login link is enable? "+b );
		
		
	}


	@AfterMethod
	public void tearDown() {
		driver.close();
		System.out.println("@AfterMethod - will execute after every test case");
	}

}
