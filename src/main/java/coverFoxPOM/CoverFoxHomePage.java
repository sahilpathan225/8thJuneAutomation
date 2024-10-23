package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxHomePage {
	
	//variable declaration--> WebElement
	@FindBy(xpath = "//div[text()='Male']")private WebElement gender;
	
	//variable initialization - contractor
	public CoverFoxHomePage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//methods
	public void clickonGenderButton()
	{
		Reporter.log("clicking on gender button...", true);
		gender.click();
	}
}
