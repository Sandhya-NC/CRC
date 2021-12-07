package pom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
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
	//AddClientPage client = new AddClientPage(driver);
//	username.sendKeys(clientdata[0]);
//	password.sendKeys(clientdata[1]);
//	loginbutton.click();
//	String heading = heading.getText();
//	
//	Assert.assertTrue(heading.contains("Hello Credit Hero!"), "login failed");
//	Reporter.log("Login Successfully");
	
	//Click on clients and add contacts
	
	clienttab.click();
	Assert.assertTrue(clienttab.isEnabled());
	Reporter.log("Client module opened successfully");
	addclient.click();
	
	//enter first name
	firstname.click();
	WebElement fname = firstname;
	fname.sendKeys(clientdata[2]);
	
	//enter last name
	lastname.click();
	WebElement lname = lastname;
	lname.sendKeys(clientdata[3]);
	
	//enter email
	emailid.click();
	WebElement email = emailid;
	email.sendKeys(clientdata[4]);
	
	//scroll horizontal
	((JavascriptExecutor)driver).executeScript("window.scrollBy(0,600)","");

	
	portalaccess.click();
	portalaccessON.click();
	Reporter.log("portalaccess on");
	
	
	agreement.click();
	selectagreement.click();
	savebutton.click();
	Reporter.log("Clicked on save button");
	
	
	//Reporter.log(client.warningmessage.getText());
	warningOkButton.click();
	Assert.assertTrue(clientdashboard.isEnabled());
	String text = clientname.getText();
	Assert.assertTrue(text.contains(clientdata[2]));
	Reporter.log("Client created successfully");
	
	}
}
