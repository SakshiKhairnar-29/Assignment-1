package org.pom_page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage_IDMB {

	public String IMDB_RelaseDateValue;
	public String IMDB_releaseContryValue; 
	
	
	private WebDriver driver;
	//1.Find the webElements

	@FindBy(css="#suggestion-search")
	private WebElement searchBar;

	@FindBy(xpath="//div[contains(text(),'Pushpa: The Rise - Part 1')]")
	private WebElement movieName1;
	


	//2.Create constructor
	public SearchPage_IDMB(WebDriver driver)
	{
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

//3. create POM methods


	public void clicksearchBar()
	{
		searchBar.click();
		searchBar.sendKeys("Pushpa: The Rise");
	}

	public void clickOnDropdown()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		movieName1.click();
	}

	public void release_date_IMDB()
	{
		WebElement valueOfReleaseDate = driver.findElement(By.xpath("//li[@data-testid='title-details-releasedate']/div/ul/li/a"));
		
		IMDB_RelaseDateValue = valueOfReleaseDate.getText();		//To use further for assertion
		System.out.println("IMDB Release date is:==  "+valueOfReleaseDate.getText());

	}
	
	public void country_Value_IMDB()
	{
		WebElement valueOfCountry = driver.findElement(By.xpath("//li[@data-testid='title-details-origin']/div/ul/li/a"));
		
		IMDB_releaseContryValue = valueOfCountry.getText();		//To use further for assertion
		System.out.println("IMDB Country is:== "+valueOfCountry.getText());
	}




}
