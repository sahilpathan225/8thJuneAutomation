package coverFoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxAdressDetails {
	//variable declaration
	@FindBy(className = "mp-input-text")private WebElement pincode;
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNum;
	@FindBy(className = "next-btn")private WebElement nextButton;
	
	//constructor
	public CoverFoxAdressDetails(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//method
	public void handlePincode(String pinode)
	{
		Reporter.log("entering pincode..", true);
		pincode.sendKeys(pinode);
	}
	
	public void handleMobileNum(String MobileNum)
	{
		Reporter.log("entering mobile number..", true);
		mobileNum.sendKeys(MobileNum);
	}
	public void nextButton()
	{
		Reporter.log("clicking on continue button..", true);
		nextButton.click();
	}
}
