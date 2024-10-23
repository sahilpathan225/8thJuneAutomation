package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxHealthPlan {

	//variable declaration
	@FindBy(className = "next-btn")private WebElement nextbutton;
	
	//constructor
	public CoverfoxHealthPlan(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//method
	public void clickOnNextButton()
	{
		Reporter.log("clicking on next button..", true);
		nextbutton.click();
	}
}
