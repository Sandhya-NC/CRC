package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePageCrc 
{

	public WebDriver driver;
	public BasePageCrc(WebDriver driver)
	{
		this.driver=driver;
	}
	public void titlewait(String expected_title)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		try
		{
			wait.until(ExpectedConditions.titleIs(expected_title));
			Reporter.log("pass: title is matching", true);
		}
		catch(Exception e)
		{
			Reporter.log("fail: title is not matching", true);
			Assert.fail();
		}}
		
	public void elementvisibility(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
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
