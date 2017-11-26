package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;

public class contactUs extends homePage{
	
	WebDriver driver;
	ExtentTest testLog;
	
	@FindBy(xpath="//*[@id='your_name']")
	WebElement nameElement;
	@FindBy(xpath="//*[@id='your_email']")
	WebElement emailElement;
	@FindBy(xpath="//*[@id='demo']")
	WebElement telElement;
	@FindBy(xpath="//*[@id='products']")
	WebElement dropDownElement;
	@FindBy(xpath="//*[@id='submit-form']")
	WebElement submitButton;
	@FindBy(xpath="//*[text()='Invalid Captcha']")
	WebElement errorText;
	

	public contactUs(WebDriver Driver, ExtentTest TestLog) {
		super(Driver,TestLog);
		this.driver=Driver;
		this.testLog=TestLog;
		PageFactory.initElements(Driver, this);
	}
	
	public contactUs setName(String name) {
		Assert.assertEquals(clickAndType(nameElement, name), true);
		return new contactUs(driver, testLog);
	}
	
	public contactUs setEmail(String email) {
		Assert.assertEquals(clickAndType(emailElement, email), true);
		return new contactUs(driver, testLog);
	}
	
	public contactUs setTel(String number) {
		Assert.assertEquals(clickAndType(telElement, number), true);
		return new contactUs(driver, testLog);
	}
	
	public contactUs setOption(String Data) {
		Assert.assertEquals(dropDownSelect(dropDownElement, Data), true);
		return new contactUs(driver, testLog);
	}
	
	public contactUs clickAndSubmit() {
		scroll("scroll(0, 250);");
		Assert.assertEquals(elementClick(submitButton), true);
		return new contactUs(driver,testLog);
	}
	public contactUs verifyProcess() {
		Assert.assertEquals(elementVisiblity(errorText), true);
		return new contactUs(driver, testLog);
	}
	
	

}