package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver=driver;
	}
	
//	Locators
	By cartProductName= By.xpath("//table[@class='cartTable']//p[@class='product-name'][1]");
	By promoButton= By.xpath("//button[@class='promoBtn']");
	By placeOrder= By.xpath("//button[normalize-space()='Place Order']");
	
	
//	Action
	public String getCheckedOutProduct() {
		return driver.findElement(cartProductName).getText();
	}
	
	public boolean promoButtonView() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public boolean placeOrderButtonView() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
}
