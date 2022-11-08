package testbase;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExelDataProvider;
import utility.Helper;

public class BaseClass {
	public WebDriver driver;
	public ExelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setUpSuite() {
		excel = new ExelDataProvider();
		config = new ConfigDataProvider();
		ExtentSparkReporter  extent = new ExtentSparkReporter (new File(System.getProperty("user.dir") + "/reports/Actitime_"+ Helper.getCurrentDateTime() +".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		PropertyConfigurator.configure("Log4j.properties");
	}
	
	@BeforeClass
	public void setup() {
		 driver = BrowserFactory.startApplication(driver, config.getBrowser(),config.getQAUrl());
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.fail("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
		}
		
		report.flush();
	}
	

}
