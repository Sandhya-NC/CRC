package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import pom.DeleteFlowPage;
import pom.LoginPage;

public class DeleteFlow extends BaseTest
{
	
	@Test(dataProvider = "data")
	public void deleteclient(String data) throws InterruptedException 
	{
		
//		LoginPage login = new LoginPage(driver);
//		login.LogintoApplication(data);
		
		String users[] = data.split(",");
		LoginPage login = new LoginPage(driver);
		login.username.sendKeys(users[0]);
		login.password.sendKeys(users[1]);
		login.loginbutton.click();
		String heading = login.heading.getText();
		
		Assert.assertTrue(heading.contains("Hello Credit Hero!"), "login failed");
		Reporter.log("Login Successfully");
		DeleteFlowPage delete = new DeleteFlowPage(driver);
		delete.clienttab.click();
		delete.clientsearchbar.sendKeys("hammid@yopmail.com");
		delete.clientsearchbutton.click();
		Thread.sleep(2000);
		Assert.assertTrue(delete.clientname.isDisplayed(), "No result found");
		String ClientName = delete.clientname.getAttribute("title");
		System.out.println(ClientName);
		Thread.sleep(2000);
		String status = delete.allstatus.getText();
		System.out.println(status);
		Thread.sleep(2000);
		elementvisibility(delete.menudropdown);
		Actions action =new Actions(driver);
		action.moveToElement(delete.menudropdown).click().build().perform();
		//delete.menudropdown.click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)", "");
		Assert.assertTrue(delete.deleteoption.isDisplayed());
		Reporter.log("delete option is displaying");
		Actions action1 =new Actions(driver);
		action1.moveToElement(delete.deleteoption).click().build().perform();
		//delete.deleteoption.click();
		elementvisibility(delete.clientdeletepopupheading);
		Reporter.log("delete popup is displaying");
		delete.clientdeletebutton.click();
		elementvisibility(delete.clientdeletesuccessfullytoastmessage);
		Reporter.log("Toast message is displaying");
		String toastmessage = delete.clientdeletesuccessfullytoastmessage.getText();
		System.out.println(toastmessage);
		
	}
		
}
