package AutomationChallenge;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.PageObjectsTest;
import resources.Base;
//import MethodsUtilities;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class TestChallenge extends Base {
	public static Logger log= LogManager.getLogger(Base.class.getName());
	PageObjectsTest objectRepo;
	
	@BeforeTest
	
	public void pageLoad() throws IOException
	{
		driver=intializeBrowser();
		log.info("Driver is initialized");
		 driver.get(config.getProperty("testsite"));
		 log.info("Navigated to URL");
	}
	
	
	@Test(dataProvider="getData1")
	
	public void Test1(String username, String password1) throws IOException
	{
		objectRepo=new PageObjectsTest(driver);;
		objectRepo.getHomeLink().click();
		//Verify that Email, Password, Signin are displayed
		Assert.assertTrue(objectRepo.getEmail().isDisplayed());
		Assert.assertTrue(objectRepo.getPassword().isDisplayed());
		Assert.assertTrue(objectRepo.getSignIn().isDisplayed());
		log.info("Validated presence of email, password and Signin button");
		
		//Enter data in Email address and password
		objectRepo.getEmail().sendKeys(username);
		objectRepo.getPassword().sendKeys(password1);
		log.info("Entered values in email and Password");
	 
	}
	
	@DataProvider
	public Object[][] getData1()
	{
		Object[][] data=new Object[1][2];
		data[0][0]="pooja123@gmail.com";
		data[0][1]="123456";
		return data;
		
	}

	
	@Test
	public void Test2()
	{
		PageObjectsTest objectRepo=new PageObjectsTest(driver);
		
		objectRepo.getHomeLink().click();
		//Verify that no. of items in list is 3
		int countOfItems=objectRepo.getFullList().findElements(By.tagName("li")).size();
		Assert.assertEquals(countOfItems, 3);
		
		//Verify that text on list item2 is "List Item 2"
		JavascriptExecutor js=(JavascriptExecutor)driver;
        String value=js.executeScript("return $(\".list-group li:nth-of-type(2)\").clone().children().remove().end().text()").toString();
        Assert.assertEquals(value.trim(), "List Item 2", "List Item 2 Not Equal");
        log.info("Validated list item 2");
        
      //Verify that text on badgevalue is "6"
        String badge_value=objectRepo.getBadge().getText();
        Assert.assertEquals(badge_value.trim(), "6", "Badge Not Equal");
        log.info("Validated badge value of list item 2");
	}
	
	@Test
	public void Test3() 
	{
		PageObjectsTest objectRepo=new PageObjectsTest(driver);
		objectRepo.getHomeLink().click();
		
		//Verify that default selected value on dropdown is "Option1" 
		Assert.assertEquals("Option 1",objectRepo.getDropDownClick().getText());
		log.info("Validated default option on the dropdown");
		
		//Select "Option 3"
		objectRepo.getDropDownClick().click();
		List<WebElement> allOptions = objectRepo.getParentDropDown().findElements(By.tagName("a"));
		for(WebElement option : allOptions)
		{
			if(option.getText().equals("Option 3"))
			{
				option.click();
			}
		}
		log.info("Option 3 selected");
		
	}
	
	@Test
	public void Test4() 
	{
		PageObjectsTest objectRepo=new PageObjectsTest(driver);
		objectRepo.getHomeLink().click();
		
		//Verify that 1st button is enabled and 2nd button is disabled on Test4  section of page
		Assert.assertTrue( objectRepo.getEnabledButton().isEnabled());
		Assert.assertFalse( objectRepo.getDisabledButton().isEnabled());
		log.info("Validated that first button is enabled and second is disabled");
		
	}
	
	
	@Test
	public void Test5() 
	{
		PageObjectsTest objectRepo=new PageObjectsTest(driver);
		objectRepo.getHomeLink().click();
		
		//Wait for button to be displayed
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(objectRepo.getButton5Locator()));
		log.info("Validated the wait for cutton to be visible");
		
		//Click on button of Test5 and verify the alert message
		objectRepo.getButton5().click();
		Assert.assertEquals(objectRepo.getAlertMessage().getText(),"You clicked a button!");
		log.info("Clicked on button and validated the alert message");
		
		//Verify that after clicking button is disabled
		Assert.assertFalse(objectRepo.getButton5().isEnabled());
		log.info("Validated that button is disabled now");
		
		
	}
	
	@Test
	public void Test6() 
	{
		PageObjectsTest objectRepo=new PageObjectsTest(driver);
		objectRepo.getHomeLink().click();
		MethodsUtilities callMethod=new MethodsUtilities();
		
		//find and Verify value at coordinates(2,2) in the table
		Assert.assertEquals(callMethod.findCellValue(2,2),"Ventosanzap");
		log.info("Validated the value on the table at index (2,2)");
	}
	@AfterTest
	public void teardown()
	{
		
		driver.close();
		driver=null;
		log.info("Closing the browser");
		
	}

}
