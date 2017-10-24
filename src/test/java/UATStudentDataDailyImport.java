

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class UATStudentDataDailyImport {
	public ExtentTest logger;
	ConfigReader propertyconfig = new ConfigReader();
	public WebDriver driver;
	
	@Test
	public void CallUATStudentDailyImport()
	{
		try
		{
			ReportScreenshotUtility.GetExtent();
			logger = ReportScreenshotUtility.report.startTest("UATStudentDataDailyImport");
			Runtime runtime = Runtime.getRuntime();
			String scriptpath=propertyconfig.getUATStudentDailyImportScriptPath();
			Process p = null;
			p = runtime.exec(scriptpath);
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = input.readLine()) != null) 
			{
			  System.out.println(line);
			  logger.log(LogStatus.INFO,line);
			  int exitCode;
			  exitCode = p.waitFor();  //method waitFor() will make the current thread to wait until the external program finishes and returns the exit value.
			  assertEquals(exitCode, 0); 
			}
		} catch (Exception e) {	
			e.getMessage();
		}		
	}
	
	
	@AfterMethod   //executed after every method. Creating to capture the results of Failure.
	 public void tearD(ITestResult result) throws Exception
	 {
	  if(ITestResult.FAILURE==result.getStatus())// || (exceptionerror.equals("true")))  //Check if Test case has failed
	  {
	  	 String screenshot_path = ReportScreenshotUtility.captureScreenshot(driver,propertyconfig.getScreenShotPath(),result.getName());   //Take screenshot if Test Case fails
	  	
	  	 String image=logger.addScreenCapture(screenshot_path);
	  	 logger.log(LogStatus.FAIL, "Failed", image);
	  	 if(ITestResult.FAILURE==result.getStatus())		logger.log(LogStatus.FAIL, "Exception Message", result.getThrowable());
	  	// if (exceptionerror=="true")  logger.log(LogStatus.FAIL, "Exception Message", errormessage);
	  }
	  else if (ITestResult.SUCCESS==result.getStatus())// && (exceptionerror.equals("false")))   //Check if Test case has passed
	  {
	  	logger.log(LogStatus.PASS, "Passed");	
	  }
	  else if (ITestResult.SKIP==result.getStatus())  //Check if Test case has passed
	  {
		logger.log(LogStatus.SKIP, "Test case Skipped"+result.getThrowable());	
	  }		
		 ReportScreenshotUtility.report.endTest(logger);
		 ReportScreenshotUtility.report.flush();
	 }
	
	
}
