package com.org.dapps.tinAuto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class App 
{
    public static void main( String[] args )
    {
    	    	System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
    			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
    			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
    			WebDriver driver = new FirefoxDriver();
    			WebDriverWait wait4 = new WebDriverWait(driver, 60, 1000);
    			driver.get("https://onlineservices.tin.egov-nsdl.com/etaxnew/tdsnontds.jsp");
    }
}
