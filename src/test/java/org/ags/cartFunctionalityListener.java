package org.ags;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class cartFunctionalityListener implements ITestListener {

	public void onTestStart(ITestResult result) {
       	
	}

	public void onTestSuccess(ITestResult result) {
		

		TakesScreenshot t = (TakesScreenshot)cartFunctionality.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("./cartFunctionality.png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
	}

	public void onTestFailure(ITestResult result) {
		
		
		TakesScreenshot t = (TakesScreenshot)cartFunctionality.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("./cartFunctionaity.png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
	}

	public void onTestSkipped(ITestResult result) {
		

		TakesScreenshot t = (TakesScreenshot)cartFunctionality.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File des = new File("./cartFunctionality.png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		
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
