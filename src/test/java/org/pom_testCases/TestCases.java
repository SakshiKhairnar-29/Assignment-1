package org.pom_testCases;

import org.baseUtility.LaunchBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pom_page.SearchPage_IDMB;
import org.pom_page.SearchPage_Wiki;
import org.property.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestCases {

	private String browserName;
	private String url_IMDB;
	private String url_Wiki;
	private WebDriver driver;


	@BeforeSuite
	public void configReadercalling()
	{
		ConfigReader cr = new ConfigReader();
		browserName = cr.configReader("browserName");
		url_IMDB=cr.configReader("imdb_url");	
		url_Wiki = cr.configReader("wiki_url");
	}


	@BeforeMethod
	public void launchBrowser()
	{
		LaunchBrowser obj = new LaunchBrowser();
		driver = obj.launchBrowser(url_IMDB, browserName);

	}


	@Test(priority=1)
	public void VerifyDetails()
	{
		//search on IDMB page
		SearchPage_IDMB obj_sp = new SearchPage_IDMB(driver);
		obj_sp.clicksearchBar();
		obj_sp.clickOnDropdown();

		WebElement ele_releaseDate = driver.findElement(By.xpath("//a[contains(text(),'Release date')]"));
		LaunchBrowser obj = new LaunchBrowser();
		obj.scrollbyJSUntilValue(driver, ele_releaseDate);		//scrolling	

		obj_sp.release_date_IMDB();
		obj_sp.country_Value_IMDB();


		//move to wiki page
		driver.navigate().to(url_Wiki);

		SearchPage_Wiki obj_Wiki = new SearchPage_Wiki(driver);
		obj_Wiki.searchBar();
		obj_Wiki.clickOnDropdown_Wiki();

		WebElement ele_releaseDate_Wiki = driver.findElement(By.xpath("//div[contains(text(),'Release date')]"));
		obj.scrollbyJSUntilValue(driver, ele_releaseDate_Wiki);		//scrolling	

		obj_Wiki.release_date_Wiki();
		obj_Wiki.country_Value_Wiki();


		//		Performing Assertion
		obj_Wiki.applyAssertionOnReleaseDate();
		obj_Wiki.applyAssertionOnCountry();


	}

	@AfterMethod
	public void closeBrowser1()
	{
		driver.close();
	}

	@AfterSuite
	public void tearDown()
	{
		driver.quit();
	}





	////li[@id='navTitleMenu']/div/div[2]/ul[1]/li[6]/a

}
