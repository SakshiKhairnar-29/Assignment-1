package org.pom_page;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchPage_Wiki {

public String Wiki_RelaseDateValue ;
public String Wiki_releaseContryValue;

	private WebDriver driver;
	//1.Find the webElements

	@FindBy(css="#searchInput")
	private WebElement searchBar_Wiki;

	@FindBy(xpath="//span[contains(text(),'Pushpa: The Rise')]")
	private WebElement movieName_Wiki;


	//2.Create constructor
	public SearchPage_Wiki(WebDriver driver)
	{
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}

	//3. create POM methods

	public void searchBar()
	{
		searchBar_Wiki.click();
		searchBar_Wiki.sendKeys("Pushpa: The Rise");
	}
	public void clickOnDropdown_Wiki()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		movieName_Wiki.click();
	}

	public void release_date_Wiki()
	{
		//Release Date-Wiki
		WebElement valueOfReleaseDate_Wiki = driver.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[12]/td"));

		Wiki_RelaseDateValue = valueOfReleaseDate_Wiki.getText();		//To use further for assertion
		System.out.println("Wiki Release date is:== "+valueOfReleaseDate_Wiki.getText());

	}

	public void country_Value_Wiki()
	{
		WebElement valueOfCountry_wiki = driver.findElement(By.xpath("//table[@class='infobox vevent']/tbody/tr[14]/td"));

		Wiki_releaseContryValue = valueOfCountry_wiki.getText();		//To use further for assertion
		System.out.println("Wiki Country is:== "+valueOfCountry_wiki.getText());
	}



	public void applyAssertionOnReleaseDate()
	{
		SearchPage_IDMB sp_obj = new SearchPage_IDMB(driver);
		Assert.assertEquals(sp_obj.IMDB_RelaseDateValue, Wiki_RelaseDateValue );
	}

	public void applyAssertionOnCountry()
	{
		SearchPage_IDMB sp_obj = new SearchPage_IDMB(driver);
		Assert.assertEquals(sp_obj.IMDB_releaseContryValue, Wiki_releaseContryValue);
	}


}
