package scripts;

import org.testng.annotations.AfterMethod;
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
		@Test(dataProvider = "clientdata")
		public void CRC(String data) throws InterruptedException 
		{
			LoginPage login = new LoginPage(driver);
			login.LogintoApplication(data);	
			AddClientPage client = new AddClientPage(driver);
			client.newclient(data);
//			ImportSampleReport importaudit = new ImportSampleReport(driver);
//			importaudit.Clickonimport();
//			importaudit.oneclickimport(data);
//			ImportPrivacyGuard importaudit = new ImportPrivacyGuard(driver);
//			importaudit.Clickonimport();
//			importaudit.oneclickimport(data);
//			ImportMyIdentityIQ importaudit = new ImportMyIdentityIQ(driver);
//			importaudit.Clickonimport();
//			importaudit.oneclickimport(data);
//			ImportMyFreeScoreNow importaudit = new ImportMyFreeScoreNow(driver);
//			importaudit.Clickonimport();
//			importaudit.oneclickimport(data);
			ImportSmartCredit importaudit = new ImportSmartCredit(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
//			DeleteFlowPage delete = new DeleteFlowPage(driver);
//			delete.deleteflow(data);
//			driver.close();
			
		}
		
		
		
		

}
