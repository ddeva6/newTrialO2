package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.org.dapps.tinAuto.pageAction;
import com.relevantcodes.extentreports.ExtentTest;

public class tinHomePage extends pageAction{
	
	WebDriver driver;
	ExtentTest testLog;
	
	@FindBy(xpath="//*[@id='280' or contains(text(),'(Payment of Income tax & Corporation Tax)')]")
	WebElement challan280;
	public tinHomePage(WebDriver Driver, ExtentTest TestLog) {
		super(Driver,TestLog);
		this.driver = Driver;
		this.testLog = TestLog;
		PageFactory.initElements(driver, this);
	}

	public tinHomePage gotoBaseURL() {
		Assert.assertEquals(VerifyURl("https://onlineservices.tin.egov-nsdl.com/etaxnew/tdsnontds.jsp", "e-TAX Payment System"), true);
		return new tinHomePage(driver, testLog);
		
	}
	public ePaymentPage selectchallan() {
		Assert.assertEquals(scroll("window.scrollBy(0,document.body.scrollHeight)"), true);
		Assert.assertEquals(elementClick(challan280), true);
		return new ePaymentPage(driver, testLog);
	}

}
