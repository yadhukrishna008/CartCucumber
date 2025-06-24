package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	String parentWID, childWID;
	WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver= driver;
	}
	
	public void switchToChildSite() {
		Set<String> myCarts= driver.getWindowHandles();
		Iterator<String> i1= myCarts.iterator();
	    parentWID=i1.next();
	    childWID=i1.next();

	    driver.switchTo().window(childWID);
	}
}
