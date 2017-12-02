package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.org.dapps.tinAuto.pageAction;
import com.relevantcodes.extentreports.ExtentTest;

public class ePaymentPage extends pageAction{
	
	WebDriver driver;
	ExtentTest testLog;

	public ePaymentPage(WebDriver Driver, ExtentTest TestLog) {
		super(Driver,TestLog);
		this.driver=Driver;
		this.testLog=TestLog;
		PageFactory.initElements(driver, this);
	}
	
	

}
