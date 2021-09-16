package testNG_basics;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleTest {
	static WebDriver driver;

	@Parameters({ "driverValue", "url" })
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
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(urlApp);
			WebElement ele = driver.findElement(By.xpath("//button[text()='✕']"));
			boolean b = ele.isDisplayed();
			Assert.assertTrue(b);
			ele.click();
		}
	}

	@Parameters("number")
	@Test(priority = 1, enabled = false)
	public void hoverLogin(String num) {

		WebElement ele1 = driver.findElement(By.xpath("//a[text()='Login']"));

		Actions a = new Actions(driver);

		a.moveToElement(ele1).perform();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement ele2 = driver.findElement(By.xpath("//div[@class=\"_32Nmy9\"]/div[text()='Sign Up']"));
		a.moveToElement(ele2).click().build().perform();

		WebElement ele3 = driver.findElement(By.xpath("//div[button[text()='✕']]//input"));
		boolean b = ele3.isEnabled();
		Assert.assertTrue(b);
		a.moveToElement(ele3).sendKeys(num).build().perform();

		driver.findElement(By.xpath("//span[text()='CONTINUE']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.alertIsPresent());

		String text = driver.switchTo().alert().getText();

		System.out.println(text);

	}

	@Test(dataProvider="dataMethod")
	public void dataMethod1(String data1, String data2) {
String arr1=data1;
String arr2=data2;

	System.out.println(arr1);
	System.out.println(arr2);

		ArrayList<Object> list = new ArrayList<Object>();
		list.add(10);
		list.add("Ten");
		list.add(1234567);
		list.add(17.25);

		System.out.println(list);

	}

	@DataProvider 
	public Object[][] dataMethod() {

		Object[][] arr = new Object[3][2];

		arr[0][0] = "Data1";
		arr[0][1] = "Data1";

		arr[1][0] = "Data2";
		arr[1][1] = "Data2";

		arr[2][0] = "Data3";
		arr[2][1] = "Data3";

		return arr;

	}

}
