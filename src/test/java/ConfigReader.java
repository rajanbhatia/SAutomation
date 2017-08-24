//import java.io.File;
import java.io.FileInputStream;
//import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	public Properties pro; 
	public ConfigReader()
	{
		try {
			/// For Maven
			//String resourceName = "config.properties"; // could also be a constant
			//ClassLoader loader = Thread.currentThread().getContextClassLoader();
			
			//InputStream resourceStream = loader.getResourceAsStream(resourceName); 
			//props.load(resourceStream);
			pro = new Properties();
			///final InputStream stream = this.getClass().getResourceAsStream("config.properties");
			///pro.load(stream);
			
			pro.load(new FileInputStream("./src/main/resources/config.properties"));
			
			
			
		/**File src = new File("./src/main/resources/config.properties"); //Path of the file
		//File src = new File("Config.property"); //Path of the file
		FileInputStream fis = new FileInputStream(src); //Read the file from the source
		pro=new Properties(); //To read the property file, use Properties object
		pro.load(fis);**/
		} catch (Exception e) {
			System.out.println("Exception is: "+e.getMessage());
		}  
	}	
	public String getGeckoPath()
	{
		String path = pro.getProperty("GeckoDriver");
		return path;
	}	
	public String getChromePath()
	{
		String path = pro.getProperty("ChromeDriver");
		return path;
	}	
	public String getApplicationURL()
	{		
		return pro.getProperty("URL");
	}	
	public String getExcelSheetPath()
	{			
		return pro.getProperty("ExcelPath");		
	}
	public String getReportPath()
	{
		
		return pro.getProperty("ExecutionReport");		
	}
	public String getScreenShotPath()
	{
		return pro.getProperty("ScreenshotPath");
	}
	public String getScriptPath(String workflowstatus)
	{
		String path = null;
		if (workflowstatus.equalsIgnoreCase("beforesubmission"))	path= pro.getProperty("ScriptPathbeforesubmission");
		else if (workflowstatus.equalsIgnoreCase("aftersubmission")) 	path= pro.getProperty("ScriptPathaftersubmission");
		return path;
	}
	
	public String getSmokeWorkflowScriptPath()
	{
		return pro.getProperty("SmokeWorkflowScriptPath");
	}
	
	public String getClearanceCheckScriptPath()
	{
		return pro.getProperty("ClearanceCheckScriptPath");
	}
	
	public String getCourseDeleteScriptPath()
	{
		return pro.getProperty("CourseDeleteScriptPath");
	}
	
	public String getCourseWithdrawScriptPath()
	{
		return pro.getProperty("CourseWithdrawScriptPath");
	}
	
}
