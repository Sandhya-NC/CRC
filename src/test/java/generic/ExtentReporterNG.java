package generic;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class ExtentReporterNG 
{
	
		//static ExtentReports extent;
		//static com.relevantcodes.extentreports.ExtentTest test;
//		@BeforeSuite
//		public void beforeSuite() 
//		{
//			extent = new ExtentReports(System.getProperty("user.dir")+"/target/ExtentReport.html");
//			extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
//		}
//		
//		
//		@AfterMethod
//		public void getresult(ITestResult result) 
//		{
//			if(result.getStatus() == ITestResult.FAILURE)
//			{
//				test.log(LogStatus.FAIL, result.getThrowable());
//			}
//			extent.endTest(test);
//		}
//		
//		
//	
//	@AfterTest
//	public static void endTest()
//	{
//		extent.flush();
//	}
	
	    
	

	

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	@BeforeTest
	public void setUp() {

	    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Suite/Extent.html");
	    
	    htmlReporter.config().setDocumentTitle("Automation Report");
	    htmlReporter.config().setReportName("Functional Report");
	    htmlReporter.config().setTheme(Theme.DARK);
	    
	   extent = new ExtentReports();
	   extent.attachReporter(htmlReporter);
	   
	}

//	@AfterMethod
//	public void getResult(ITestResult result) {
//
//	    if (result.getStatus()==ITestResult.FAILURE) {
//
//	        extentTest.fail(MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
//	        extentTest.fail(result.getThrowable());
//	    }
//
//	    else if (result.getStatus()==ITestResult.SUCCESS) {
//
//	        extentTest.pass(MarkupHelper.createLabel(result.getName()+" Test Case Passed", ExtentColor.GREEN));
//	        extentTest.pass(result.getThrowable());
//
//	    }
//
//	    else {
//
//	        extentTest.skip(MarkupHelper.createLabel(result.getName()+" Test Case Skipped", ExtentColor.ORANGE));
//	        extentTest.skip(result.getThrowable());
//
//	    }
//
//
//	}
	
	
	@AfterMethod
	public void getResult(ITestResult result) {

	    if (result.getStatus()==ITestResult.FAILURE) 
	    {
	    	extentTest.log(Status.FAIL, "Testcase Failed is"+result.getName());
	    	extentTest.log(Status.FAIL, "Testcase Failed is"+result.getThrowable());
	    	
	        
	    }

	    else if (result.getStatus()==ITestResult.SUCCESS) 
	    {
	    	extentTest.log(Status.PASS, "Testcase success is"+result.getName());
	        
	    }

	    else if (result.getStatus()==ITestResult.SKIP)  
	    {

	    	extentTest.log(Status.SKIP, "Testcase skipped is"+result.getName());

	    }


	}

	@AfterTest
	public void tearDown() 
	{

	    extent.flush(); 

	}

	
}

