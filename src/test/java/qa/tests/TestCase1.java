package qa.tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.LoginPageEvents;
import utils.FetchElement;

public class TestCase1 extends BaseTest{
	
	FetchElement ele = new FetchElement();
	HomePageEvents homepage = new HomePageEvents();
	LoginPageEvents loginpage = new LoginPageEvents();
	
	
	
  @Test
  public void sampleMethodForEnteringCredentials() {
	  
	  homepage.signInButton();
	  loginpage.verifyLoginPageIsLoaded();
	  loginpage.enterCredentials();
	  
  }
}
