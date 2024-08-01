package pageEvents;

import pageObject.HomePageElements;
import utils.FetchElement;

public class HomePageEvents{
	
	FetchElement getHomePageElement = new FetchElement();
	
	public void signInButton() {
		getHomePageElement.getElement("XPATH", HomePageElements.signInButtonText);
		
	}
	
}	
