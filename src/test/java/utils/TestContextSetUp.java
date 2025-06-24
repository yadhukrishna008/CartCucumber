package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import pageObject.PageObjectManager;
public class TestContextSetUp {

	public WebDriver driver;
	public String dealResult;
	public String searchResult;
	public TestBase testBase;
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;
	public String cartProductName;
	
	public TestContextSetUp() throws IOException{
		this.testBase= new TestBase();
		
		pageObjectManager= new PageObjectManager(testBase.webDriverManager());
		genericUtils= new GenericUtils(testBase.webDriverManager());
	}
}
