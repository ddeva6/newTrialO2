package com.org.dapps.shopsyFramework;

import org.testng.annotations.Test;

public class toTest extends baseTest{
		
	@Test(priority = 1)
	public void samplerun() {
		    String username = homeObj.userNameGenx();
			homeObj.gotoBaseURL().setLanguage();
			homeObj.clickRegister();
			homeObj.popupCheck().setFirstName("test").setLastName("test").setEmail(homeObj.email(username)).setPassword("123456")
			.setPasswordConfirm("123456").setUsername(username).clickSubmit().verifyLogin();
	}
	@Test(priority=2)
	public void uploadprofile() {
		homeAfterLoginObj.clickViewProfile().clickChooseFile(); //selectFileAction().checkErrorMsg().scrollDown().savechanges();
	}
	
	
	

}
