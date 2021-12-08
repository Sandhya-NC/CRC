package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import generic.BasePageCrc;

public class ImportSmartCredit extends BasePageCrc
{
	
	public ImportSmartCredit(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	

	@FindBy(xpath = "(//li[@class='nav-item'])[2]")
	public WebElement importtab;
	
	@FindBy(xpath = "//a[contains(text(), 'Import/Audit')]")
	public WebElement importauditbutton;
	
	@FindBy(xpath = "(//span[@class='d-block l-h-14 font-600'])[1]")
	public WebElement  importcreditreporttab;
	
	@FindBy(xpath = "//a[@id= 'simple_audit_li']")
	public WebElement simpleaudittab;
	
	@FindBy(xpath = "//a[@id= 'btnsourcecode']")
	public WebElement importcreditreportnowbutton;
	
	@FindBy(xpath = "//h5[@class='modal-title d-flex mt-0 m-b-0']")
	public WebElement importcreditreportheading;
	
	@FindBy(xpath = "//a[@class='nav-link active oneclick oneclick_video']")
	public WebElement onclickautoimporttab;
	
	@FindBy(xpath = "//span[@id='select2-auto_selprovider-container']")
	public WebElement choosereportproviderdropdown;
	
	@FindBy(id = "auto_vcr_username")
	public WebElement username;
	
	@FindBy(id = "auto_vcr_password")
	public WebElement password;
	
	@FindBy(xpath = "(//a[@id='auto_btnsubmit_without_pending'])[2]")
	public WebElement idontneedanauditjustimportbutton;
	
	@FindBy(xpath = "(//a[@id='auto_btnsubmit_without_pending'])[1]")
	public WebElement idontneedanauditjustimportbuttonineditcredentials;
	
	@FindBy(xpath = "(//a[@id='auto_btnsubmit_with_pending'])[2]")
	public WebElement importandrunsimpleauditbutton;
	
	@FindBy(xpath = "(//a[@id='auto_btnsubmit_with_pending'])[1]")
	public WebElement importandrunsimpleauditbuttonineditcredentials;
	
	@FindBy(xpath = "(//h5[@class='modal-title'])[9]")
	public WebElement simpleauditpopup;
	
	@FindBy(xpath = "//p[@class='sans-p']")
	public WebElement editcredentials;
	
	@FindBy(xpath = "//input[@class='select2-search__field sl2srchbdrhide']")
	public WebElement searchreportproviders;
	
	@FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
	public WebElement smartcredit;
	
	@FindBy(xpath = "//div[@class='text-center']")
	public WebElement autoimportrunning;
	
	@FindBy(xpath = "(//h5[text() = 'Simple Audit (Credit Analysis)'])[2]")
	public WebElement simpleauditpopupheading;
	
	@FindBy(xpath = "(//button[@class='btn green-btn-lined2 waves-effect waves-light h-40 p-t-b-8 m-r-16'])[1]")
	public WebElement printbutton;
	
	@FindBy(xpath = "(//button[@class='btn green-btn-lined2 waves-effect waves-light h-40 p-t-b-8 m-r-16'])[2]")
	public WebElement pdfbutton;
	
	@FindBy(xpath = "//button[@class='btn green-btn padding-btn3 waves-effect waves-light h-40 p-t-b-8']")
	public WebElement nextbutton;
	
	@FindBy(xpath = "//input[@id='audit_name']")
	public WebElement auditname;
	
	@FindBy(xpath = "(//span[@class='error-text'])[1]")
	public WebElement auditupdatedsuccessfullytoastmessage;
	
	@FindBy(xpath = "(//div[@class=' tooltip-active float-right'])[3]")
	public WebElement emailaudittoclientbutton;
	
	@FindBy(xpath = "//button[@value='Tag And Save Pending Report']")
	public WebElement tagandsavependingreport;
	
	@FindBy(linkText = "Click to preview")
	public WebElement clickpreview;
	
	@FindBy(xpath = "//h2[@class='heading-h2 m-t-30 m-b-40 ']")
	public WebElement previewcreditreportheading;
	
	@FindBy(xpath = "//a[@class='btnsubmit green-btn-lined inline-block h-39 l-h-16']")
	public WebElement savethisreportaspendingandrunsimpleaudit;
	
	@FindBy(xpath = "//a[@class='btnsubmit green-btn inline-block h-39 l-h-16']")
	public WebElement savethisreportaspendingandfinishlater;
	
	@FindBy(xpath = "//span[@class='crc-ar-title sans-p font-16 font-600 p-b-16']")
	public WebElement pendingreportconfirmationpopupheading;
	
	@FindBy(xpath = "//a[@name='ok_confirm']")
	public WebElement pendingreportconfirmationpopupOkbutton;
	
	@FindBy(xpath = "//a[@class='green-btn inline-block h-39 l-h-16 m-r-24']")
	public WebElement savethisreportandcontinuetowizard;
	
	@FindBy(xpath = "//a[@class='green-btn-lined inline-block h-39 l-h-16']")
	public WebElement savemyworkandshowalldisputeitems;
	
	@FindBy(xpath = "//a[@id='delete_this_pending_report']")
	public WebElement deletethependingcreditreport;
	
	@FindBy(xpath = "//span[text()='Status']")
	public List<WebElement> status;
	
	@FindBy(xpath = "(//h5[@class='modal-title mt-0'])[3]")
	public WebElement deletependingreportwarningpopup;
	
	@FindBy(xpath = "(//div[@class='p-l-16 p-r-16'])[3]")
	public WebElement deletependingreportwarningmessage;
	
	@FindBy(xpath = "//a[@id='yes_delete_pp']")
	public WebElement deletependingreportOkbutton;
	
	@FindBy(xpath = "//a[@class='m-b-24 btn green-btn-lined form-btn waves-effect waves-light']")
	public WebElement deletependingreportCancelbutton;
	
	
	
	
	public void Clickonimport() 
	{
		Assert.assertTrue(importauditbutton.isDisplayed());
		Reporter.log("Import/Audit button is visible in clientdashboard");
		importauditbutton.click();
		Assert.assertTrue(importtab.isEnabled(), "Client not entered into importpage");
		Reporter.log("Clients entered into import page");
		Assert.assertTrue(importcreditreporttab.isEnabled());
		Reporter.log("Import credit report tab is selected");
		Assert.assertTrue(importcreditreportnowbutton.isDisplayed());
		importcreditreportnowbutton.click();
		Reporter.log("clicked on import credit report nowbutton");
		System.out.println(importcreditreportheading.getText());
		importcreditreportheading.isDisplayed();
		Reporter.log("popup is displaying");
	}
	
	
	public void oneclickimport(String clientdata) throws InterruptedException 
	{
		String userid[] = clientdata.split(",");
		onclickautoimporttab.isSelected();
		Reporter.log("oneclick auto import tab is opened");
		
		if(editcredentials.isDisplayed())
		{
			Reporter.log("credentials imported");
			editcredentialsimportandrunsimpleaudit();
			
		}
		else
		{
		choosereportprovider();
		
		String user = username.getText();
		System.out.println(user);
		if(user==null)
		{
			Reporter.log("username is empty");
			username.sendKeys(userid[11]);
			password.sendKeys(userid[12]);
		}
		else if(user!=null)
		{
			Reporter.log("username and password is autoentered");
		}
		importandrunsimpleaudit();
		

		}
		if(tagandsavependingreport.isDisplayed())
		{
		clickpreview.click();
		}
	}
	
	
	public void choosereportprovider() 
	{
		
		choosereportproviderdropdown.click();
		
//		First 
		searchreportproviders.sendKeys("SmartCredit");
		String smartcredittext = smartcredit.getText();
		smartcredit.click();
		System.out.println(smartcredittext +"is selected");
		
//		second
//		WebElement reportproviders = driver.findElement(By.xpath("//span[@class='select2-results']"));
//		Select selectreportproviders = new Select(reportproviders);
//		selectreportproviders.selectByVisibleText("Sample Report");
		
//		third
//		List<WebElement> reportproviderslist = driver.findElements(By.xpath("//span[@class='select2-results']"));
		
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
		Assert.assertTrue(idontneedanauditjustimportbuttonineditcredentials.isDisplayed());
		idontneedanauditjustimportbuttonineditcredentials.click();
		Assert.assertTrue(autoimportrunning.isDisplayed());
		Reporter.log("Running autoimport");
	}
	
	public void editcredentialsimportandrunsimpleaudit() 
	{
		Assert.assertTrue(importandrunsimpleauditbuttonineditcredentials.isDisplayed());
		importandrunsimpleauditbuttonineditcredentials.click();
		Assert.assertTrue(autoimportrunning.isDisplayed());
		Reporter.log("Running autoimport");
		Assert.assertTrue(simpleauditpopupheading.isDisplayed());
		Reporter.log("Credit analysis popup is displaying");
		nextbutton.click();	
		Reporter.log("Simple audit is done");
		Reporter.log(auditupdatedsuccessfullytoastmessage.getText());
	}
	
	public void importandrunsimpleaudit() throws InterruptedException 
	{
		importandrunsimpleauditbutton.click();
		Thread.sleep(2000);
		Assert.assertTrue(autoimportrunning.isDisplayed());
		Reporter.log("Running autoimport");
//		elementvisibility(simpleauditpopupheading);
//		Assert.assertTrue(importaudit.simpleauditpopupheading.isDisplayed());
		Reporter.log("Credit analysis popup is displaying");
		nextbutton.click();	
		Reporter.log("Simple audit is done");
		
	}
	
	public void emailtheaudit() throws InterruptedException 
	{
		Assert.assertTrue(importandrunsimpleauditbutton.isDisplayed());
		importandrunsimpleauditbutton.click();
		Assert.assertTrue(autoimportrunning.isDisplayed());
		Reporter.log("Running autoimport");
//		Assert.assertTrue(simpleauditpopupheading.isDisplayed());
//		Reporter.log("Credit analysis popup is displaying");
		Assert.assertTrue(emailaudittoclientbutton.isDisplayed());
		emailaudittoclientbutton.click();
		Reporter.log("Audit report sent to the client mail");
		Thread.sleep(3000);
		nextbutton.click();	
		Reporter.log("Simple audit is done");
	}
	
	public void downloadtheauditpdf() 
	{
		
		importandrunsimpleauditbutton.click();
		Assert.assertTrue(autoimportrunning.isDisplayed());
		Reporter.log("Running autoimport");
		Assert.assertTrue(simpleauditpopupheading.isDisplayed());
		Reporter.log("Credit analysis popup is displaying");
		Assert.assertTrue(pdfbutton.isDisplayed());
		pdfbutton.click();
		Reporter.log("Downloaded the Audit report pdf");
		nextbutton.click();	
		Reporter.log("Simple audit is done");
	}
	
	
	public void dontneedanauditjustimport() 
	{
		Assert.assertTrue(idontneedanauditjustimportbutton.isDisplayed());
		idontneedanauditjustimportbutton.click();
		Assert.assertTrue(autoimportrunning.isDisplayed());
		Reporter.log("Running autoimport");
	}
	
	
	
	public void previewcreditreport() 
	{
	
		elementvisibility(previewcreditreportheading);
		//Assert.assertTrue(importaudit.previewcreditreportheading.isDisplayed());
		Reporter.log("client entered into preview credit report page");
		System.out.println(status);
		for(int i=0;i<status.size();i++) 
		{
		   WebElement statusvalue = status.get(i);
		   String innerhtml = statusvalue.getAttribute("value");
		   if(innerhtml.contentEquals("Negative"))
		   {
			   
			   
			   
		   }
	
	

		}
		
		
		
		
	}
	
}
