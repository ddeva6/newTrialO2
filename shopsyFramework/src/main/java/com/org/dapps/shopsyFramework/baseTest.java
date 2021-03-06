package com.org.dapps.shopsyFramework;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import pages.homeAfterLogin;
import pages.homePage;
import pages.profilePage;

public class baseTest{
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest testLog;
	homePage homeObj;
	homeAfterLogin homeAfterLoginObj;
	profilePage profilePageObj;
		
	@BeforeSuite
	public void config(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyMMddhhmmss");
		report = new ExtentReports(System.getProperty("user.dir")+"/Reports/Samplereport"+(dateFormat.format(new Date()))+".html", true);
	}
	
	@BeforeTest
	@Parameters("Browser")
	public void initialize(@Optional("firefox") String Browser)throws Exception{
		if(Browser.equalsIgnoreCase("firefox")){
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		driver = new FirefoxDriver();
	}
	else if(Browser.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	else if(Browser.equalsIgnoreCase("Edge")){
		System.setProperty("webdriver.edge.driver","./Drivers/MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
			}
	else if(Browser.equalsIgnoreCase("Opera")){
		System.setProperty("webdriver.opera.driver","./Drivers/operadriver.exe");
		driver = new OperaDriver();
			}
	else{
		throw new Exception("Browser is not correct");
	}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().refresh();
		testLog = report.startTest("Shopsy");
		this.homeObj = new homePage(driver,testLog);
	}
	
@AfterMethod
	public void attachScreenshot(ITestResult result) {
		if((result.getStatus()==ITestResult.FAILURE)) {
			testLog.log(LogStatus.FAIL, "test failed "+result.getName());
			testLog.log(LogStatus.INFO, "Details "+result.getThrowable());
			try {
			String screenPath = screenShot.capture(driver);
			testLog.log(LogStatus.FAIL, testLog.addBase64ScreenShot(screenPath));
			}
			catch (Exception e) {
				testLog.log(LogStatus.ERROR, "unable to take screenShot");
				testLog.log(LogStatus.INFO, e);
			}
			}
		
	}
	
	@AfterTest
	public void termination() {
		driver.quit();
		report.endTest(testLog);
		
	}
	
	@AfterSuite
	public void finish() {
		report.flush();
		report.close();
	}
	

}
