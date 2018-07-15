package resources;

import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FilenameUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	public static WebDriver driver;
	
	public  Properties config;
	
	
	public WebDriver intializeBrowser() throws IOException 
	{
		config=new Properties();
		FileInputStream fis=new FileInputStream("data1.properties");
		// Till now p doesnot have knowledge of file which is in fis so use load
		config.load(fis);
		
		String browsername=config.getProperty("browser");
		if(browsername.equals("chrome" ))
		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browsername.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver","IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("Please enter browser's name in properties file");
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;		
	}
	
	
	//Method to get Screenshots of passed as well as failed tests
	public void getScreenShot(String result) throws IOException
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//FileUtils.
	FileUtils.copyFile(src,new File(result+"screenshot.png"));
	}
	
	

}
