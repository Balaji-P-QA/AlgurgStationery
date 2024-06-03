package org.ags;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	
	WebDriver driver;

	public void onTestStart(ITestResult result) {
    
		
	}

	public void onTestSuccess(ITestResult result) {
    
		TakesScreenshot t = (TakesScreenshot)ProductPurchase.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("./proof.png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestFailure(ITestResult result) {
     
		TakesScreenshot t = (TakesScreenshot)ProductPurchase.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("./proof.png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
