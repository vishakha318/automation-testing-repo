package pageEvents;

import org.testng.Assert;

import pageObject.LoginPageElements;
import utils.FetchElement;

public class LoginPageEvents {
	
	FetchElement loginPage = new FetchElement();

	public void verifyLoginPageIsLoaded() {
		
		Assert.assertTrue( loginPage.getElements("XPATH", LoginPageElements.loginText).size() > 0, "Login button is sucessfully loaded");
		
	}
	
	public void enterCredentials() {
		loginPage.getElement("XPATH", LoginPageElements.emailAddress).sendKeys("rmishra@gmail.com");
		loginPage.getElement("XPATH", LoginPageElements.passwordField).sendKeys("12345 ");
	}
}
