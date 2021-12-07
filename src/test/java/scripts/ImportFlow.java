package scripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;
import pom.ImportAuditPage;

public class ImportFlow extends BaseTest
{
	ImportAuditPage importaudit = new ImportAuditPage(driver);
	@Test
	public void importflow() throws InterruptedException 
	{
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
	
	
	
	
	
	
	
	
	
	public void choosereportprovider() 
	{
		ImportAuditPage importaudit = new ImportAuditPage(driver);
		importaudit.choosereportproviderdropdown.click();
		
//		First 
		importaudit.searchreportproviders.sendKeys("Sample Report");
		String samplereporttext = importaudit.samplereport.getText();
		importaudit.samplereport.click();
		System.out.println(samplereporttext +"is selected");
		
//		second
//		WebElement reportproviders = driver.findElement(By.xpath("//span[@class='select2-results']"));
//		Select selectreportproviders = new Select(reportproviders);
//		selectreportproviders.selectByVisibleText("Sample Report");
		
//		third
//		List<WebElement> reportproviderslist = driver.findElements(By.xpath("//span[@class='select2-results']"));
	//	
//		for(WebElement element:reportproviderslist)
//		{
//			String innerhtml = element.getText();
//			if(innerhtml.contentEquals("Sample Report"))
//			{
//				element.click();
//				Reporter.log(element+"Report provider selected");
//				break;
//			}
//			System.out.println("reportproviderslist==="+innerhtml);
//		}
	}
	
	
	public void editcredentialsonlyimport() 
	{
		importaudit.idontneedanauditjustimportbuttonineditcredentials.click();
	}
	
	
	public void editcredentialsimportandrunsimpleaudit() 
	{
		importaudit.importandrunsimpleauditbuttonineditcredentials.click();
		AssertJUnit.assertTrue(importaudit.simpleauditpopupheading.isDisplayed());
		Reporter.log("Credit analysis popup is displaying");
		importaudit.nextbutton.click();	
		Reporter.log("Simple audit is done");
	}
	
	
	public void importandrunsimpleaudit() 
	{
		
		importaudit.importandrunsimpleauditbutton.click();
		AssertJUnit.assertTrue(importaudit.simpleauditpopupheading.isDisplayed());
		Reporter.log("Credit analysis popup is displaying");
		importaudit.nextbutton.click();	
		Reporter.log("Simple audit is done");
		
	}
	
	public void emailtheaudit() 
	{
		ImportAuditPage importaudit = new ImportAuditPage(driver);
		AssertJUnit.assertTrue(importaudit.simpleauditpopupheading.isDisplayed());
		Reporter.log("Credit analysis popup is displaying");
		importaudit.emailaudittoclientbutton.click();
		Reporter.log("Audit report sent to the client mail");
		importaudit.nextbutton.click();	
		Reporter.log("Simple audit is done");
	}
	
	
	public void downloadtheauditpdf() 
	{
		ImportAuditPage importaudit = new ImportAuditPage(driver);
		AssertJUnit.assertTrue(importaudit.simpleauditpopupheading.isDisplayed());
		Reporter.log("Credit analysis popup is displaying");
		importaudit.pdfbutton.click();
		Reporter.log("Downloaded the Audit report pdf");
		importaudit.nextbutton.click();	
		Reporter.log("Simple audit is done");
	}
	
	
	public void dontneedanauditjustimport() 
	{
		importaudit.idontneedanauditjustimportbutton.click();
	}
	
	
	
	
	
	}

