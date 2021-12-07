package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddClientPage extends LoginPage
{
	public AddClientPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//a[@class='main-a'])[2]")
	public WebElement clienttab;
	
	@FindBy(id = "mySmallModalLabel")
	public WebElement addclient;
	
	@FindBy(xpath = "//a[@class='nav-link active']")
	public WebElement clientdashboard;
	
	@FindBy(xpath = "//h5[@class='source-p bold font-32 m-b-16']")
	public WebElement clientname;
	
	@FindBy(id = "fname")
	public WebElement firstname;
	
	@FindBy(id = "lname")
	public WebElement lastname;
	
	@FindBy(id = "email")
	public WebElement emailid;
	
	@FindBy(xpath = "//span[@id='select2-portal-container']")
	public WebElement portalaccess;
	
	@FindBy(xpath = "//ul[@id='select2-portal-results']//li[1]")
	public WebElement portalaccessON;
	
	@FindBy(xpath = "//span[@id='select2-agreement-container']")
	public WebElement  agreement;
	
	@FindBy(xpath = "//ul[@id='select2-agreement-results']//li[3]")
	public WebElement selectagreement;
	
	@FindBy(id = "sub_button")
	public WebElement savebutton;
	
	@FindBy(xpath = "//h5[@id='deleteInvoiceNumberText']")
	public WebElement warning;
	
	@FindBy(xpath = "(//p[@class='sans-b font-16 font-600'])[3]")
	public WebElement warningmessage;
	
	@FindBy(xpath = "(//*[contains(text(),'Ok')])[1]")
	public WebElement warningOkButton;
	
	
	
	
	
	
	
	
	public void newclient(String data) throws InterruptedException 
	{
		
	String clientdata[] = data.split(",");
	
	//Click on clients and add contacts
	
	clienttab.click();
	Assert.assertTrue(clienttab.isEnabled());
	Reporter.log("Client module opened successfully");
	Assert.assertTrue(addclient.isDisplayed());
	addclient.click();
	
	//enter first name
	Assert.assertTrue(firstname.isDisplayed());
	firstname.sendKeys(clientdata[2]);
	
	//enter last name
	Assert.assertTrue(lastname.isDisplayed());
	lastname.sendKeys(clientdata[3]);
	
	//enter email
	Assert.assertTrue(emailid.isDisplayed());
	emailid.sendKeys(clientdata[4]);
	
	//scroll horizontal
	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)","");

	Assert.assertTrue(portalaccess.isDisplayed());
	portalaccess.click();
	Assert.assertTrue(portalaccessON.isDisplayed());
	portalaccessON.click();
	Reporter.log("portalaccess on");
	
	Assert.assertTrue(agreement.isDisplayed());
	agreement.click();
	Assert.assertTrue(selectagreement.isDisplayed());
	selectagreement.click();
	Assert.assertTrue(savebutton.isDisplayed());
	savebutton.click();
	Reporter.log("Clicked on save button");
	
	
	System.out.println(warningmessage.getText());
	warningOkButton.click();
	Assert.assertTrue(clientdashboard.isEnabled());
	String text = clientname.getText();
	Assert.assertTrue(text.contains(clientdata[2]));
	Reporter.log("Client created successfully");
	
	}
}
