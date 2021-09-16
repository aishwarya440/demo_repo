package testNG_basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ListnersParallel {

	static WebDriver driver;

	@BeforeMethod
	public void beforemethod() {
		
		  System.setProperty("webdriver.gecko.driver",
		  "C:\\Users\\Aishwarya\\eclipse-workspace\\Selenium_basics\\Jars\\geckodriver-v0.26.0-win64\\geckodriver.exe"
		  );
		  
		  FirefoxOptions options = new FirefoxOptions();
		  
		  options.addArguments("--test-type");
		  options.addArguments("--ignore-certificate-errors");
		  
		  driver = new FirefoxDriver(options); driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		  driver.get("https://www.flipkart.com/");
		 
		
		System.out.println("BeforeMethod");
		
	}

	@Test
	public void m1() {

		System.out.println("Method M1");

	}
	
	@Test
	public void m2() {

		System.out.println("Method M2");

	}

	
	@Test
	public void m3() {

		System.out.println("Method M3");

	}

	@Test
	public void m4() {

		System.out.println("Method M4");

	}


}
