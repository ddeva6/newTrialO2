package com.org.dapps.tinAuto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class pageAction {
	
	WebDriver driver;
	WebDriverWait wait4;
	ExtentReports report;
	ExtentTest testLog;
	JavascriptExecutor js;
	Actions act;
	public pageAction(WebDriver Driver, ExtentTest TestLog) {
		this.driver = Driver;
		this.testLog = TestLog;
		this.wait4=new WebDriverWait(Driver, 60, 1000);
		this.js=(JavascriptExecutor)Driver;
		this.act = new Actions(Driver);
	}

	public boolean elementVisiblity(WebElement element) {
		boolean flag = false;
		try {
			wait4.until(ExpectedConditions.visibilityOf(element));
			flag=true;
			testLog.log(LogStatus.PASS, "Element is visible "+element.toString());
		}
		catch (Exception e) {
			testLog.log(LogStatus.FAIL, "Elementis not visible");
			testLog.log(LogStatus.ERROR, e);
		}
		return flag;
	}
	
	
	public boolean elementClick(WebElement element) {
		boolean flag = false;
		if(elementVisiblity(element)) {			
			flag=true;
			act.moveToElement(element).build().perform();
			element.click();
			testLog.log(LogStatus.PASS, "Element is clicked "+element.toString());
		}
		return flag;
	}
	
	public boolean clickAndType(WebElement element, String Data) {
		boolean flag = false;
		if(elementClick(element)) {
			element.clear();
			element.sendKeys(Data);
			flag = true;
			testLog.log(LogStatus.PASS, Data + "Data snt to element "+element.toString());
		}
		return flag;	
	}
	
	public void IdleWait(String TimeInSeconds)	{
		try {
			Thread.sleep(1000*Integer.parseUnsignedInt(TimeInSeconds));
			testLog.log(LogStatus.INFO, "idle wait for "+Integer.parseUnsignedInt(TimeInSeconds));
		}
		catch (Exception e) {
			testLog.log(LogStatus.ERROR, e);
		}
		
	}
	
	public boolean VerifyURl(String URL, String Title) {
		boolean flag = false; 
		try {
			driver.get(URL);
			
			Long loadtime = (Long)js.executeScript(
				    "return performance.timing.loadEventEnd - performance.timing.navigationStart;");
			testLog.log(LogStatus.INFO,"page loaded in "+loadtime+" millisecond");
				if(Title.equalsIgnoreCase(Title)) {
					testLog.log(LogStatus.INFO, "page looded successfully"+URL+"title"+Title);
					flag = true;
				}
		}
		catch (Exception e) {
			testLog.log(LogStatus.FAIL, "page is not looded");
			testLog.log(LogStatus.ERROR, e);
			
		}
		return flag;
	}
	public boolean dropDownSelect(WebElement element,String Data) {
		boolean flag = false;
		try {
			if(elementVisiblity(element)) {
				
				Select option = new Select(element);
				option.selectByVisibleText(Data);
				flag=true;
				testLog.log(LogStatus.PASS, Data+" selected from the drop down");
			}
		}
		catch (Exception e) {
			testLog.log(LogStatus.FAIL, "unable to select dropdown");
			testLog.log(LogStatus.ERROR, e);
		}
		return flag;
		
	}
	
	public boolean DOMcompleted() {
		boolean flag = false;
		
		try {
			long start = System.currentTimeMillis();
			do {
				 Thread.sleep(5000);
			    }while(js.executeScript("return document.readyState").equals("complete"));
			long stop = System.currentTimeMillis();
			flag = true;
			testLog.log(LogStatus.PASS, "page loading completed in "+(stop-start)+" ms");
		    }
			catch (Exception e) {
				testLog.log(LogStatus.FAIL, "Page is not get loaded");
				testLog.log(LogStatus.ERROR, e);
			}
		return flag;
				
		}
	
	
	public boolean scroll(String data) {
		boolean flag = true;
		try {
		js.executeScript(data);
		IdleWait("5");
		testLog.log(LogStatus.INFO, data +" page is successfully scrolled");
		flag=true;
			}
		catch (Exception e) {
			testLog.log(LogStatus.FAIL, "unable to scroll");
			testLog.log(LogStatus.ERROR, e);
			}
		return flag;
		}
	
	public String userNameGenx() {
		SimpleDateFormat Dateformat = new SimpleDateFormat("yyMMddhhmmss");
		Date dateObj = new Date();
		String datetext = Dateformat.format(dateObj);
		return datetext;
	}
	
	public String email(String Data) {
		String email = Data+"@yopmail.com";
		return email;
	}
	
	public boolean overAndClick(WebElement element) {
		boolean flag = false;
		try {
			if(elementVisiblity(element)) {
			act.moveToElement(element).click().build().perform();
			testLog.log(LogStatus.PASS, "Element clicked"+element.toString());
		}
			flag=true;

		}
			catch (Exception e) {
				testLog.log(LogStatus.FAIL, "mouse over and click element");
				testLog.log(LogStatus.ERROR, e);	
			}
		return flag;
	}
	
	public boolean executeXternalExe(String Data) {
		boolean flag = false;
		try {
			Runtime.getRuntime().exec(Data);
			testLog.log(LogStatus.PASS, "External exe executed on runtime");
			flag=true;
		}
		catch (Exception e) {
			testLog.log(LogStatus.FAIL, "file not found");
			testLog.log(LogStatus.ERROR, e);
		}
		return flag;
	}
			

}