package coverFoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static void takesScreenShot(WebDriver driver, String filename) throws IOException
	{
		
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String timestamp=new SimpleDateFormat("YYYYMMDD").format(new Date());
	//File des=new File("C:\\Users\\sahil\\eclipse-workspace\\Automation8June\\screenShot"+filename+timestamp+".png");
	File des=new File(System.getProperty("user.dir")+"\\screenShot"+filename+timestamp+".png");

	org.openqa.selenium.io.FileHandler.copy(source, des);
	
	}
	
	public static String readExceldata(String excelpath,String sheet, int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream myfile=new FileInputStream(excelpath);
		String value=WorkbookFactory.create(myfile).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}
	
	public static String  readDataFromPropertyFile(String key) throws IOException
	{
		Properties properties=new Properties();
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
		properties.load(myfile);
		String value=properties.getProperty(key);
		return value;
		
	}

}
