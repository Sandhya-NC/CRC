package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import pom.AddClientPage;
import pom.DeleteFlowPage;
import pom.ImportAuditPage;
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
			ImportAuditPage importaudit = new ImportAuditPage(driver);
			importaudit.Clickonimport();
			importaudit.oneclickimport(data);
			DeleteFlowPage delete = new DeleteFlowPage(driver);
			delete.deleteflow(data);
			driver.close();
		}
		

}
