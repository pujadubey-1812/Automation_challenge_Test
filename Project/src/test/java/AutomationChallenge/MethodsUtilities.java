package AutomationChallenge;
import pageObjects.PageObjectsTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import resources.Base;

public class MethodsUtilities extends Base {
	public String findCellValue(int inputRow, int inputColumn)
	{
		PageObjectsTest home1=new PageObjectsTest(driver);
		String cellText = home1.getFullTable().findElements(By.tagName("tr")).get(inputRow+1).findElements(By.tagName("td")).get(inputColumn).getText();
		return cellText;		
			
		}

}
