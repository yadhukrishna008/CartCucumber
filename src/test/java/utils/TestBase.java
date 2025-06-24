package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	public WebDriver driver;

	public WebDriver webDriverManager () throws IOException {
		String myBrowser, browser_properties, browser_maven;
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
		Properties prop= new Properties();
		prop.load(fis);
		
		browser_properties= prop.getProperty("browser");
		browser_maven= System.getProperty("browser");
		
		if (driver==null) {
			
			myBrowser= (browser_maven == null) ? browser_properties : browser_maven;
			System.out.println(myBrowser);
			
			switch (myBrowser.toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
				driver= new ChromeDriver();
				break;
			case "edge":
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\edgedriver_win64\\msedgedriver.exe");
				driver= new EdgeDriver();
				break;
			case "firefox": 
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\geckodriver-v0.36.0-win64\\geckodriver.exe");
				driver= new FirefoxDriver();
				break;
			default: System.out.println("Invalid browser");
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			
			
			
			driver.get(prop.getProperty("QAUrl"));
		}
		return driver;
	}
}
