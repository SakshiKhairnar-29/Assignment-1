package org.baseUtility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchBrowser {

	WebDriver driver;
	public WebDriver launchBrowser(String url, String browserName)
	{

		if(browserName.equalsIgnoreCase("ch"))
		{
			System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browserName.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver","./drivers/chromedriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver","./drivers/chromedriver.exe");
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("URL is Invalid!!!!!!!!!!");
		}

		driver.get(url);
		driver.manage().window().maximize();

		return driver;

	}
	
	public void scrollbyJSUntilValue(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
}
