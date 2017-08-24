
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;

//import main.resources.ConfigReader;

public class ReportScreenshotUtility 
{
	public static ExtentReports report;
	private static ConfigReader propertyconfig;
	public static String captureScreenshot (WebDriver driver, String path, String screenshotName)
	{
		try
		{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = path+screenshotName+System.currentTimeMillis()+".png";  //Adding currentTimeMillis to keep different screenshots for the same test case with different data inputs.
		System.out.println(dest);
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		System.out.println("Screenshot taken.");
		return dest;
		}
		catch (Exception e)
		{
			System.out.println("Exception while taking screenshot: "+e.getMessage());
			return e.getMessage();					
		}
	}
	
	public static synchronized ExtentReports GetExtent() 
	{
	    if (report != null) return report;
	    propertyconfig = new ConfigReader(); //Read the Config Property value
	    report = new ExtentReports(System.getProperty("user.dir")+ propertyconfig.getReportPath()); //Set the HTML Execution Report Path. Putting another parameter TRUE will overwrite the file everytime.
	    report.loadConfig(new File(System.getProperty("user.dir")+"/src/main/resources/extent-config.xml")); //Load the config settings frot he report from xml.
	    return report;
	}    
}
