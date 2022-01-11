package generic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.IDynamicGraph.Status;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.model.Test;

import ExtentReports.ExtentReporterNG;

public class BaseTest extends ExtentReporterNG implements Autoconstantcrc 
{
	public static WebDriver driver;
	
	@DataProvider(name = "data")
    public String[] logindataprovider() throws IOException, ParseException  
    {
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("./src/Data/data.json");
		Object obj = jsonparser.parse(reader);
		JSONObject userloginjsonobj= (JSONObject)obj;
		JSONArray userloginjsonArray = (JSONArray)userloginjsonobj.get("userlogins");
		
		String arr[]= new String[userloginjsonArray.size()];
		for(int i=0; i<userloginjsonArray.size();i++)
		{
			JSONObject users = (JSONObject)userloginjsonArray.get(i);
			String username = (String) users.get("username");
			String pwd = (String) users.get("password");
			arr[i]= username+","+pwd;
		}
		return arr;
	}
	
	@DataProvider(name = "clientdata")
	public String[] clientdataprovider() throws IOException, ParseException 
	{
		JSONParser jsonparser = new JSONParser();
		FileReader reader = new FileReader("./src/Data/data.json");
		Object obj = jsonparser.parse(reader);
		JSONObject clientdetailsobj = (JSONObject)obj;
		JSONArray clientdetailsArray = (JSONArray)clientdetailsobj.get("addclients");
		
		String arr[] = new String[clientdetailsArray.size()];
		
		for(int i=0;i<clientdetailsArray.size();i++)
		{
			JSONObject client = (JSONObject)clientdetailsArray.get(i);
			String username = (String) client.get("username");
			String pwd = (String) client.get("password");
			String fname = (String) client.get("FirstName");
			String lname = (String) client.get("LastName");
			String email = (String) client.get("Email");
			String PrivacyGuardUsername = (String) client.get("PrivacyGuardUsername");
			String PrivacyGuardPassword = (String) client.get("PrivacyGuardPassword");
			String PrivacyGuardSSNNumber = (String) client.get("PrivacyGuardSSNNumber");
			String IdentityIQUsername = (String) client.get("IdentityIQUsername");
			String IdentityIQPassword = (String) client.get("IdentityIQPassword");
			String IdentityIQSSNNumber = (String) client.get("IdentityIQSSNNumber");
			String SmartCreditUsername = (String) client.get("SmartCreditUsername");
			String SmartCreditPassword = (String) client.get("SmartCreditPassword");
			String MyFreeScoreNowUsername = (String) client.get("MyFreeScoreNowUsername");
			String MyFreeScoreNowPassword = (String) client.get("MyFreeScoreNowPassword");
			String mail = (String) client.get("email");
			
			arr[i]= username+","+pwd+","+fname+","+lname+","+email+","+PrivacyGuardUsername+","+PrivacyGuardPassword+","+PrivacyGuardSSNNumber+","+IdentityIQUsername+","+IdentityIQPassword+","+IdentityIQSSNNumber+","+SmartCreditUsername+","+SmartCreditPassword+","+MyFreeScoreNowUsername+","+MyFreeScoreNowPassword+","+mail;
		}
		return arr;
		
	}
	

	@BeforeMethod()
	@Parameters({"browser","url","WindowSize", "notifications"})
	public void precondition(String browserName, String url, String WindowSize, String notifications) throws InterruptedException
	{
		System.out.println("Browser Name is: "+browserName);
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(chromekey, chromevalue);
			ChromeOptions options= new ChromeOptions();
			//options.setHeadless(true);
			options.addArguments(WindowSize);
			options.addArguments(notifications);
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);
			Dimension size = driver.manage().window().getSize();
			System.out.println(size);
		}
		else if(browserName.equalsIgnoreCase("firefox1"))
		{
			System.setProperty(geckokey, geckovalue);
			FirefoxOptions options= new FirefoxOptions();
		    //options.setHeadless(true);
			driver = new FirefoxDriver(options);
			Dimension d=new Dimension(1900, 1080);
			driver.manage().window().setSize(d);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			Dimension size = driver.manage().window().getSize();
			System.out.println(size);
		}
		
	}
	
	
	
	
	public void elementvisibility(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		try {
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("pass: element is visible ", true);
		}
		catch(Exception e)
		{
			Reporter.log("fail: element is not visible", true);
			Assert.fail();
		}
	}
	
	
}
