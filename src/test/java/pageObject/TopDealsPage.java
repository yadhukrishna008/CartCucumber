package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopDealsPage {
	WebDriver driver;
	public TopDealsPage(WebDriver driver) {
		this.driver=driver;
	}
	
//	Locators
	By searchItemLoc= By.cssSelector("input#search-field");
	By SearchResultTextLoc= By.xpath("//table[contains(@class,'table-bordered')]/tbody/tr/td[1]");
	
//	Action Methods
	public void searchItem(String itemName) {
		driver.findElement(searchItemLoc).sendKeys(itemName);	
	}
	
	public String SearchResultText() {
		return driver.findElement(SearchResultTextLoc).getText();		
	}
}
