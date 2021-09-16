package listenerspackage;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testNG_basics.LaunchBrowserTest;

public class Listeners_Class extends LaunchBrowserTest  implements ITestListener {

//	public WebDriver driver = null;
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		String testName = result.getName();		
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFilePath = System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
		
		try {
			FileUtils.copyFile(src, new File(destFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Test Success - Listeners");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		 
		System.out.println("Test Failed - Listeners");
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Skipped - Listeners");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Start - Listeners");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Finish - Listeners");

	}

}
