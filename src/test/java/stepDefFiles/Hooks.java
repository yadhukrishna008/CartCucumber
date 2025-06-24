package stepDefFiles;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetUp;

public class Hooks {
	public TestContextSetUp testContextSetUp;
	WebDriver driver;
	
	public Hooks(TestContextSetUp testContextSetUp) throws IOException {
		this.testContextSetUp=testContextSetUp;
		this.driver= testContextSetUp.testBase.webDriverManager();
	}
	
	@After
	public void tearDown() throws IOException {
//		System.out.println("Close browser");
		driver.quit();
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent= FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
