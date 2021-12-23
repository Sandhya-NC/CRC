package generic;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseTest implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		try {
			screenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ITestListener.super.onTestFailure(result);
	}
	
}


