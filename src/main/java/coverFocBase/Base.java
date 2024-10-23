package coverFocBase;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

import coverFoxUtility.Utility;

public class Base {
	//driver
	//url
	//launch browser
	//close browser

	 protected static WebDriver driver;
	 
	 public void launchBrowser() throws IOException
	 {
		 ChromeOptions option=new ChromeOptions();
		 option.addArguments("--disable-notifications");
		 
		 driver=new ChromeDriver(option);
		 driver.manage().window().maximize();
		 driver.get(Utility.readDataFromPropertyFile("url"));
		 Reporter.log("Launching browser..",true);
		 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		 Reporter.log("Waiting...",true);
	 }
	
	 public void closeBrowser()
	 {
		 Reporter.log("Closing Browser..",true);
		 driver.quit();
	 }
}
