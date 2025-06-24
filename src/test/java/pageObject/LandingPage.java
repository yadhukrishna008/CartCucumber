package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver= driver;
	}
	
//	Locators
	By searchItemLoc= By.xpath("//input[@class='search-keyword']");
	By searchResultLoc= By.cssSelector("h4.product-name");
	By topDealsLink= By.xpath("//a[normalize-space()='Top Deals']");
	By itemIncrement= By.xpath("//a[@class='increment']");
	By add2CartBut= By.xpath("//button[normalize-space()='ADD TO CART']");
	By cartIcon= By.xpath("//a[@class='cart-icon']");
	By checkoutProceedBut= By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']");
	
//	Action Methods
	public void searchItem(String itemName) {
		driver.findElement(searchItemLoc).sendKeys(itemName);	
	}
	
	public String getSearchResultEl() {
		return driver.findElement(searchResultLoc).getText();
	}
	
	public void clickTopDealsLink() {
		driver.findElement(topDealsLink).click();
	}
	
	public void clickItemIncrement() {
		driver.findElement(itemIncrement).click();
	}
	
	public void clickAdd2Cart() {
		driver.findElement(add2CartBut).click();
	}
	
	public void clickCartIcon() {
		driver.findElement(cartIcon).click();
	}
	
	public void proceed2Checkout() {
		driver.findElement(checkoutProceedBut).click();
	}
	
	public String getLandingPageTitle() {
		return driver.getTitle();
	}

}
