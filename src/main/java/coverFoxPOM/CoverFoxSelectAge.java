package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFoxSelectAge {
	//variable declaration
	@FindBy(id = "Age-You")private WebElement selectAge;
	@FindBy(className = "next-btn") private WebElement clickNextButton;
	
	//constructor-variable initialization
	public CoverFoxSelectAge(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//method
	public void handleAgeDropdowm(String age)
	{
		Reporter.log("handling age dropdown..", true);
		Select s=new Select(selectAge);
		s.selectByValue(age+"y");
	}
	
	public void handleNextButton()
	{
		Reporter.log("clicking on next button...", true);
		clickNextButton.click();
	}
}
