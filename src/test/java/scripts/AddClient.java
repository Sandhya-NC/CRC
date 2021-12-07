package scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AddClientPage;
import pom.ImportAuditPage;

public class AddClient extends BaseTest
{
	
	
	@Test(dataProvider = "clientdata")
	public void newclient(String data) throws InterruptedException 
	{
		
	String clientdata[] = data.split(",");
	AddClientPage client = new AddClientPage(driver);
	client.username.sendKeys(clientdata[0]);
	client.password.sendKeys(clientdata[1]);
	client.loginbutton.click();
	String heading = client.heading.getText();
	
	Assert.assertTrue(heading.contains("Hello Credit Hero!"), "login failed");
	Reporter.log("Login Successfully");
	
	//Click on clients and add contacts
	
	client.clienttab.click();
	AssertJUnit.assertTrue(client.clienttab.isEnabled());
	Reporter.log("Client module opened successfully");
	client.addclient.click();
	
	//enter first name
	client.firstname.click();
	WebElement fname = client.firstname;
	fname.sendKeys(clientdata[2]);
	
	//enter last name
	client.lastname.click();
	WebElement lname = client.lastname;
	lname.sendKeys(clientdata[3]);
	
	//enter email
	client.emailid.click();
	WebElement email = client.emailid;
	email.sendKeys(clientdata[4]);
	
	//scroll horizontal
	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)","");

	
	client.portalaccess.click();
	client.portalaccessON.click();
	Reporter.log("portalaccess on");
	
	
	client.agreement.click();
	client.selectagreement.click();
	client.savebutton.click();
	Reporter.log("Clicked on save button");
	
	
	//Reporter.log(client.warningmessage.getText());
	client.warningOkButton.click();
	Assert.assertTrue(client.clientdashboard.isEnabled());
	String text = client.clientname.getText();
	AssertJUnit.assertTrue(text.contains(clientdata[2]));
	Reporter.log("Client created successfully");
	
	
	
	
	ImportAuditPage importaudit = new ImportAuditPage(driver);
	Assert.assertTrue(importaudit.importauditbutton.isDisplayed());
	Reporter.log("Import/Audit button is visible in clientdashboard");
	importaudit.importauditbutton.click();
	Assert.assertTrue(importaudit.importtab.isEnabled(), "Client not entered into importpage");
	Reporter.log("Clients entered into import page");
	AssertJUnit.assertTrue(importaudit.importcreditreporttab.isEnabled());
	Reporter.log("Import credit report tab is selected");
	importaudit.importcreditreportnowbutton.click();
	importaudit.importcreditreportheading.isDisplayed();
	Reporter.log("popup is displaying");
	importaudit.onclickautoimporttab.isSelected();
	Reporter.log("oneclick auto import tab is opened");
	
	if(importaudit.editcredentials.isDisplayed())
	{
		Reporter.log("credentials imported");
		importaudit.editcredentialsimportandrunsimpleaudit();
		
	}
	else
	{
	importaudit.choosereportprovider();
	
	String userid = importaudit.username.getText();
	System.out.println(userid);
	if(userid==null)
	{
		Reporter.log("username is empty");
		importaudit.username.sendKeys("");
		importaudit.password.sendKeys("");
	}
	else if(userid!=null)
	{
		Reporter.log("username and password is autoentered");
	}
	importaudit.importandrunsimpleaudit();

	}
	if(importaudit.tagandsavependingreport.isDisplayed())
	{
	importaudit.clickpreview.click();
	}
	importaudit.previewcreditreport();
	
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
	
}
