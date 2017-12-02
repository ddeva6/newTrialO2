package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.org.dapps.shopsyFramework.basePage;
import com.relevantcodes.extentreports.ExtentTest;

public class homeAfterLogin extends basePage{
	
	WebDriver driver;
	ExtentTest testLog;
	
	@FindBy(xpath="//*[@id='you1']")
	WebElement profileIcon;
	@FindBy(xpath="//*[text()='View Profile']")
	WebElement viewprofile;
	

	public homeAfterLogin (WebDriver Driver, ExtentTest TestLog) {
		super(Driver,TestLog);
		this.driver=Driver;
		this.testLog=TestLog;
		PageFactory.initElements(Driver, this);
	}
	
	public homeAfterLogin verifyLogin() {
		Assert.assertEquals(elementVisiblity(profileIcon), true);
		return new homeAfterLogin(driver, testLog);
		
	}
	
	public profilePage clickViewProfile() {
		Assert.assertEquals(elementClick(profileIcon), true);
		Assert.assertEquals(overAndClick(viewprofile), true);
		return new profilePage(driver, testLog);
	}
	
	
}
