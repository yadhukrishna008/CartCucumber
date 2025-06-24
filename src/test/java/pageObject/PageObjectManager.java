package pageObject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public TopDealsPage TDP;
	public LandingPage LP;
	public CheckOutPage Checkp;
	WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver= driver;
	}
	
	public TopDealsPage topDealPageObj() {
		TDP= new TopDealsPage(driver);
		return TDP;
	}
	
	public LandingPage LandingPageObj() {
		LP= new LandingPage(driver);
		return LP;
	}
	
	public CheckOutPage checkOutPageObj() {
		Checkp= new CheckOutPage(driver);
		return Checkp;
	}
	
}
