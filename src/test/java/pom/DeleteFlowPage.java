package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class DeleteFlowPage extends LoginPage
{

	public DeleteFlowPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='main-a'])[2]")
	public WebElement clienttab;
	
	@FindBy(xpath = "//input[@id='sname']")
	public WebElement clientsearchbar;
	
	@FindBy(xpath = "//input[@class='green-btn-lined3 w-90-p h-40 p-t-8 inline-block']")
	public WebElement clientsearchbutton;
	
	@FindBy(xpath = "//td[@class='name-td w-135']")
	public WebElement clientname;
	
	@FindBy(xpath = "//span[@id='dropdownMenuButton1']")
	public WebElement menudropdown;
	
	@FindBy(xpath = "//a[text()='Delete']")
	public WebElement deleteoption;
	
	@FindBy(xpath = "//a[@class='text_color']")
	public WebElement allstatus;
	
	@FindBy(xpath = "(//h5[text()='Deactivate/Delete Client'])[1]")
	public WebElement clientdeletepopupheading;
	
	@FindBy(xpath = "//a[@name='delete_client']")
	public WebElement clientdeletebutton;
	
	@FindBy(xpath = "//a[@name='inactive_client']")
	public WebElement clientinactivebutton;
	
	@FindBy(xpath = "//div[@id='flash-message']")
	public WebElement clientdeletesuccessfullytoastmessage;
	
	
	
	public void deleteflow(String clientdata) throws InterruptedException 
	{
		//DeleteFlowPage delete = new DeleteFlowPage(driver);
		String email[] = clientdata.split(",");
		clienttab.click();
		clientsearchbar.sendKeys(email[15]);
		clientsearchbutton.click();
		Thread.sleep(2000);
		Assert.assertTrue(clientname.isDisplayed(), "No result found");
		String ClientName = clientname.getAttribute("title");
		System.out.println(ClientName);
		Thread.sleep(2000);
		String status = allstatus.getText();
		System.out.println(status);
		Thread.sleep(2000);
		elementvisibility(menudropdown);
		Actions action =new Actions(driver);
		action.moveToElement(menudropdown).click().build().perform();
		//delete.menudropdown.click();
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)", "");
		Assert.assertTrue(deleteoption.isDisplayed());
		Reporter.log("delete option is displaying");
		Actions action1 =new Actions(driver);
		action1.moveToElement(deleteoption).click().build().perform();
		//delete.deleteoption.click();
		elementvisibility(clientdeletepopupheading);
		Reporter.log("delete popup is displaying");
		clientdeletebutton.click();
		elementvisibility(clientdeletesuccessfullytoastmessage);
		Reporter.log("Toast message is displaying");
		String toastmessage = clientdeletesuccessfullytoastmessage.getText();
		//System.out.println(toastmessage);
		Reporter.log(toastmessage);
	}
	
}
