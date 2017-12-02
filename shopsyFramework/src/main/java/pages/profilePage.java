package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.org.dapps.shopsyFramework.basePage;
import com.relevantcodes.extentreports.ExtentTest;

public class profilePage extends basePage{
	
	WebDriver driver;
	ExtentTest testLog;
	
	@FindBy(xpath="//*[@id='profile_form']//input[@type='button' or @value='Choose File ...']")
	WebElement selectFile;
	@FindBy(xpath="//*[@id='ErrImage']")
	WebElement errorMsg;
	@FindBy(xpath="//*[@id='profile_submit']")
	WebElement save;
	


	public profilePage(WebDriver Driver, ExtentTest TestLog) {
		super(Driver,TestLog);
		this.driver=Driver;
		this.testLog=TestLog;
		PageFactory.initElements(Driver, this);
	}

	public profilePage clickChooseFile() {
		Assert.assertEquals(elementClick(selectFile), true);		
		return new profilePage(driver,testLog);
	}
	public profilePage selectFileAction() {
		Assert.assertEquals(executeXternalExe("C:\\Users\\Devakumar M\\newTrialO2\\shopsyFramework\\externalEXE\\imgUpload.exe"), true);		
		return new profilePage(driver,testLog);
	}
	
	public profilePage checkErrorMsg() {
		if(elementVisiblity(errorMsg)) {
			boolean result = errorMsg.getText().equalsIgnoreCase("Success");
			Assert.assertEquals(result, true);
		}
		return new profilePage(driver,testLog);
	}
	public profilePage scrollDown() {
		scroll("window.scrollTo(0, document.body.scrollHeight)");
		return new profilePage(driver,testLog);
	}
	
	public profilePage savechanges() {
		Assert.assertEquals(elementClick(save), true);
		return new profilePage(driver,testLog);
	}
	
	
	

}
