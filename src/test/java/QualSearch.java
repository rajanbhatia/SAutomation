import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class QualSearch 
{
	// Qualification Search
	public Object[][] qualSearchSelection(WebDriver driver, String qualsearchtype, String coursename)
	{
		  new Select(driver.findElement(By.id("SELECTION.CRITERIA.SRS.1-1"))).selectByVisibleText(qualsearchtype);   
		  driver.findElement(By.id("BP102.DUMMY_B.MENSYS")).click();      
		  driver.findElement(By.linkText(coursename)).click();
	
		  assertEquals(driver.findElement(By.cssSelector("h2.sv-panel-title")).getText(), "Apply for the qualification: " + coursename);
	    
		  Object[][] courseoptions = new Object[2][2];	
		  for(int i=0;i<2;i++)   //Initializing Array 
		  {
			for (int j=0;j<2;j++)  //Columns value is one more than the index so less than sign
			{
				courseoptions[i][j]= driver.findElement(By.xpath("//tbody/tr["+(i+1)+"]/td["+(j+1)+"]/span")).getText(); 
				//System.out.println(courseoptions[i][j]+"\n");
			}					
		  }
		 
		//Object courseoptions[][]= courseChoice();
	    driver.findElement(By.name("APPLY.IPO.SRS.1")).click(); //Click Apply button, first listed course
	    return courseoptions;
	
	}
	 
}
