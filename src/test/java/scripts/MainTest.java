package scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AddClientPage;
import pom.DeleteFlowPage;
import pom.ImportMyFreeScoreNow;
import pom.ImportMyIdentityIQ;
import pom.ImportPrivacyGuard;
import pom.ImportSampleReport;
import pom.ImportSmartCredit;
import pom.LoginPage;

public class MainTest extends BaseTest
{
		@Test(dataProvider = "clientdata",priority = 0)
		public void SampleReport(String data) throws InterruptedException 
		{
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportSampleReport importaudit = new ImportSampleReport(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
			
			
		}
		
		@Test(dataProvider = "clientdata",priority = 4)
		public void PrivacyGuard(String data) throws InterruptedException 
		{
			
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportPrivacyGuard importaudit = new ImportPrivacyGuard(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
			
		}
		
		@Test(dataProvider = "clientdata",priority = 1)
		public void MyIdentityIq(String data) throws InterruptedException 
		{
				
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportMyIdentityIQ importaudit = new ImportMyIdentityIQ(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
		
			
		}
		
		@Test(dataProvider = "clientdata",priority = 2)
		public void MyFreeScoreNow(String data) throws InterruptedException 
		{
	
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportMyFreeScoreNow importaudit2 = new ImportMyFreeScoreNow(driver);
			importaudit2.Clickonimport();
			importaudit2.oneclickimport(data);

			
		}
		
		@Test(dataProvider = "clientdata",priority = 3)
		public void SmartCredit(String data) throws InterruptedException 
		{
			
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportSmartCredit importaudit3 = new ImportSmartCredit(driver);
			importaudit3.Clickonimport();
			importaudit3.oneclickimport(data);
			
			
		}
		
		
		@AfterMethod()
		@Parameters("email")
		public void delete(String data) throws InterruptedException 
		{
			DeleteFlowPage delete = new DeleteFlowPage(driver);
			delete.deleteflow(data);
			driver.close();
		}
		
		
		
		

}
