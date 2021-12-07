package scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pom.LoginPage;

public class Login extends BaseTest
{	
	
	
	@Test(dataProvider = "data")
	public void LogintoApplication(String data) 
	{
		
		String users[] = data.split(",");
		LoginPage login = new LoginPage(driver);
		login.username.sendKeys(users[0]);
		login.password.sendKeys(users[1]);
		login.loginbutton.click();
		String heading = login.heading.getText();
		
		Assert.assertTrue(heading.contains("Hello Credit Hero!"), "login failed");
		Reporter.log("Login Successfully");
		
	}
	
	

}
