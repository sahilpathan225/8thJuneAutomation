package coverFoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFoxResultsPage {
	//variable declaration
	@FindBy(xpath = "//div[contains(text(),'Health Insurance Plans')]") private WebElement matchingResults;
	@FindBy(xpath = "//div[@class='plan-card-container']") private List<WebElement> listResults;
	
	//Constructor
	public CoverFoxResultsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public int getCountFromText()
	{
		Reporter.log("getting policy count from text displayed...", true);
		String matchingNumber=matchingResults.getText().substring(0, 2);
		int counFromtext=Integer.parseInt(matchingNumber);
		return counFromtext;
	}

	public int getCountFromBanner()
	{
		Reporter.log("getting policy count from banners displayed..", true);
		int countFromBanner=listResults.size();
		return countFromBanner;
	}
	
	//method
//	public void handleMatchingResults()
//	{
//		String matchingNumber=matchingResults.getText().substring(0, 2);
//		//use Integer.parseInt()
//		int actualNumber=Integer.parseInt(matchingNumber);
//		int planlistNumber=listResults.size();
//		
//		if(actualNumber==planlistNumber)
//		{
//			System.out.println("Test case Pass results are matching");
//		}
//		else
//		{
//			System.out.println("Test case Fail results are not matching");
//		}
//	}
	
}

