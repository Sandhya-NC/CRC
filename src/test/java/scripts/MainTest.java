package scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
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
		//@Test(dataProvider = "clientdata",priority = 0)
		public void SampleReport(String data) throws InterruptedException 
		{
			logger = extent.startTest("SampleReport");
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportSampleReport importaudit = new ImportSampleReport(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
			DeleteFlowPage delete = new DeleteFlowPage(driver);
			delete.deleteflow();
			driver.close();
			
		}
		
		//@Test(dataProvider = "clientdata",priority = 4)
		public void PrivacyGuard(String data) throws InterruptedException 
		{
			logger = extent.startTest("PrivacyGuard");
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportPrivacyGuard importaudit = new ImportPrivacyGuard(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
			DeleteFlowPage delete = new DeleteFlowPage(driver);
			delete.deleteflow();
			driver.close();
		}
		
		//@Test(dataProvider = "clientdata",priority = 1)
		public void MyIdentityIq(String data) throws InterruptedException 
		{
			logger = extent.startTest("MyIdentityIq");	
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportMyIdentityIQ importaudit = new ImportMyIdentityIQ(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
			DeleteFlowPage delete = new DeleteFlowPage(driver);
			delete.deleteflow();
			driver.close();
			
		}
		
		//@Test(dataProvider = "clientdata",priority = 2)
		public void MyFreeScoreNow(String data) throws InterruptedException 
		{
			logger = extent.startTest("MyFreeScoreNow");
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportMyFreeScoreNow importaudit2 = new ImportMyFreeScoreNow(driver);
			importaudit2.Clickonimport();
			importaudit2.oneclickimport(data);
			DeleteFlowPage delete = new DeleteFlowPage(driver);
			delete.deleteflow();
			driver.close();
			
		}
		
		//@Test(dataProvider = "clientdata",priority = 3)
		public void SmartCredit(String data) throws InterruptedException 
		{
			logger = extent.startTest("SmartCredit");
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportSmartCredit importaudit3 = new ImportSmartCredit(driver);
			importaudit3.Clickonimport();
			importaudit3.oneclickimport(data);
			DeleteFlowPage delete = new DeleteFlowPage(driver);
			delete.deleteflow();
			driver.close();
			
		}
		
		
		//@AfterMethod
		//@Parameters("email")
		public void delete() throws InterruptedException 
		{
			DeleteFlowPage delete = new DeleteFlowPage(driver);
			delete.deleteflow();
			driver.close();
		}
		
		@Test(dataProvider = "clientdata")
		public void CRC(String data) throws InterruptedException 
		{
			logger = extent.startTest("CRC");
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
			ImportSampleReport importaudit = new ImportSampleReport(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
			login.hometab.click();
			AddClientPage clientidentityiq = new AddClientPage(driver);
			clientidentityiq.newclient(data);
			ImportMyIdentityIQ importauditidentityiq = new ImportMyIdentityIQ(driver);
			importauditidentityiq.Clickonimport();
			importauditidentityiq.oneclickimport(data);
			login.hometab.click();
			AddClientPage clientmyfreescorenow = new AddClientPage(driver);
			clientmyfreescorenow.newclient(data);
			ImportMyFreeScoreNow importauditmyfreescorenow = new ImportMyFreeScoreNow(driver);
			importauditmyfreescorenow.Clickonimport();
			importauditmyfreescorenow.oneclickimport(data);
			login.hometab.click();
			AddClientPage clientsmartcredit = new AddClientPage(driver);
			clientsmartcredit.newclient(data);
			ImportSmartCredit importauditsmartcredit = new ImportSmartCredit(driver);
			importauditsmartcredit.Clickonimport();
			importauditsmartcredit.oneclickimport(data);
			login.hometab.click();
			AddClientPage clientprivacyguard = new AddClientPage(driver);
			clientprivacyguard.newclient(data);
			ImportPrivacyGuard importauditprivacyguard = new ImportPrivacyGuard(driver);
			importauditprivacyguard.Clickonimport();
			importauditprivacyguard.oneclickimport(data);
			
		}
		
		

}
