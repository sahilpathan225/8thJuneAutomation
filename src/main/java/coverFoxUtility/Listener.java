package coverFoxUtility;

import java.io.IOException;

import javax.naming.spi.DirStateFactory.Result;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFocBase.Base;

public class Listener extends Base implements ITestListener 
{

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("TC"+result.getName()+"passed", true);
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		try {
			Reporter.log("Taking screenshot", true);
			Utility.takesScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
