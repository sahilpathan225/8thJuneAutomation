package coverFoxTestClass;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import coverFocBase.Base;
import coverFoxPOM.CoverFoxAdressDetails;
import coverFoxPOM.CoverFoxHomePage;
import coverFoxPOM.CoverFoxResultsPage;
import coverFoxPOM.CoverFoxSelectAge;
import coverFoxPOM.CoverfoxHealthPlan;
import coverFoxUtility.Utility;

public class TC1234_CoverFox_ValidateBannerCount extends Base {
	
	CoverFoxHomePage homepage;
	CoverfoxHealthPlan healthPlanPage;
	CoverFoxSelectAge memberDetailsPage;
	CoverFoxAdressDetails addressDetailsPage;
	CoverFoxResultsPage resultPage;
	String excelpath=System.getProperty("user.dir")+"\\dataSheet\\Book1.xlsx";
	String sheet="Sheet2";
	public static org.apache.log4j.Logger logger;
	
	//open browser/ open an application
	@BeforeClass
	public void OpenApplication() throws IOException
	{
	  launchBrowser();
	  logger=org.apache.log4j.Logger.getLogger("8th_june_CoverFox");
	  PropertyConfigurator.configure("log4j.properties");
	  logger.info("Open application");
	
	}
	
	//gender, next click, age selection, pincode, mobile, next click
	@BeforeMethod
	public void enterDetails() throws EncryptedDocumentException, IOException, InterruptedException
	{
		homepage=new CoverFoxHomePage(driver);
		healthPlanPage=new CoverfoxHealthPlan(driver);
		memberDetailsPage= new CoverFoxSelectAge(driver);
		addressDetailsPage=new CoverFoxAdressDetails(driver);
		resultPage=new CoverFoxResultsPage(driver);
		
		homepage.clickonGenderButton();
		logger.info("Click on Gender button");
		Thread.sleep(2000);
		healthPlanPage.clickOnNextButton();
		logger.info("Click on Next button");
		Thread.sleep(2000);
		memberDetailsPage.handleAgeDropdowm(Utility.readExceldata(excelpath, sheet, 0, 0));
		logger.info("Select Age Value");
		memberDetailsPage.handleNextButton();
		logger.info("Click on Next button");
		Thread.sleep(2000);
		addressDetailsPage.handlePincode(Utility.readExceldata(excelpath, sheet, 0, 1));
		logger.warn("Enter Pincode");
		addressDetailsPage.handleMobileNum(Utility.readExceldata(excelpath, sheet, 0, 2));
		logger.warn("Enter MobileNumber");
		addressDetailsPage.nextButton();
		logger.info("Click on Next button");
		Thread.sleep(3000);
		
		
	}
	
	
  @Test
  public void validatePolicyCount() 
  {
	  int textcount=resultPage.getCountFromText();
	  int bannerCount=resultPage.getCountFromBanner();
	  //Assert.fail();
	  Assert.assertEquals(textcount, bannerCount,"text count not matching with banner count");
  }
  
  //close browser /close application
  @AfterClass
  public void closeApplication()
  {
	  logger.info("Close application");
	  closeBrowser();
	  
  }
}
