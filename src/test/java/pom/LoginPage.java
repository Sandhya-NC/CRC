package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePageCrc;

public class LoginPage extends BasePageCrc
{
	
	public LoginPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "signin")
	public WebElement loginbutton;
	
	@FindBy(id = "forgotpassword")
	public WebElement forgotpassword;
	
	@FindBy(xpath = "//h2[@class= 'm-auto heading-h2 m-t-0 m-b-40']")
	public WebElement heading;
	
	@FindBy(xpath = "//a[text()='Home']")
	public WebElement hometab;

	

	public void LogintoApplication(String data) 
	{
		String users[] = data.split(",");
		Assert.assertTrue(username.isDisplayed());
		username.sendKeys(users[0]);
		Assert.assertTrue(password.isDisplayed());
		password.sendKeys(users[1]);
		Assert.assertTrue(loginbutton.isDisplayed());
		loginbutton.click();
		String headingtext = heading.getText();
		
		Assert.assertTrue(headingtext.contains("Hello Credit Hero!"), "login failed");
		Reporter.log("Login Successfully");
		
	}
}
