import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;


public class Login {
	//WebDriver driver;
	
	public void login(WebDriver driver, ConfigReader propertyconfig, String flag, String getpassword, String getrpassword, String getemail, String getremail, String getfirstn, String getsecondname, String getothersecondname, String getlastn, String getdob)
	{
	 //String appurl= propertyconfig.getApplicationURL();
		
	    driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
	    if (flag.equals("New"))
	    {
	    	driver.findElement(By.id("NEW_USER")).click();
	    	// Register - Provide Login Details  
		    driver.findElement(By.id("PASSWORD1.IPU.SRS")).clear();
		    driver.findElement(By.id("PASSWORD1.IPU.SRS")).sendKeys(getpassword);
		    driver.findElement(By.id("PASSWORD2.IPU.SRS")).clear();
		    driver.findElement(By.id("PASSWORD2.IPU.SRS")).sendKeys(getrpassword);
		    driver.findElement(By.id("USERCODE.IPU.SRS")).clear();
		    driver.findElement(By.id("USERCODE.IPU.SRS")).sendKeys(getremail);
		  		
		    driver.findElement(By.id("IPU_FNM1.IPU.SRS")).clear();
		    driver.findElement(By.id("IPU_FNM1.IPU.SRS")).sendKeys(getfirstn);
		    
		    driver.findElement(By.id("IPU_FNM2.IPU.SRS")).clear();
		    driver.findElement(By.id("IPU_FNM2.IPU.SRS")).sendKeys(getsecondname);
		    
		    driver.findElement(By.id("IPU_FNM3.IPU.SRS")).clear();
		    driver.findElement(By.id("IPU_FNM3.IPU.SRS")).sendKeys(getothersecondname);
		    
		    driver.findElement(By.id("IPU_SURN.IPU.SRS")).clear();
		    driver.findElement(By.id("IPU_SURN.IPU.SRS")).sendKeys(getlastn);
		    
		    driver.findElement(By.id("IPU_DOB.IPU.SRS")).clear();
		    driver.findElement(By.id("IPU_DOB.IPU.SRS")).sendKeys(getdob);
		      
		    driver.findElement(By.id("IPU_CAEM.IPU.SRS")).clear();
		    driver.findElement(By.id("IPU_CAEM.IPU.SRS")).sendKeys(getemail);
		      
		    driver.findElement(By.id("PROCEED.DUM1.SRS")).click();
	    }
	    else if (flag.equalsIgnoreCase("Existing"))
	    {
	    	driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).click(); //Login button
	    	driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).clear();
	  	    driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).sendKeys(getemail);
	  	    assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Password");
	  	    driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).clear();
	  	    driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).sendKeys(getpassword);
	    	driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS.1\"]")).click();
	
	
	    }
	 	    
	
	}
	
	public void loginStaff(WebDriver driver, ConfigReader propertyconfig, String getemail, String getpassword)
	{
	
	    driver.get(propertyconfig.getApplicationURL());  //URL picked from the Property file
    	driver.findElement(By.xpath("//div[@id='new_user_section']/div/div/div/div[2]/div[2]/div/a")).click(); //Login button
    	driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).clear();
  	    driver.findElement(By.id("MUA_CODE.DUMMY.MENSYS")).sendKeys(getemail);
  	    assertEquals(driver.findElement(By.xpath("//div[2]/label")).getText(), "Password");
  	    driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).clear();
  	    driver.findElement(By.id("PASSWORD.DUMMY.MENSYS")).sendKeys(getpassword);
    	driver.findElement(By.cssSelector("input[name=\"BP101.DUMMY_B.MENSYS.1\"]")).click();
	}
	
}
