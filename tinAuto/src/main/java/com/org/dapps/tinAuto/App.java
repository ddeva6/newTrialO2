package com.org.dapps.tinAuto;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class App
{
	
	
    public static void main( String[] args ) throws InterruptedException
    {
    	    	System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
    			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
    			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
    			WebDriver driver = new FirefoxDriver();
    			WebDriverWait wait4 = new WebDriverWait(driver, 60, 1000);
    			driver.get("https://onlineservices.tin.egov-nsdl.com/etaxnew/tdsnontds.jsp");
    			((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    			Thread.sleep(5000);
    			WebElement challan = wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='280']")));
    			System.out.println(challan.getText());
    			challan.click();
    			Thread.sleep(10000);
    			driver.close();
    }
}
