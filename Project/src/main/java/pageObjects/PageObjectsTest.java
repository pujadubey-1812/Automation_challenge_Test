package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjectsTest {
	public WebDriver driver;
	By homeLink=By.xpath("//*[@id='navbarColor01']/ul/li[1]/a");
	By email_add=By.xpath("//input[@id='inputEmail']");
	By password= By.cssSelector("input#inputPassword");
	By signIn=By.xpath("//*[@id='test-1-div']/form/button");
	
	
	By fullList=By.cssSelector("ul.list-group");
	
			
	By badge= By.xpath("//ul[@class='list-group']/li[2]/span");
	
	By dropButton= By.xpath("//button[@id='dropdownMenuButton']");
	By parentDropdown=By.xpath("//*[@id='test-3-div']/div/div");
	By enabledButton4=By.cssSelector("button.btn.btn-lg.btn-primary");
	By disabledButton4=By.cssSelector("button.btn.btn-lg.btn-secondary");
	By button5Locator=By.id("test5-button");
	By button5=By.id("test5-button");
	By alertMessage=By.id("test5-alert");
	
	By fullTable=By.xpath("//*[@id='test-6-div']/div/table");

	public PageObjectsTest(WebDriver driver) 
	{
	this.driver=driver;	
	}
	public WebElement getHomeLink()
	{
		return (driver.findElement(homeLink));
	}
	
	public WebElement getEmail()
	{
		return (driver.findElement(email_add));
	}
	
	public WebElement getPassword()
	{
		return (driver.findElement(password));
	}
	
	public WebElement getSignIn()
	{
		return (driver.findElement(signIn));
	}
	
	public WebElement getFullList()
	{
		return (driver.findElement(fullList));
	}
	public WebElement getBadge()
	{
		return (driver.findElement(badge));
	}
	
	
	public WebElement getDropDownClick()
	{
		return (driver.findElement(dropButton));
	}
	public WebElement getParentDropDown()
	{
		return (driver.findElement(parentDropdown));
	}
	
	public WebElement getEnabledButton()
	{
		return (driver.findElement(enabledButton4));
	}
	
	
	public WebElement getDisabledButton()
	{
		return (driver.findElement(disabledButton4));
	}
	
	
	public  By getButton5Locator()
	{
		
		return  (button5Locator);
	}
	
	public  WebElement getButton5()
	{
		
		return  (driver.findElement(button5));
	}

	public  WebElement getAlertMessage()
	{
		
		return  (driver.findElement(alertMessage));
	}
	public  WebElement getFullTable()
	{
		
		return  (driver.findElement(fullTable));
	}
	
	
}
